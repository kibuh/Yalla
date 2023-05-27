package com.kgpsofts.tech.yalla.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.kgpsofts.tech.yalla.R;
import com.kgpsofts.tech.yalla.databinding.FragmentHomeBinding;
import com.kgpsofts.tech.yalla.ui.home.adapters.TabAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

//    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private TabAdapter tabAdapter;
    private int nbPages =1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        tabLayout = binding.tabLayout;
        tabLayout.addTab(tabLayout.newTab());
//        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        List<String> tabNames = new ArrayList<String>();
        tabNames.add("English");
//        tabNames.add("Yala");





        viewPager2 = binding.viewPager;

        tabAdapter = new TabAdapter(this,tabLayout.getTabCount());


        viewPager2.setAdapter(tabAdapter);

        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(tabNames.get(position))
        ).attach();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}