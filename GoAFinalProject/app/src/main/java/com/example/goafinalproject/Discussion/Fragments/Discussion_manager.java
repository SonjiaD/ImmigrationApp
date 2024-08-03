package com.example.goafinalproject.Discussion.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goafinalproject.Discussion.Adapters.rvDiscussionPageAdapter;
import com.example.goafinalproject.Discussion.HashtagData;
import com.example.goafinalproject.GlobalResources;
import com.example.goafinalproject.R;

public class Discussion_manager extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_discussion_p1, container, false);
        GlobalResources.navController = Navigation.findNavController(getActivity(), R.id.discussions_nav);
        System.out.println(GlobalResources.navController);
        return view;
    }
}