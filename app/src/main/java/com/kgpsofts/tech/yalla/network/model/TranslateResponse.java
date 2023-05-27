package com.kgpsofts.tech.yalla.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TranslateResponse {
    @SerializedName("english")
    @Expose
    private String english;

    @SerializedName("yala")
    @Expose
    private String yala;

    public TranslateResponse(String english, String yala) {
        this.english = english;
        this.yala = yala;
    }

    public TranslateResponse() {
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public void setYala(String yala) {
        this.yala = yala;
    }

    public String getEnglish() {
        return english;
    }

    public String getYala() {
        return yala;
    }

    @Override
    public String toString() {
        return "TranslateResponse{" +
                "english='" + english + '\'' +
                ", yala='" + yala + '\'' +
                '}';
    }
}
