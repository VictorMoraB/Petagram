package com.mora.victor.petagram;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class bio_desarrolador extends AppCompatActivity implements View.OnClickListener {

    private Toolbar myActionbar;
    private TextView tituloActionBar;
    private ImageView iconoEmail;
    private ImageView iconoTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_desarrolador);

        //obtener el action bar
        myActionbar = (Toolbar)findViewById(R.id.miActionBarBio);
        setSupportActionBar(myActionbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Cambiar el mensaje del action bar del por defecto al de esta actividad
        tituloActionBar = (TextView)findViewById(R.id.tituloActionBar);
        tituloActionBar.setText(getString(R.string.titulo_actionBar_bio));
        //habiliatar la navegacion de regreso al padre
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //obtener referencia a los iconos de contacto de email y telefono, configurar event listener
        iconoEmail = (ImageView)findViewById(R.id.ivContactoEmail);
        iconoEmail.setOnClickListener(this);

        iconoTelefono = (ImageView)findViewById(R.id.ivContactoTele);
        iconoTelefono.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId){
            case R.id.ivContactoEmail:
                ContactoEmail();
                break;
            case R.id.ivContactoTele:
                ContactoTelefono();
                break;
        }
    }

    //eventos de contacto simples, un toast para muestra
    private  void ContactoEmail(){
        Toast.makeText(this, getString(R.string.contacto_email_bio), Toast.LENGTH_SHORT).show();
    }

    private void ContactoTelefono(){
        Toast.makeText(this, getString(R.string.contacto_tele_bio), Toast.LENGTH_SHORT).show();
    }
}
