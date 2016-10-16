package com.jose.petagramws.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jose.petagramws.pojo.Followers;
import com.jose.petagramws.pojo.Mascota;
import com.jose.petagramws.restApi.ConstantesRestApi;
import com.jose.petagramws.restApi.EndpointsApi;
import com.jose.petagramws.restApi.adapter.RestApiAdapter;
import com.jose.petagramws.restApi.model.FollowersResponse;
import com.jose.petagramws.restApi.model.TimelineResponse;
import com.jose.petagramws.fragments.IInicioPet;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InicioPetPresenter implements IInicioPetPresenter {

    //Declarando Variables que se ocuparan
    private static final String TAG = "Seguidores";
    IInicioPet iInicioPet;
    Context context;
    ArrayList<Mascota> mascotas;
    ArrayList<Followers> followers;

    public InicioPetPresenter(IInicioPet iInicioPet, Context context) {
        this.iInicioPet = iInicioPet;
        this.context = context;
        getFollowers();
    }

    @Override
    public void mostrarRecentMedioRV() {
        iInicioPet.iniciarAdaptadorRVTimeline(iInicioPet.crearAdaptadorTimeline(mascotas));
        iInicioPet.generarGridLayout();
    }

    @Override
    public void getFollowers() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.construyeGsonDeserializadorFollowers();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionInicial(gson);
        followers = new ArrayList<>();
        Call<FollowersResponse> followersResponseCall = endpointsApi.getUsuarioFollows(ConstantesRestApi.ACCESS_TOKEN);
        followersResponseCall.enqueue(new Callback<FollowersResponse>() {
            @Override
            public void onResponse(Call<FollowersResponse> call, Response<FollowersResponse> response) {
                FollowersResponse followersResponse = response.body();
                followers = followersResponse.getCuenta();
                String UsuarioFollowers = followers.get(0).getUsuario().toString(); //DEbug
                Log.println(Log.ASSERT, TAG, followers.get(0).getId()); //Debug
                getRecentMediaFollowers();
            }
            @Override
            public void onFailure(Call<FollowersResponse> call, Throwable t) {
                Toast.makeText(context, "Perfil: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void getRecentMediaFollowers() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.construyendoGsonDeserializadoTimeline();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionInicial(gson);
        mascotas = new ArrayList<>();

        for (int i = 0; i < followers.size() ; i++) {
            String idFollower = followers.get(i).getId();
            Call<TimelineResponse> timelineResponseCall = endpointsApi.getRecentMediaTimeline(idFollower);
            timelineResponseCall.enqueue(new Callback<TimelineResponse>() {
                @Override
                public void onResponse(Call<TimelineResponse> call, Response<TimelineResponse> response) {
                    TimelineResponse timelineResponse = response.body();
                    mascotas = timelineResponse.getMascotas();
                    mostrarRecentMedioRV();
                }

                @Override
                public void onFailure(Call<TimelineResponse> call, Throwable t) {
                    Toast.makeText(context, "Perfil: " + t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
