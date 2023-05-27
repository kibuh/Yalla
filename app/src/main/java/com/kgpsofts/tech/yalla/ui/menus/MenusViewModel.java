package com.kgpsofts.tech.yalla.ui.menus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MenusViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MenusViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}