package com.example.goafinalproject;

import static com.google.android.material.navigation.NavigationBarView.LABEL_VISIBILITY_UNLABELED;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;


public class Discussion_v1 extends AppCompatActivity {

    RecyclerView rvHashtags;
    RecyclerView rvKeywords;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_discussion_1);
//
//        tabLayout = findViewById(R.id.discussion_tabs);
//        viewPager = findViewById(R.id.viewPager);
//        tabLayout.setupWithViewPager(viewPager);
//
//        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        vpAdapter.addFragment(new tab_discussion_frag(), "Discussion");
//        vpAdapter.addFragment(new tab_reviews_frag(), "Reviews");
//        vpAdapter.addFragment(new tab_events_frag(), "Events");
//        viewPager.setAdapter(vpAdapter);

    }
}
