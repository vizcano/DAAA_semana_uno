package com.jose.petagramws.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jose.petagramws.restApi.ConstantesRestApi;
import com.jose.petagramws.restApi.EndpointsApi;
import com.jose.petagramws.restApi.deserializador.FollowersDeserializador;
import com.jose.petagramws.restApi.deserializador.PerfilDeserializador;
import com.jose.petagramws.restApi.deserializador.SearchDeserializador;
import com.jose.petagramws.restApi.deserializador.TimelineDeserializador;
import com.jose.petagramws.restApi.model.FollowersResponse;
import com.jose.petagramws.restApi.model.PerfilResponse;
import com.jose.petagramws.restApi.model.SearchResponse;
import com.jose.petagramws.restApi.model.TimelineResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndpointsApi establecerConexionInicial(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyendoDeserializadorBusqueda(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SearchResponse.class, new SearchDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializandoFotosPerfil(){
        //Ayuda a Asociar lo que deserialize al contactoREsponse
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PerfilResponse.class, new PerfilDeserializador());
        //Regresando el gson Deserializado
        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorFollowers(){
        ////Ayuda a Asociar lo que deserialize al FollowersResponse
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(FollowersResponse.class, new FollowersDeserializador());
        //Regresando el gson Deserializado
        return gsonBuilder.create();
    }

    public Gson construyendoGsonDeserializadoTimeline(){
        //Ayuda a Asociar lo que deserialize al TimelineResponse
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(TimelineResponse.class, new TimelineDeserializador());
        //Regresando el gson Deserializado
        return gsonBuilder.create();
    }

}
