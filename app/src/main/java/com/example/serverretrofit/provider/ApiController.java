package com.example.serverretrofit.provider;

import com.example.serverretrofit.model.response.AllCharacters;
import com.example.serverretrofit.model.response.Character;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {
    private int page = 1;
    private final Retrofit retrofit;
    private final CharacterService service;

    public void incPage() {
        ++page;
    }

    public ApiController() {
        this.retrofit = new Retrofit
                .Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        this.service = retrofit.create(CharacterService.class);
    }

    public List<Character> GetAllCharacters() {
        Call<AllCharacters> request = service.getAllCharacters(page);
        try {
            Response<AllCharacters> response = request.execute();
            if(response.isSuccessful() && response.body() != null) {
                return response.body().results;
            } else {
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }

}
