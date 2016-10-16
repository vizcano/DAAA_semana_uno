package com.jose.petagramws.fragments;

import com.jose.petagramws.adaptadores.MascotaAdaptador;
import com.jose.petagramws.pojo.Mascota;

import java.util.ArrayList;

public interface IInicioPet {

    public void generarGridLayout();
    public MascotaAdaptador crearAdaptadorTimeline(ArrayList<Mascota> mascota);
    public void iniciarAdaptadorRVTimeline(MascotaAdaptador adaptador);
}
