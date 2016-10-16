package com.jose.petagramws.fragments;

import com.jose.petagramws.adaptadores.MascotaAdaptador;
import com.jose.petagramws.pojo.Mascota;

import java.util.ArrayList;

public interface IFavoritos {

    //Generando el Layout Lineal Vertical
    public void generarLinealLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

    public void generarToolbar();
}
