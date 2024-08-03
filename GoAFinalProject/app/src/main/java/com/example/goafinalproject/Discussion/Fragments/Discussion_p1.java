package com.example.goafinalproject.Discussion.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goafinalproject.Discussion.Adapters.rvDiscussionPageAdapter;
import com.example.goafinalproject.Discussion.HashtagData;
import com.example.goafinalproject.GlobalResources;
import com.example.goafinalproject.R;

public class Discussion_p1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discussion_p1, container, false);
        GlobalResources.changeToolbar("Discussions", false);
        RecyclerView rvHashtags = view.findViewById(R.id.rvHashtags);
        rvHashtags.setHasFixedSize(true);
        rvHashtags.setLayoutManager(new LinearLayoutManager(getContext()));

        HashtagData[] HashtagData = new HashtagData[]{
                new HashtagData("#food"),
                new HashtagData("#canadalaws"),
                new HashtagData("#housing"),
                new HashtagData("#slang"),
                new HashtagData("#BritishColumbia"),
                new HashtagData("#vancouver"),
                new HashtagData("#culturalfestivals"),
                new HashtagData("#foodtruckfestivals"),
                new HashtagData("#localevents"),
                new HashtagData("#jobapplications"),
                new HashtagData("#drivingrequirements"),
                new HashtagData("#drivertesttips"),
                new HashtagData("#immigrationcommunities"),
                new HashtagData("#fromchina"),
                new HashtagData("#fromindia"),
                new HashtagData("#fromkorea"),
                new HashtagData("#fromphillipines"),
        };

        rvDiscussionPageAdapter rvDiscussionPageAdapter = new rvDiscussionPageAdapter(HashtagData, getContext(), getActivity());
        rvHashtags.setAdapter(rvDiscussionPageAdapter);

        RecyclerView rvKeywords = view.findViewById(R.id.rvKeywords);
        rvKeywords.setHasFixedSize(true);
        rvKeywords.setLayoutManager(new LinearLayoutManager(getContext()));

        HashtagData[] KeywordData = new HashtagData[]{
                new HashtagData("Learning English"),
                new HashtagData("Korean Food"),
                new HashtagData("Job Application"),
                new HashtagData("Housing"),
                new HashtagData("Taxes"),
                new HashtagData("Banking"),
                new HashtagData("Housing Price"),
                new HashtagData("Legal Resources"),
                new HashtagData("Fun Facts"),
                new HashtagData("Festivals"),
                new HashtagData("Community Centers"),
                new HashtagData("Child Care"),
                new HashtagData("Schooling"),
                new HashtagData("Education Programs"),
                new HashtagData("Education Requirements"),

        };

        rvDiscussionPageAdapter rvKeywordAdapter = new rvDiscussionPageAdapter(KeywordData, getContext(), getActivity());
        rvKeywords.setAdapter(rvKeywordAdapter);

        //view.findViewById(R.id.add_post).setOnClickListener(v -> Navigation.findNavController(getActivity(), R.id.discussions_nav).navigate(R.id.action_discussion_p1_to_createPost));
        return view;
    }
}