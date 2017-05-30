package com.mora.victor.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.mora.victor.petagram.R;
import com.mora.victor.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Victor on 29-May-17.
 */

public class ConstructorMascotas {

    private Context context;
    public ConstructorMascotas(Context context){this.context = context;}

    public ArrayList<Mascota> obtenerDatos() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        Mascota elefante = new Mascota("Dumbo", R.drawable.elephant, 1);
        mascotas.add(elefante);

        Mascota jirafa = new Mascota("Manchas", R.drawable.giraffe, 3);
        mascotas.add(jirafa);

        Mascota hipo = new Mascota("Hipo", R.drawable.hippo, 2);
        mascotas.add(hipo);

        return mascotas;
    }


    public void insertarCincoFavoritas(BaseDatos db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Monty Python");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.snake);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_COUNT, 1);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Babe el valiente");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.pig);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_COUNT, 1);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Metal Parrot");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.parrot);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_COUNT, 1);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "KungFu Master");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.panda);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_COUNT, 1);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Brinquitos");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.rabbit);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES_COUNT, 1);
        db.insertarMascota(contentValues);
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas() {

        BaseDatos db = new BaseDatos(context);
        //revisar si la base de datos ya tiene los 5 favoritos, si no, crearlos
        ArrayList<Mascota> mascotas;
        try{
            mascotas = db.obtenerTodasLasMascotas();
            if(mascotas.size() == 0){
                insertarCincoFavoritas(db);
            }
        } catch (Exception ex){insertarCincoFavoritas(db);}



        mascotas = db.obtenerTodasLasMascotas();

        return mascotas;
    }
}
