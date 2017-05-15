package com.mora.victor.petagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by thor0 on 14-May-17.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>
{

    private ArrayList<Mascota> mascotas;
    private Activity actividad;

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

    public  static  class MascotaViewHolder extends RecyclerView.ViewHolder
    {

        private ImageView petImage;
        private TextView nombreMascota;
        private TextView likesCount;
        private ImageView huesoLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            //inicializar las referencias a los elementos del view

            petImage = (ImageView)itemView.findViewById(R.id.petImage);
            nombreMascota =(TextView)itemView.findViewById(R.id.tvNombreMascota);
            likesCount = (TextView)itemView.findViewById(R.id.tvLikesCount);
            huesoLike = (ImageView)itemView.findViewById(R.id.icGustar);

        }
    }

}
