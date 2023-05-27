package com.kgpsofts.tech.yalla.network.api;

import com.kgpsofts.tech.yalla.network.model.InputData;
import com.kgpsofts.tech.yalla.network.model.TranslateResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestInterfaces {
//    @FormUrlEncoded
    @POST("translate")
    Call<TranslateResponse> transalteToYala(@Body InputData input);
}
