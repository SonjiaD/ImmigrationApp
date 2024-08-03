package com.example.goafinalproject.Discussion.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goafinalproject.Discussion.CommentData;
import com.example.goafinalproject.Discussion.Adapters.rvCommentsAdapter;
import com.example.goafinalproject.R;

public class Discussion_p3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discussion_p3, container, false);
        RecyclerView rvComments = view.findViewById(R.id.rvComments);
        rvComments.setHasFixedSize(true);
        rvComments.setLayoutManager(new LinearLayoutManager(getContext()));
        CommentData[] CommentData = new CommentData[]{
                new CommentData("I don't think this is an official store", "@JoeMo"),
                new CommentData("@JoeMo Yeah! I went there and there was nothing of the sorts there...", "@Yoma"),
        };
        rvCommentsAdapter rvCommentsAdapter = new rvCommentsAdapter(CommentData, getActivity());
        rvComments.setAdapter(rvCommentsAdapter);
        return view;
    }
}