package com.mora.victor.petagram.presentador;

import android.content.Context;

import com.mora.victor.petagram.db.ConstructorMascotas;
import com.mora.victor.petagram.fragments.IRecyclerMascotaView;
import com.mora.victor.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Victor on 29-May-17.
 */

public class RecyclerMascotaFragmentPresenter implements IRecyclerMascotaFragmentPresenter {


    private IRecyclerMascotaView iRecyclerMascotaView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerMascotaFragmentPresenter(IRecyclerMascotaView iRecyclerMascotaView, Context context){
        this.iRecyclerMascotaView = iRecyclerMascotaView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {

        iRecyclerMascotaView.inicializarAdaptadorRV(
                iRecyclerMascotaView.crearAdaptador(mascotas)
        );

        iRecyclerMascotaView.generarLinearLayout();

    }
}
