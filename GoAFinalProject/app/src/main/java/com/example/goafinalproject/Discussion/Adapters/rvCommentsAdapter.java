package com.example.goafinalproject.Discussion.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goafinalproject.Discussion.CommentData;
import com.example.goafinalproject.R;

public class rvCommentsAdapter extends RecyclerView.Adapter<rvCommentsAdapter.ViewHolder> {

    com.example.goafinalproject.Discussion.CommentData[] CommentData;
    Context context;

    public rvCommentsAdapter(CommentData[]CommentData, Context activity){
        this.CommentData = CommentData;
        this.context = activity;
    }


    @NonNull
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.individual_comments, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder (@NonNull ViewHolder holder, int position){
        final CommentData CommentDataList = CommentData[position];
        holder.comment_username.setText(CommentDataList.getComment_username());
        holder.comment_text.setText(CommentDataList.getComment_text());
        holder.itemView.setOnClickListener(v -> Toast.makeText(context, CommentDataList.getComment_text(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount () {
        return CommentData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView comment_text;
        TextView comment_username;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            comment_text = itemView.findViewById(R.id.comment_text);
            comment_username = itemView.findViewById(R.id.comment_username);

        }
    }
}
