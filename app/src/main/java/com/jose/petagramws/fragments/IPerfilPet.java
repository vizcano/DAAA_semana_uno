package com.jose.petagramws.fragments;

import com.jose.petagramws.adaptadores.FotosPerfilAdaptador;
import com.jose.petagramws.pojo.Followers;
import com.jose.petagramws.pojo.Mascota;

import java.util.ArrayList;

public interface IPerfilPet {

    //Generando el Layout Lineal Vertical
    public void generarGridLayout();

    public FotosPerfilAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(FotosPerfilAdaptador adaptador);

    public  void crearImagenPerfil(Followers profileUser);

}
