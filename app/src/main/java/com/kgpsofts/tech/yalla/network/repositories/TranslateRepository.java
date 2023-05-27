package com.kgpsofts.tech.yalla.network.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kgpsofts.tech.yalla.network.api.RestInterfaces;
import com.kgpsofts.tech.yalla.network.model.InputData;
import com.kgpsofts.tech.yalla.network.model.TranslateResponse;


import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TranslateRepository {

//    private static final String BASE_URL = "http://192.168.64.210:6007/api/v1/";
    private static final String BASE_URL = "https://yalaapi.herokuapp.com/api/v1/";

    private RestInterfaces restInterfaces;
    private MutableLiveData<TranslateResponse> translateResponseLiveData;

    public TranslateRepository() {

        translateResponseLiveData = new MutableLiveData<>();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit = builder.client(httpClient.build()).build();

        restInterfaces =  retrofit.create(RestInterfaces.class);
    }

    public void transalteToYala(InputData input) {
        restInterfaces.transalteToYala(input)
                .enqueue(new Callback<TranslateResponse>() {
                    @Override
                    public void onResponse(Call<TranslateResponse> call, Response<TranslateResponse> response) {
                        if (response.body() != null) {
                            translateResponseLiveData.postValue(response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<TranslateResponse> call, Throwable t) {
                        translateResponseLiveData.postValue(null);
                    }
                });
    }

    public LiveData<TranslateResponse> getTranslateResponseLiveData() {
        return translateResponseLiveData;
    }
}
