package com.example.goafinalproject.Education.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goafinalproject.Education.EducationPracticeTest;
import com.example.goafinalproject.GlobalResources;
import com.example.goafinalproject.R;

import java.util.ArrayList;

public class EducationPracticeTestAdapter  extends RecyclerView.Adapter<EducationPracticeTestAdapter.ViewHolder> {
    ArrayList<EducationPracticeTest> tests;
    Context context;
    Activity activity;

    public EducationPracticeTestAdapter(ArrayList<EducationPracticeTest> tests, Context context, Activity activity) {
        this.tests = tests;
        this.context = context;
        this.activity = activity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ViewGroup viewGroup;
        ImageView star;
        TextView title;
        TextView progressText;
        ProgressBar progressBar;

        public ViewHolder(@NonNull View view) {
            super(view);
            viewGroup = view.findViewById(R.id.back);
            star = view.findViewById(R.id.star);
            title = view.findViewById(R.id.test_title);
            progressText = view.findViewById(R.id.progress_text);
            progressBar = view.findViewById(R.id.progress_bar);
        }
    }

    @NonNull
    @Override
    public EducationPracticeTestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.practice_test, parent, false);
        return new EducationPracticeTestAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EducationPracticeTestAdapter.ViewHolder holder, int position) {
        holder.star.setImageDrawable(AppCompatResources.getDrawable(context, tests.get(position).isStared() ? R.drawable.star_fill : R.drawable.star));
        holder.title.setText(tests.get(position).getTitle());
        holder.progressText.setText(tests.get(position).getProgressText());
        holder.progressBar.setProgress((int) (((double) tests.get(position).getProgress() / (double) tests.get(position).getProgressFull()) * 100));
        holder.viewGroup.setOnClickListener(v -> {
            //Navigate to quizview on click
            Navigation.findNavController(activity, R.id.education_nav).navigate(R.id.E_action_QL_to_QV);
            GlobalResources.setPracticeTest(tests.get(position)); //Required for quizview
        });
    }

    @Override
    public int getItemCount() {
        return tests.size();
    }
}
