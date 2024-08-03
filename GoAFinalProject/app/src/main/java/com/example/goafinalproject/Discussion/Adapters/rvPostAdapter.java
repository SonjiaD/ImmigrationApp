package com.example.goafinalproject.Discussion.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goafinalproject.Discussion.PostData;
import com.example.goafinalproject.R;

public class rvPostAdapter extends RecyclerView.Adapter<rvPostAdapter.ViewHolder> {

        com.example.goafinalproject.Discussion.PostData[] PostData;
        Context context;
        Activity activity;

    public rvPostAdapter(PostData[]PostData, Context context, Activity activity){
        this.PostData = PostData;
        this.context = context;
        this.activity = activity;
    }


        @NonNull
        public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.individual_posts, parent, false);
            return new ViewHolder(view);

    }

        @Override
        public void onBindViewHolder (@NonNull ViewHolder holder, int position){
        final PostData PostDataList = PostData[position];
        holder.hashtag_post_title.setText(PostDataList.getHashtag_post_text());
        holder.hashtag_post_username.setText(PostDataList.getHashtag_post_username());
        holder.hashtag_post_text.setText(PostDataList.getHashtag_post_text());
        holder.post_time.setText(PostDataList.getPost_time());
        holder.likes.setText(PostDataList.getLikes());
        if (PostDataList.getPost_image() != null) {
            holder.post_image.setImageResource(PostDataList.getPost_image());
        }
        holder.itemView.setOnClickListener(v -> Navigation.findNavController(activity, R.id.discussions_nav).navigate(R.id.action_discussion_p2_to_discussion_p3));
    }

        @Override
        public int getItemCount () {
        return PostData.length;
    }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            ImageView post_image;
            TextView hashtag_post_title;
            TextView hashtag_post_username;
            TextView hashtag_post_text;
            TextView post_time;
            TextView likes;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                post_image = itemView.findViewById(R.id.post_image);
                hashtag_post_username = itemView.findViewById(R.id.hashtag_post_username);
                hashtag_post_title = itemView.findViewById(R.id.hashtag_post_title);
                hashtag_post_text = itemView.findViewById(R.id.hashtag_post_text);
                post_time = itemView.findViewById(R.id.post_time);
                likes = itemView.findViewById(R.id.likes);

            }
        }
    }
