package com.example.goafinalproject.Discussion.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goafinalproject.Discussion.HashtagData;
import com.example.goafinalproject.GlobalResources;
import com.example.goafinalproject.R;

public class rvDiscussionPageAdapter extends RecyclerView.Adapter<rvDiscussionPageAdapter.ViewHolder> {

    com.example.goafinalproject.Discussion.HashtagData[] HashtagData;
    Context context;
    Activity activity;

    public rvDiscussionPageAdapter(HashtagData[] HashtagData, Context context, Activity activity) {
        this.HashtagData = HashtagData;
        this.context = context;
        this.activity = activity;
    }


    @NonNull
    @Override
    public rvDiscussionPageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.individual_hashtags, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull rvDiscussionPageAdapter.ViewHolder holder, int position) {
        final HashtagData HashtagDataList = HashtagData[position];
        holder.htText.setText(HashtagDataList.getHashtag());
        holder.itemView.setOnClickListener(v -> {
            GlobalResources.setHashtag(HashtagDataList.getHashtag());
            GlobalResources.navController.navigate(R.id.action_discussion_p1_to_discussion_p2);
        });
    }

    @Override
    public int getItemCount() {
        return HashtagData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView htText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            htText = itemView.findViewById(R.id.ht_text);

        }
    }
}