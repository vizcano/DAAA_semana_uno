package com.jose.petagramws.restApi.model;

import com.jose.petagramws.pojo.Mascota;

import java.util.ArrayList;

public class TimelineResponse {
    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
