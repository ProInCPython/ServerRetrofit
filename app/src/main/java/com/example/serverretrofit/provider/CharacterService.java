package com.example.serverretrofit.provider;

import com.example.serverretrofit.model.response.AllCharacters;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CharacterService {
    @GET("character")
    Call<AllCharacters> getAllCharacters(@Query("page") int page);
}
