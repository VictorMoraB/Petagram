package com.mora.victor.petagram.presentador;

import android.content.Context;

import com.mora.victor.petagram.db.ConstructorMascotas;
import com.mora.victor.petagram.fragments.IRecyclerMascotaView;
import com.mora.victor.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Victor on 29-May-17.
 */

public class RecyclerFavoritasFragmentPresenter implements IRecyclerMascotaFragmentPresenter {

    private IRecyclerMascotaView iRecyclerMascotaView;
    private Context context;
    private ArrayList<Mascota> favoritas;
    private ConstructorMascotas constructorMascotas;

    public RecyclerFavoritasFragmentPresenter(IRecyclerMascotaView iRecyclerMascotaView, Context context){
        this.iRecyclerMascotaView = iRecyclerMascotaView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        favoritas = constructorMascotas.obtenerMascotasFavoritas();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerMascotaView.inicializarAdaptadorRV(
                iRecyclerMascotaView.crearAdaptador(favoritas)
        );

        iRecyclerMascotaView.generarLinearLayout();
    }
}
