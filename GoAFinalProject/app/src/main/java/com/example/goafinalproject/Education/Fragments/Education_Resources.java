package com.example.goafinalproject.Education.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goafinalproject.R;

public class Education_Resources extends Fragment {
    public Education_Resources() {}
    public static Education_Resources newInstance(String param1, String param2) {
        Education_Resources fragment = new Education_Resources();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_education__resources, container, false);
    }
}