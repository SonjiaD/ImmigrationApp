package com.example.goafinalproject.Discussion.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.goafinalproject.Discussion.Adapters.rvPostAdapter;
import com.example.goafinalproject.Discussion.PostData;
import com.example.goafinalproject.GlobalResources;
import com.example.goafinalproject.R;
import com.example.goafinalproject.dashboard_fragment;

public class Discussion_p2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discussion_p2, container, false);
        GlobalResources.changeToolbar(GlobalResources.getHashtag(), false);
        ((TextView) view.findViewById(R.id.hashtag_page_title)).setText(GlobalResources.getHashtag());
        RecyclerView rvPost = view.findViewById(R.id.rvPost);
        rvPost.setHasFixedSize(true);
        rvPost.setLayoutManager(new LinearLayoutManager(getContext()));
        PostData[] PostData = new PostData[]{
                new PostData("Mmm This food is good!", "@Soandso", "I discovered this queso at...", R.drawable.queso, "1 day ago", "1537"),
                new PostData("Has anyone heard of this?", "@Iamcool", "I heard of this new food called...", null, "1 month ago", "5"),
                new PostData("Any Chinese hotpot suggestions?", "@bamboo0711", "Hi, a little new to the city...", R.drawable.haidilao_food, "1 week ago", "711"),
                new PostData("Where can I buy some rabbit heads?", "@leaf0711", "I was wondering where I could...", null, "711 days ago", "0"),
                new PostData("Good 抄手?", "@宋佳", "I love wonton and wanted to know...", R.drawable.wonton, "5 days ago", "934"),
                new PostData("This new bbt store is soooo good!!!!", "@ye0711", "There is this new place called CHICHA San Chen...", R.drawable.bbt, "134876 seconds ago", "8477"),

        };
        rvPostAdapter rvPostAdapter = new rvPostAdapter(PostData, getContext(), getActivity());
        rvPost.setAdapter(rvPostAdapter);
        view.findViewById(R.id.back_button_d2).setOnClickListener(v -> {
            GlobalResources.navController.navigate(R.id.action_discussion_p2_to_discussion_p1);
        });
        return view;
    }
}