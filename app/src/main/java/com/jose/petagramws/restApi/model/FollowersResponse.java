package com.jose.petagramws.restApi.model;

import com.jose.petagramws.pojo.Followers;

import java.util.ArrayList;

public class FollowersResponse {
   ArrayList<Followers> cuenta;

    public ArrayList<Followers> getCuenta() {
        return cuenta;
    }

    public void setCuenta(ArrayList<Followers> cuenta) {
        this.cuenta = cuenta;
    }
}
