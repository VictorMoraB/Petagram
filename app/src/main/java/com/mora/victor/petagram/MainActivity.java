package com.mora.victor.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mora.victor.petagram.adapters.MascotaAdaptador;
import com.mora.victor.petagram.adapters.PageAdapter;
import com.mora.victor.petagram.fragments.MiMascotaFragment;
import com.mora.victor.petagram.fragments.RecyclerMascotaFragment;
import com.mora.victor.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar myActionbar;
    private ImageView icEstrella;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myActionbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(myActionbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        //obtener una referencia al icono de navegar a favoritos y configurar el event listener
        icEstrella = (ImageView)findViewById(R.id.ic_star);
        icEstrella.setOnClickListener(this);

        setupViewPager();

    }

    private void setupViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragmentos()));
        tabLayout.setupWithViewPager(viewPager);
        //setup the tab icons
    }

    private ArrayList<Fragment> agregarFragmentos(){
        ArrayList<Fragment> fragmentos = new ArrayList<>();
        fragmentos.add(new RecyclerMascotaFragment());
        fragmentos.add(new MiMascotaFragment());
        return fragmentos;
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

        getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }

    private void accionContactar(){

        Intent intent = new Intent(this, ContactarActivity.class);
        startActivity(intent);
    }

    private void accionAcerca(){
        //crear un intent para ir a la nueva actividad
        Intent intent = new Intent(this, bio_desarrolador.class);
        startActivity(intent);
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
