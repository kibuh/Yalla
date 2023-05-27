package com.kgpsofts.tech.yalla.ui.home.adapters;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.kgpsofts.tech.yalla.ui.home.EnglishFragment;
import com.kgpsofts.tech.yalla.ui.home.YalaFragment;

import org.jetbrains.annotations.NotNull;

public class TabAdapter extends FragmentStateAdapter {


    int nbPages;

    public TabAdapter(@NonNull @NotNull Fragment fragment, int nbPages) {
        super(fragment);
        this.nbPages = nbPages;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0: return new EnglishFragment();
            case 1: return new YalaFragment();
            default: return null;
        }
    }

    @Override
    public int getItemCount() {
        return this.nbPages;
    }
}
