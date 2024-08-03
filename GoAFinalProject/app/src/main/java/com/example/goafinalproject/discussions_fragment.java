package com.example.goafinalproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goafinalproject.Discussion.Adapters.DiscussionCollectionAdapter;
import com.example.goafinalproject.Discussion.Fragments.*;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class discussions_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        GlobalResources.changeToolbar("Discussions", false);
        GlobalResources.navigationBackMethod = GlobalResources.NavigationBackMethod.NAVIGATION_COMPONENT_DISCUSSIONS;
        GlobalResources.navController = Navigation.findNavController(getActivity(), R.id.discussions_nav);
        return inflater.inflate(R.layout.discussions_view, container, false);
    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        ViewPager2 viewPager = view.findViewById(R.id.viewPager);
//        DiscussionCollectionAdapter discussionCollectionAdapter = new DiscussionCollectionAdapter(this, new ArrayList<>(List.of(
//                new Discussion_manager()
//        )));
//        viewPager.setAdapter(discussionCollectionAdapter);
//        TabLayout tabLayout = view.findViewById(R.id.discussion_tabs);
//        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText("OBJECT " + (position + 1))).attach();
//    }
}