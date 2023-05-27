package com.kgpsofts.tech.yalla.ui.community;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kgpsofts.tech.yalla.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.CommunityViewHolder> {
    Activity context;
    ArrayList<Community> communityArrayList;

    public CommunityAdapter(Activity context, ArrayList<Community> communityArrayList) {
        this.context = context;
        this.communityArrayList = communityArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public CommunityViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(context).inflate(R.layout.community_item,parent,false);
        return new CommunityViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CommunityViewHolder holder, int position) {
        // Set item views based on your views and data model
        Community community = communityArrayList.get(position);
        TextView textView = holder.community;
        textView.setText(community.getCommunity());
    }

    @Override
    public int getItemCount() {
        return communityArrayList.size();
    }

    class CommunityViewHolder extends RecyclerView.ViewHolder{

        TextView community;
        public CommunityViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            community = itemView.findViewById(R.id.community_item);
        }
    }
}


