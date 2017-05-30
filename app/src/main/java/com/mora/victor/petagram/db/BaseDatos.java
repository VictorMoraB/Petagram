package com.mora.victor.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mora.victor.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Victor on 29-May-17.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context){

        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABSE_VERSION);
        this.context = context;
    }


    public void darLikeMascota(ContentValues contentValues){

        SQLiteDatabase db = getWritableDatabase();
        try {
            db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        }finally {
            db.close();
        }
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);


        }
        catch (Exception ex){
            ex.getMessage();
        }
        finally {
            db.close();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE   + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN     + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_COUNT    + " INTEGER " +
                ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + " INTEGER, " +
                 "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                ")";


        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //usado para realizar migraciones, de momento no se usara
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() {

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            Cursor cursor = db.rawQuery(query, null);
            while (cursor.moveToNext()){
                Mascota mascotaActual = new Mascota();
                mascotaActual.setId(cursor.getInt(0));
                mascotaActual.setName(cursor.getString(1));
                mascotaActual.setImage(cursor.getInt(2));
                mascotaActual.setLikesCount(cursor.getInt(3));
                mascotas.add(mascotaActual);

                //obtener los datos de la tabla de likes

                String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_ID +
                        ")" + " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                        " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + " = " +
                        mascotaActual.getId();

                Cursor registrosLike = db.rawQuery(queryLikes, null);
                if(registrosLike.moveToNext()){
                    mascotaActual.setLikesCount(registrosLike.getInt(0));
                }
            }

        }finally {
            db.close();
        }


        return  mascotas;
    }

    public int obtenerLikesMascota(Mascota mascota) {
        int likes = 0;

        String query = "SELECT COUNT(" +  ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + "= " + mascota.getId();
        SQLiteDatabase db = getWritableDatabase();
        try{
            Cursor registros = db.rawQuery(query, null);
            if(registros.moveToNext()){
                likes = registros.getInt(0);
            }
        }finally {
            db.close();
        }
        return likes;
    }
}
