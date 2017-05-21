package com.mora.victor.petagram.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mora.victor.petagram.R;
import com.mora.victor.petagram.pojo.Foto;
import com.mora.victor.petagram.pojo.Mascota;

/**
 * Created by Victor on 20-May-17.
 */

public class GaleriaAdaptador extends RecyclerView.Adapter<GaleriaAdaptador.FotoViewHolder> {


    private Mascota MiMascota;
    private Activity activity;

    public GaleriaAdaptador(Mascota miMascota, Activity parentActivity){
        MiMascota = miMascota;
        activity = parentActivity;
    }


    @Override
    public FotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.cardview_foto_mascota, parent, false);

        return new FotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FotoViewHolder holder, int position) {

        final Foto miFoto = MiMascota.getFotosGaleria().get(position);

        holder.tvLikesCount.setText(Integer.toString(miFoto.getLikesCount()));
        holder.ivPerfil.setImageResource(miFoto.getImage());
    }

    @Override
    public int getItemCount() {
        return MiMascota.getFotosGaleria().size();
    }


    //clase view holder
    public static class FotoViewHolder extends RecyclerView.ViewHolder
    {

        private ImageView ivPerfil;
        private TextView tvLikesCount;

        public FotoViewHolder(View itemView) {
            super(itemView);

            ivPerfil = (ImageView)itemView.findViewById(R.id.ivFotoMascota);
            tvLikesCount = (TextView)itemView.findViewById(R.id.tvFotoLikesCount);
        }
    }
}
