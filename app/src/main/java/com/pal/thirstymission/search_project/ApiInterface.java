package com.pal.thirstymission.search_project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("getproject.php")
    Call<List<Projects>> getPro(
            @Query("key") String key
    );
}