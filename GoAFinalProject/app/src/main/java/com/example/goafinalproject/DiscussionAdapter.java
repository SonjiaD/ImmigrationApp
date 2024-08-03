package com.example.goafinalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DiscussionAdapter extends RecyclerView.Adapter<DiscussionAdapter.ViewHolder> {

    DiscussionData[] discussionData;
    Context context;

    public DiscussionAdapter(DiscussionData[] DiscussionData, Context context) {
        this.discussionData = DiscussionData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.discussion_cardview, parent, false);
        return new ViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //12:48
        //connects to the discussiondata.java
        final DiscussionData discussionDataList = discussionData[position];
        holder.discussiontitle.setText(discussionDataList.getTitle());
        holder.username.setText(discussionDataList.getUsername());
        holder.discussiondescription.setText(discussionDataList.getDiscussiondescription());
        holder.datediscussion.setText(discussionDataList.getDatediscussion());
        holder.likes.setText(discussionDataList.getLikes());
        holder.discussionphoto.setImageBitmap(discussionDataList.getDiscussionphoto());
    }

    @Override
    public int getItemCount() { return discussionData.length;}

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView discussiontitle;
        TextView username;
        TextView discussiondescription;
        TextView datediscussion;
        TextView likes;
        ImageView discussionphoto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            discussiontitle = itemView.findViewById(R.id.discussiontitle);
            username = itemView.findViewById(R.id.username);
            discussiondescription = itemView.findViewById(R.id.discussiondescription);
            datediscussion = itemView.findViewById(R.id.datediscussion);
            likes = itemView.findViewById(R.id.likes);
            discussionphoto = itemView.findViewById(R.id.discussionphoto);

        }
    }

}
