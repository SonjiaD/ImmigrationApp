package com.example.goafinalproject.Education.Fragments;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.goafinalproject.Education.Adapters.EducationReviewAdapter;
import com.example.goafinalproject.GlobalResources;
import com.example.goafinalproject.R;

public class Education_QuizReview extends Fragment {

    public Education_QuizReview() {}

    public static Education_QuizReview newInstance() {
        Education_QuizReview fragment = new Education_QuizReview();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    int i = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_education__quiz_review, container, false);
        //Hide bottom navigation bar
        //@Requires Not Null: R.id.nav_bar
        GlobalResources.hideNavBar(true);
        ProgressBar progressBar = view.findViewById(R.id.E_Q_R_progressBar);
        TextView progressText = view.findViewById(R.id.E_Q_R_progressText);
        Button homebutton = view.findViewById(R.id.E_Q_R_home);
        homebutton.setText(homebutton.getText().toString().replace("C", GlobalResources.getCategory().text));
        homebutton.setOnClickListener(v -> {
//            Navigation.findNavController(getActivity(), R.id.education_nav).navigate(R.id.E_action_QR_to_QL);
            Navigation.findNavController(getActivity(), R.id.education_nav).popBackStack();
            Navigation.findNavController(getActivity(), R.id.education_nav).popBackStack();
        });
        int progress = (int) ((((double) GlobalResources.getAnswers().stream().filter(f -> f.getValue().getKey()).count()) / (double) GlobalResources.getAnswers().size()) * 100);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // set the limitations for the numeric
                if (i <= progress) {
                    progressText.setText(i + "%");
                    progressBar.setProgress(i);
                    progressBar.setProgressTintList(ContextCompat.getColorStateList(getContext(), i <= 50 ? R.color.wrong2 : R.color.correct2));
                    i++;
                    handler.postDelayed(this, 10);
                } else {
                    handler.removeCallbacks(this);
                }
            }
        }, 10);
        RecyclerView recyclerView = view.findViewById(R.id.E_Q_R_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new EducationReviewAdapter());
        GlobalResources.getPracticeTest().setProgress((int) GlobalResources.getAnswers().stream().filter(f -> f.getValue().getKey()).count());
        return view;
    }
}