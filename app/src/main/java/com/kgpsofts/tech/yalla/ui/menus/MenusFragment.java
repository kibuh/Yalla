package com.kgpsofts.tech.yalla.ui.menus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.kgpsofts.tech.yalla.R;
import com.kgpsofts.tech.yalla.databinding.FragmentMenusBinding;


public class MenusFragment extends Fragment {

    private MenusViewModel menusViewModel;
    private FragmentMenusBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        menusViewModel =
                new ViewModelProvider(this).get(MenusViewModel.class);

        binding = FragmentMenusBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        root.findViewById(R.id.yala_vowels).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.action_navigation_menus_to_vowelFragment);
            }
        });

        root.findViewById(R.id.yala_consonants).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.action_navigation_menus_to_consonantFragment);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}