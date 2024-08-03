package com.example.goafinalproject;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder>{

    ProfileData[] profileData;
    Context context;

    public ProfileAdapter(ProfileData[] profileData, MainActivityProfile activity) {
        this.profileData = profileData;
        this.context = context;
        //class maybe not 'context' but 'activity'
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.preference_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ProfileData profileDataList = profileData[position];
        holder.type.setText(profileDataList.getType());
        holder.icon.setImageBitmap(profileDataList.getIcon());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView type;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            icon = itemView.findViewById(R.id.icon);

        }
    }

}
