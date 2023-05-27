package com.kgpsofts.tech.yalla.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.kgpsofts.tech.yalla.R;
import com.kgpsofts.tech.yalla.databinding.FragmentEnglishBinding;
import com.kgpsofts.tech.yalla.network.model.InputData;
import com.kgpsofts.tech.yalla.network.model.TranslateResponse;

import java.util.ArrayList;
import java.util.List;


public class EnglishFragment extends Fragment {

    private HomeViewModel homeViewModel;

    FragmentEnglishBinding binding;
    private static final String TAG = EnglishFragment.class.getSimpleName();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentEnglishBinding.inflate(inflater,container, false);

        View root = binding.getRoot();


        root.findViewById(R.id.translate_english).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> input = new ArrayList<>();
                EditText inputText = root.findViewById(R.id.english_input);
                if(!inputText.getText().toString().isEmpty()){

                    input.add(inputText.getText().toString());

                    InputData inputData = new InputData(input);

                    homeViewModel.translateToYala(inputData);

                    homeViewModel.getTranslateResponseLiveData().observe(getViewLifecycleOwner(), translateResponse -> {
                        try{
                            TextView output = root.findViewById(R.id.translated_english);
                            output.setText(translateResponse.getYala());
                        }catch (Exception ex){
                            Log.e(TAG,ex.getMessage());
                        }

                    });

                }

            }
        });
        root.findViewById(R.id.clear_english).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = root.findViewById(R.id.english_input);
                input.setText("");
                TextView output = root.findViewById(R.id.translated_english);
                output.setText("");

            }
        });

        return  root;

    }
}