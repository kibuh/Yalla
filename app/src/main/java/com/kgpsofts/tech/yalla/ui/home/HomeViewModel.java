package com.kgpsofts.tech.yalla.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kgpsofts.tech.yalla.network.model.InputData;
import com.kgpsofts.tech.yalla.network.model.TranslateResponse;
import com.kgpsofts.tech.yalla.network.repositories.TranslateRepository;

public class HomeViewModel extends ViewModel {

    private TranslateRepository translateRepository;
    private LiveData<TranslateResponse> translateResponseLiveData;

    public HomeViewModel() {
        translateRepository = new TranslateRepository();
        translateResponseLiveData = translateRepository.getTranslateResponseLiveData();

    }

    public void translateToYala(InputData input) {
        translateRepository.transalteToYala(input);
    }

    public LiveData<TranslateResponse> getTranslateResponseLiveData() {
        return translateResponseLiveData;
    }
}