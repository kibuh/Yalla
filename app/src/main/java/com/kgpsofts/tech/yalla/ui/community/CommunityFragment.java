package com.kgpsofts.tech.yalla.ui.community;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kgpsofts.tech.yalla.R;
import com.kgpsofts.tech.yalla.databinding.FragmentCommunityBinding;

import java.util.ArrayList;

public class CommunityFragment extends Fragment {

    private CommunityViewModel communityViewModel;
    private FragmentCommunityBinding binding;
    ArrayList<Community> communityArray = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        communityViewModel =
                new ViewModelProvider(this).get(CommunityViewModel.class);

        binding = FragmentCommunityBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Lookup the recyclerview in activity layout
        RecyclerView rvCommunity = (RecyclerView) binding.rvCommunity;

        // Initialize communityArray

         String[] communs = getResources().getStringArray(R.array.yala_communities);
        Log.i("Array",communs.toString());

        for (int i = 0; i < communs.length; i++){
            System.out.println(communs[i].toString());
            communityArray.add(new Community(communs[i].toString()));
        }
        Log.i("Arrays",communityArray.toString());
        // Create adapter passing in the sample user data
        CommunityAdapter mCommunityAdapter = new CommunityAdapter(getActivity(),communityArray);


        // Attach the adapter to the recyclerview to populate items
        rvCommunity.setAdapter(mCommunityAdapter);
        // Set layout manager to position the items
        rvCommunity.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));

//        RecyclerView.ItemDecoration itemDecoration = new
//                DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
//        rvCommunity.addItemDecoration(itemDecoration);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}