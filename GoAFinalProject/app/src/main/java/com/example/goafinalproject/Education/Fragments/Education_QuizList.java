package com.example.goafinalproject.Education.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goafinalproject.Education.Adapters.EducationPracticeTestAdapter;
import com.example.goafinalproject.GlobalResources;
import com.example.goafinalproject.R;

public class Education_QuizList extends Fragment {

    public Education_QuizList() {}

    public static Education_QuizList newInstance(String param1, String param2) {
        Education_QuizList fragment = new Education_QuizList();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_education__quiz_list, container, false);
        //Hide bottom navigation bar
        //@Requires Not Null: R.id.nav_bar
        GlobalResources.hideNavBar(true);
        //RecyclerView stuff
        //@Requires Not Null: E_Q_L_Recycler, EducationPracticeTestAdapter
        RecyclerView EQuizesRecyclerView = view.findViewById(R.id.E_Q_L_Recycler);
        EducationPracticeTestAdapter EPracticeTestAdapter = new EducationPracticeTestAdapter(
                //Default values
                GlobalResources.getCategory().practiceTests,
                getContext(),
                getActivity()
        );
        EQuizesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        EQuizesRecyclerView.setAdapter(EPracticeTestAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        GlobalResources.changeToolbar(GlobalResources.getCategory().text + " Practice Tests", true);
    }
}