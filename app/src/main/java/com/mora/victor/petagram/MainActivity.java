package com.mora.victor.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar myActionbar;
    private RecyclerView rvMascotas;
    private ImageView icEstrella;
    private ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myActionbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(myActionbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        //obtener una referencia al rv de las mascotas
        rvMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        //crear una lista de mascotas para usar como ejemplo
        mascotas = crearMascotas();

        //obtener una referencia al icono de navegar a favoritos y configurar el event listener
        icEstrella = (ImageView)findViewById(R.id.ic_star);
        icEstrella.setOnClickListener(this);

        //crear un layout manager para el recycler view
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //crear un adaptador con los contactos
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotas.setLayoutManager(llm);
        rvMascotas.setAdapter(adaptador);




    }

    //configurar el menu de la barra de acciones y los efectos de la seleccion del touch

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //crear nuestro propio menu inflando el xml de menu definido
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mAcerca:
                accionAcerca();
                break;
            case R.id.mContacto:
                accionContactar();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //crear elementos de contexto
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //was this deleted???
        //MenuInflater inflater = new MenuInflater(this);
        getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }

    private void accionContactar(){

    }

    private void accionAcerca(){

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
        mascotas.add(python);

        return mascotas;
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

        switch (viewId){
            case R.id.ic_star:
                IrAFavoritos();
                break;
        }
    }

    public void IrAFavoritos(){

        Intent intentFavoritos = new Intent(this, favoritesActivity.class);
        startActivity(intentFavoritos);


    }
}
