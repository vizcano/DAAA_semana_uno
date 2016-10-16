package com.jose.petagramws.restApi;

import com.jose.petagramws.restApi.model.FollowersResponse;
import com.jose.petagramws.restApi.model.PerfilResponse;
import com.jose.petagramws.restApi.model.SearchResponse;
import com.jose.petagramws.restApi.model.TimelineResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER_ID)
    Call<PerfilResponse> getRecentMediaUserID(@Path("id") String id);

    @GET(ConstantesRestApi.URL_SEARCH_USER)
    Call<SearchResponse> getUsuarioBusqueda(@Query("q") String jack, @Query("access_token") String access_token);

    @GET(ConstantesRestApi.URL_USER_FOLLOWS)
    Call<FollowersResponse> getUsuarioFollows(@Query("access_token") String access_token);

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER_ID)
    Call<TimelineResponse> getRecentMediaTimeline(@Path("id") String id);

}
