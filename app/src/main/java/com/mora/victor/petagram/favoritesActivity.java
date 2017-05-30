package com.mora.victor.petagram;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mora.victor.petagram.adapters.MascotaAdaptador;
import com.mora.victor.petagram.fragments.RecyclerMascotaFragment;
import com.mora.victor.petagram.fragments.RecyclerMascotasFavoritas;
import com.mora.victor.petagram.pojo.Mascota;

import java.util.ArrayList;

public class favoritesActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar myActionbar;
     private ArrayList<Mascota> mascotas;
    private TextView tituloActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        myActionbar = (Toolbar) findViewById(R.id.miActionBarFavorites);
        setSupportActionBar(myActionbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Cambiar el mensaje del action bar del por defecto al de esta actividad
        tituloActionBar = (TextView)findViewById(R.id.tituloActionBar);
        tituloActionBar.setText(getString(R.string.titulo_actionBar_fav));

        //remover la estrella usada para ir a favoritos
        ImageView estrella = (ImageView)myActionbar.findViewById(R.id.ic_star);
        ((ViewGroup) estrella.getParent()).removeView(estrella);

        //insertar el fragmento recycler view de las mascotas favoritas
        RecyclerMascotasFavoritas fragment = new RecyclerMascotasFavoritas();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentRecyclerFavoritas, fragment);
        fragmentTransaction.commit();



    }

    private Fragment crearFragmentoFavoritos(){
        return new RecyclerMascotaFragment();
    }



    private ArrayList<Mascota> crearMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        Mascota python = new Mascota("Monty Python", R.drawable.snake, 798);
        mascotas.add(python);

        Mascota puerquito = new Mascota("Babe el valiente", R.drawable.pig, 19);
        mascotas.add(puerquito);

        Mascota perico = new Mascota("Metal Parrot", R.drawable.parrot, 15);
        mascotas.add(perico);

        Mascota panda = new Mascota("KungFu Master", R.drawable.panda, 9);
        mascotas.add(panda);


        Mascota conejo = new Mascota("Brinquitos", R.drawable.rabbit, 7);
        mascotas.add(conejo);

        return mascotas;
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

    }


}
