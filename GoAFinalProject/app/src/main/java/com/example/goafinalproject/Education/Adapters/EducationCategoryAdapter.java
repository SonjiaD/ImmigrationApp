package com.example.goafinalproject.Education.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goafinalproject.Education.EducationCategory;
import com.example.goafinalproject.GlobalResources;
import com.example.goafinalproject.R;

import java.util.ArrayList;

public class EducationCategoryAdapter extends RecyclerView.Adapter<EducationCategoryAdapter.ViewHolder> {
    ArrayList<EducationCategory> categories;
    Context context;
    Activity activity;

    public EducationCategoryAdapter(ArrayList<EducationCategory> categories, Context context, Activity activity) {
        this.categories = categories;
        this.context = context;
        this.activity = activity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ViewGroup viewGroup;
        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View view) {
            super(view);
            viewGroup = view.findViewById(R.id.E_C_B_Back);
            textView = view.findViewById(R.id.E_C_B_Text);
            imageView = view.findViewById(R.id.E_C_B_Image);
        }
    }

    @NonNull
    @Override
    public EducationCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_block, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EducationCategoryAdapter.ViewHolder holder, int position) {
        holder.textView.setText(categories.get(position).text);
        holder.imageView.setImageDrawable(categories.get(position).image);
        holder.viewGroup.setOnClickListener(v -> {
            //Navigate to category on click
            Navigation.findNavController(activity, R.id.education_nav).navigate(R.id.E_action_CL_to_EC);
            GlobalResources.setCategory(categories.get(position)); //Required for category
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
