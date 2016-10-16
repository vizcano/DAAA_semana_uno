package com.jose.petagramws.presentador;

import android.content.Context;

import com.jose.petagramws.db.ConstructorMascotas;
import com.jose.petagramws.pojo.Mascota;
import com.jose.petagramws.fragments.IFavoritos;

import java.util.ArrayList;

public class FavoritosPresenter implements IFavoritosPresenter {

    private IFavoritos iFavoritos;
    private Context context;
    ConstructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotas;

    public FavoritosPresenter(IFavoritos iFavoritos, Context context) {
        this.iFavoritos = iFavoritos;
        this.context = context;
        obtenerFavoritosBaseDatos();
    }

    @Override
    public void obtenerFavoritosBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarFavoritos();
    }

    @Override
    public void mostrarFavoritos() {
        iFavoritos.inicializarAdaptadorRV(iFavoritos.crearAdaptador(mascotas));
        iFavoritos.generarLinealLayoutVertical();
        iFavoritos.generarToolbar();
    }
}
