package com.mora.victor.petagram.db;

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

    public ArrayList<Mascota> obtenerMascotasFavoritas() {

        ArrayList<Mascota> mascotas = new ArrayList<>();

        Mascota python = new Mascota("Monty Python", R.drawable.snake, 999);
        mascotas.add(python);

        Mascota puerquito = new Mascota("Babe el valiente", R.drawable.pig, 19);
        mascotas.add(puerquito);

        Mascota perico = new Mascota("Metal Parrot", R.drawable.parrot, 15);
        mascotas.add(perico);

        Mascota panda = new Mascota("KungFu Master", R.drawable.panda, 9);
        mascotas.add(panda);


        Mascota conejo = new Mascota("Brinquitos", R.drawable.rabbit, 7);
        mascotas.add(conejo);

        return  mascotas;
    }
}
