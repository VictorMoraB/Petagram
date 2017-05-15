package com.mora.victor.petagram;

import android.support.v7.widget.RecyclerView;
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

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {

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
