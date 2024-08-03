package com.example.goafinalproject.Discussion.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goafinalproject.AddHt;
import com.example.goafinalproject.Discussion.AddHtData;
import com.example.goafinalproject.R;

public class rvAddHtAdapter extends RecyclerView.Adapter<rvAddHtAdapter.ViewHolder> {
    com.example.goafinalproject.Discussion.AddHtData[] AddHtData;
    Context context;

    public rvAddHtAdapter(AddHtData[]AddHtData, AddHt activity){
        this.AddHtData = AddHtData;
        this.context = activity;
    }


    @NonNull
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.individual_add_ht, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder (@NonNull ViewHolder holder, int position){
        final AddHtData AddHtDataList = AddHtData[position];
        holder.add_ht_text.setText(AddHtDataList.getAdd_ht_text());
        holder.itemView.setOnClickListener(v -> Toast.makeText(context, AddHtDataList.getAdd_ht_text(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount () {
        return AddHtData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView add_ht_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            add_ht_text = itemView.findViewById(R.id.add_ht_choice);

        }
    }
}
