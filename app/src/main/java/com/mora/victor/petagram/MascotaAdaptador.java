package com.mora.victor.petagram;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by thor0 on 14-May-17.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>
{

    private ArrayList<Mascota> mascotas;

    public MascotaAdaptador(ArrayList<Mascota> listaMascotas){
        mascotas = listaMascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.nombreMascota.setText(mascota.getName());
        int likes = mascota.getLikesCount();
        holder.likesCount.setText(Integer.toString(likes));
        holder.petImage.setImageResource(mascota.getImage());

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

        public MascotaViewHolder(View itemView) {
            super(itemView);

            //inicializar las referencias a los elementos del view

            petImage = (ImageView)itemView.findViewById(R.id.petImage);
            nombreMascota =(TextView)itemView.findViewById(R.id.tvNombreMascota);
            likesCount = (TextView)itemView.findViewById(R.id.tvLikesCount);

        }
    }

}
