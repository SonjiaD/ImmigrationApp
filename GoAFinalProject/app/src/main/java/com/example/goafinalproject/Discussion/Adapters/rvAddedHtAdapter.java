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
import com.example.goafinalproject.Discussion.AddedHtData;
import com.example.goafinalproject.R;

public class rvAddedHtAdapter extends RecyclerView.Adapter<rvAddedHtAdapter.ViewHolder>{
    com.example.goafinalproject.Discussion.AddedHtData[] AddedHtData;
    Context context;

    public rvAddedHtAdapter(AddedHtData[]AddedHtData, Context context){
        this.AddedHtData = AddedHtData;
        this.context = context;
    }


    @NonNull
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.ht_display_list, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder (@NonNull ViewHolder holder, int position){
        final AddedHtData AddedHtDataList = AddedHtData[position];
        holder.added_ht_text.setText(AddedHtDataList.getAdded_ht_text());
        holder.itemView.setOnClickListener(v -> Toast.makeText(context, AddedHtDataList.getAdded_ht_text(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount () {
        return AddedHtData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView added_ht_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            added_ht_text = itemView.findViewById(R.id.added_ht_text);
        }
    }
}
