package com.mora.victor.petagram.fragments;


import android.os.Bundle;
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
import com.mora.victor.petagram.presentador.RecyclerMascotaFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerMascotaFragment extends Fragment implements IRecyclerMascotaView {

    private RecyclerView rvMascotas;
    private ArrayList<Mascota> mascotas;

    private IRecyclerMascotaFragmentPresenter presenter;


    public RecyclerMascotaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.recycler_fragment, container, false);

        //obtener una referencia al rv de las mascotas
        rvMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);

        presenter = new RecyclerMascotaFragmentPresenter(this, getContext());

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



    /*
    private ArrayList<Mascota> crearMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        Mascota elefante = new Mascota("Dumbo", R.drawable.elephant, 1);
        mascotas.add(elefante);

        Mascota jirafa = new Mascota("Manchas", R.drawable.giraffe, 3);
        mascotas.add(jirafa);

        Mascota hipo = new Mascota("Hipo", R.drawable.hippo, 2);
        mascotas.add(hipo);

        Mascota mono = new Mascota("CariBlanca", R.drawable.monkey,4);
        mascotas.add(mono);

        Mascota panda = new Mascota("KungFu Master", R.drawable.panda, 9);
        mascotas.add(panda);

        Mascota perico = new Mascota("Metal Parrot", R.drawable.parrot, 15);
        mascotas.add(perico);

        Mascota pinguino = new Mascota("Pipo", R.drawable.penguin, 4);
        mascotas.add(pinguino);

        Mascota puerquito = new Mascota("Babe el valiente", R.drawable.pig, 19);
        mascotas.add(puerquito);

        Mascota conejo = new Mascota("Brinquitos", R.drawable.rabbit, 7);
        mascotas.add(conejo);

        Mascota python = new Mascota("Monty Python", R.drawable.snake, 798);
        mascotas.add(python);

        return mascotas;
    }
*/
}
