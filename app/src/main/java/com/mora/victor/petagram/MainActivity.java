package com.mora.victor.petagram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar myActionbar;
    private RecyclerView rvMascotas;
    private ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myActionbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(myActionbar);

        //obtener una referencia al rv de las mascotas
        rvMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        //crear una lista de mascotas para usar como ejemplo
        mascotas = crearMascotas();

        //crear un layout manager para el recycler view
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //crear un adaptador con los contactos
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotas.setLayoutManager(llm);
        rvMascotas.setAdapter(adaptador);

    }

    public void UpdateAdapter(){
        this.rvMascotas.getAdapter().notifyDataSetChanged();
    }
    private ArrayList<Mascota> crearMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        Mascota elefante = new Mascota("Dumbo", R.drawable.elephant, 1);
        mascotas.add(elefante);

        Mascota jirafa = new Mascota("Manchas", R.drawable.giraffe, 3);
        mascotas.add(jirafa);

        Mascota hipo = new Mascota("Hipo", R.drawable.hippo, 2);
        mascotas.add(hipo);

        Mascota mono = new Mascota("CariBlanca", R.drawable.monkey,4);
        mascotas.add(mono);

        Mascota panda = new Mascota("KungFu Master", R.drawable.panda, 9);
        mascotas.add(panda);

        Mascota perico = new Mascota("Metal Parrot", R.drawable.parrot, 15);
        mascotas.add(perico);

        Mascota pinguino = new Mascota("Pipo", R.drawable.penguin, 4);
        mascotas.add(pinguino);

        Mascota puerquito = new Mascota("Babe el valiente", R.drawable.pig, 19);
        mascotas.add(puerquito);

        Mascota conejo = new Mascota("Brinquitos", R.drawable.rabbit, 7);
        mascotas.add(conejo);

        Mascota python = new Mascota("Monty Python", R.drawable.snake, 798);

        return mascotas;
    }
}
