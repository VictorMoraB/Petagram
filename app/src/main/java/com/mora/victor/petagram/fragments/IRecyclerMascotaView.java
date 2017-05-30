package com.mora.victor.petagram.fragments;

import com.mora.victor.petagram.adapters.MascotaAdaptador;
import com.mora.victor.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Victor on 29-May-17.
 */

public interface IRecyclerMascotaView {

    public void generarLinearLayout();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
