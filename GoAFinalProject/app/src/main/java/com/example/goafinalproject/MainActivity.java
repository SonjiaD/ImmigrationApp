package com.example.goafinalproject;

import static com.google.android.material.navigation.NavigationBarView.LABEL_VISIBILITY_UNLABELED;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.navigation.Navigation;

import com.google.android.material.bottomnavigation.BottomNavigationView;

@SuppressLint("NonConstantResourceId")
public class MainActivity extends SwitchableClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar);
        GlobalResources.setActivity(this, R.id.my_toolbar, bottomNavigationView);
        GlobalResources.setToolbar(R.id.my_toolbar, "AMIES");
        GlobalResources.navigationBackMethod = GlobalResources.NavigationBackMethod.NAVIGATION_COMPONENT_FRAGMENT;
//        GlobalResources.intent(MainActivity.this, EducationActivity.class);

        bottomNavigationView.setLabelVisibilityMode(LABEL_VISIBILITY_UNLABELED);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    Navigation.findNavController(this, R.id.main_nav_container).navigate(R.id.mainActivityDashboard);
                    return true;

                case R.id.book:
                    Navigation.findNavController(this, R.id.main_nav_container).navigate(R.id.education_fragment);
                    return true;

                case R.id.speech:
                    Toast.makeText(this, "Stay tuned for this feature coming soon!", Toast.LENGTH_LONG).show();
//                    Navigation.findNavController(this, R.id.main_nav_container).navigate(R.id.discussions_fragment);
                    return true;

                case R.id.profile:
                    Navigation.findNavController(this, R.id.main_nav_container).navigate(R.id.profile_fragment);
                    return true;

            }
            return false;
        });
        //Show bottom navigation bar
        //@Requires Not Null: R.id.nav_bar
        GlobalResources.hideNavBar(false);
    }

}