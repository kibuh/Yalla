package com.kgpsofts.tech.yalla.ui.events.derive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;
import com.kgpsofts.tech.yalla.R;
import com.kgpsofts.tech.yalla.databinding.FragmentSpecialEventBinding;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */

public class SpecialEventFragment extends Fragment {

    FragmentSpecialEventBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSpecialEventBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        PDFView pdf = root.findViewById(R.id.special_pdf);

        pdf.fromAsset("special_events.pdf")
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true)
                .spacing(0)
                .load();;

        return root;
    }
}