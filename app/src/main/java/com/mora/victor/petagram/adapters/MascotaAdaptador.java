package com.mora.victor.petagram.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mora.victor.petagram.R;
import com.mora.victor.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by thor0 on 14-May-17.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>
    implements View.OnCreateContextMenuListener
{

    private ArrayList<Mascota> mascotas;
    private Activity actividad;
    private Menu myContext;

    public MascotaAdaptador(ArrayList<Mascota> listaMascotas, Activity miActivity){
        mascotas = listaMascotas;
        actividad = miActivity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, final int position) {
        final Mascota mascota = mascotas.get(position);
        holder.nombreMascota.setText(mascota.getName());
        int likes = mascota.getLikesCount();
        holder.likesCount.setText(Integer.toString(likes));
        holder.petImage.setImageResource(mascota.getImage());

        //obtener una referencia al icono dorado de la cuenta de likes para mostrar un menu
        // de contexto, esto es para prueba y practica

        holder.huesoDorado.setOnCreateContextMenuListener(this);

        //evento on click para dar like
        holder.huesoLike.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //incrementar los likes en 1
                mascota.setLikesCount(mascota.getLikesCount()+1);
                //mostrar un mensaje de notificacion al usuario
                Toast.makeText(actividad, "Diste like a " + mascota.getName() + "!",
                        Toast.LENGTH_SHORT).show();

                notifyItemChanged(position);

            }
        });


    }

    @Override
    public int getItemCount() { //cantidad de elementos en la lista
        return mascotas.size();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater inflater = new MenuInflater(v.getContext());
        inflater.inflate(R.menu.menu_contexto, menu);

        //configurar los event handlers de cada elemento del menu
        menu.findItem(R.id.mEditar).setOnMenuItemClickListener(onEditMenu);
        menu.findItem(R.id.mEliminar).setOnMenuItemClickListener(onDeleteMenu);

    }

    //methods to handle each event from the menu

    private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Toast.makeText(actividad, "Menu de contexto Editar!", Toast.LENGTH_SHORT).show();
            return true;
        }
    };

    private final MenuItem.OnMenuItemClickListener onDeleteMenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Toast.makeText(actividad, "Menu de contexto Eliminar!", Toast.LENGTH_SHORT).show();
            return true;
        }
    };


    public  static  class MascotaViewHolder extends RecyclerView.ViewHolder
    {

        private ImageView petImage;
        private TextView nombreMascota;
        private TextView likesCount;
        private ImageView huesoLike;
        private ImageView huesoDorado;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            //inicializar las referencias a los elementos del view

            petImage = (ImageView)itemView.findViewById(R.id.petImage);
            nombreMascota =(TextView)itemView.findViewById(R.id.tvNombreMascota);
            likesCount = (TextView)itemView.findViewById(R.id.tvLikesCount);
            huesoLike = (ImageView)itemView.findViewById(R.id.icGustar);
            huesoDorado = (ImageView)itemView.findViewById(R.id.icCuentaLikes);

        }


    }

}
