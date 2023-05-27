package com.kgpsofts.tech.yalla.ui.events;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kgpsofts.tech.yalla.R;
import com.kgpsofts.tech.yalla.databinding.FragmentEventBinding;
import com.kgpsofts.tech.yalla.ui.events.derive.DayWeekFragment;


public class EventFragment extends Fragment {

    private EventViewModel eventViewModel;
    private FragmentEventBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        eventViewModel =
                new ViewModelProvider(this).get(EventViewModel.class);

        binding = FragmentEventBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        root.findViewById(R.id.week_days).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.action_navigation_event_to_dayWeekFragment);
            }
        });
        root.findViewById(R.id.special_events).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.action_navigation_event_to_specialEventFragment);
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