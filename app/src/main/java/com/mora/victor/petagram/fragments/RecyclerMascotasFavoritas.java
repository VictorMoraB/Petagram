package com.mora.victor.petagram.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mora.victor.petagram.R;
import com.mora.victor.petagram.adapters.MascotaAdaptador;
import com.mora.victor.petagram.pojo.Mascota;
import com.mora.victor.petagram.presentador.IRecyclerMascotaFragmentPresenter;
import com.mora.victor.petagram.presentador.RecyclerFavoritasFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Victor on 29-May-17.
 */

public class RecyclerMascotasFavoritas extends Fragment implements IRecyclerMascotaView {

    private RecyclerView rvMascotas;
    private ArrayList<Mascota> favoritas;
    private IRecyclerMascotaFragmentPresenter presenter;
    public RecyclerMascotasFavoritas(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflate the layout of this fragment
        View v = inflater.inflate(R.layout.recycler_fragment, container, false);
        //obtener una referencia al rv de mascotas
        rvMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);

        presenter = new RecyclerFavoritasFragmentPresenter(this, getContext());

        return v;
    }


    @Override
    public void generarLinearLayout() {

        //crear un layout para controlar la forma en que se mostraran las mascotas
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {

        //crear un adaptador con los contactos
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return  adaptador;

    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
