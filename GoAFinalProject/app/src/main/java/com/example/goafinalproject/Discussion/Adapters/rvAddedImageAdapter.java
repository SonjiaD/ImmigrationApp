package com.example.goafinalproject.Discussion.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goafinalproject.CreatePost;
import com.example.goafinalproject.Discussion.AddedImageData;
import com.example.goafinalproject.R;

public class rvAddedImageAdapter extends RecyclerView.Adapter<rvAddedImageAdapter.ViewHolder>{
    com.example.goafinalproject.Discussion.AddedImageData[] AddedImageData;
    Context context;

    public rvAddedImageAdapter(AddedImageData[]AddedImageData, Context activity){
        this.AddedImageData = AddedImageData;
        this.context = activity;
    }


    @NonNull
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.individual_add_image, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder (@NonNull ViewHolder holder, int position){
        final AddedImageData AddedImageDataList = AddedImageData[position];
        holder.added_image.setText(AddedImageDataList.getAdded_image());
        holder.itemView.setOnClickListener(v -> Toast.makeText(context, AddedImageDataList.getAdded_image(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount () {
        return AddedImageData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView added_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            added_image = itemView.findViewById(R.id.added_image);

        }
    }
}
