package com.mora.victor.petagram.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mora.victor.petagram.R;
import com.mora.victor.petagram.adapters.GaleriaAdaptador;
import com.mora.victor.petagram.pojo.Mascota;


public class MiMascotaFragment extends Fragment {

    private RecyclerView rvGaleria;
    private Mascota MiMascota;

    public MiMascotaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mi_mascota, container, false);

        rvGaleria = (RecyclerView)v.findViewById(R.id.rvFotos);
        CrearMiMascota();

        //crear un gridlayou para mostrar las imagenes
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        GridLayoutManager glm = new GridLayoutManager(getContext(),3);
        GaleriaAdaptador adaptador = new GaleriaAdaptador(MiMascota,getActivity());
        rvGaleria.setLayoutManager(glm);
        rvGaleria.setAdapter(adaptador);
        return v;
    }


    private void CrearMiMascota(){

       Mascota python = new Mascota("Monty Python", R.drawable.snake, 798);
       MiMascota = python;
    }

}
