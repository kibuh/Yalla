package com.kgpsofts.tech.yalla.ui.events.derive;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;
import com.kgpsofts.tech.yalla.R;
import com.kgpsofts.tech.yalla.databinding.FragmentDayWeekBinding;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class DayWeekFragment extends Fragment {

    FragmentDayWeekBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDayWeekBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        PDFView pdf = root.findViewById(R.id.pdf);

        pdf.fromAsset("days_of_the_week.pdf")
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true)
                .spacing(0)
                .load();

        return root;
    }
}