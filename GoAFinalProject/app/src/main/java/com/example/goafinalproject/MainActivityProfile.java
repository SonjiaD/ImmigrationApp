package com.example.goafinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.BitmapFactory;
import android.os.Bundle;

public class MainActivityProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences_norecycler);
//
//        RecyclerView recyclerViewProfile = findViewById(R.id.preferences1);
//        recyclerViewProfile.setLayoutManager( new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
////        //setting so the recyclerview is horizontal
////        //content displayed
////        quiz_adapter ProfileAdapter = new quiz_adapter(new ProfileData[]{
////                //need to name quizCards.java for the file
////                new ProfileData("Saved Items", BitmapFactory.decodeResource(getResources(), R.drawable.quiz_star_filled))),
////                new ProfileData("Liked Posts", BitmapFactory.decodeResource(getResources(), R.drawable.quiz_star_unfilled))),
////                new ProfileData("Language Choice", BitmapFactory.decodeResource(getResources(), R.drawable.quiz_star_unfilled))
////        }, this);
////        recyclerViewProfile.setAdapter(ProfileAdapter);
//        ProfileAdapter adapter = new ProfileAdapter(new ProfileData[]{
//                //EventsCards title from the EventsCards.java file
//                new ProfileData("sur", BitmapFactory.decodeResource(getResources(), R.drawable.hamilton)),
//                new ProfileData("not", BitmapFactory.decodeResource(getResources(), R.drawable.japanese_trees)),
//                new ProfileData("working", BitmapFactory.decodeResource(getResources(), R.drawable.olivia_rodrigo))
//        }, this);
//        recyclerViewProfile.setAdapter(adapter);

    }
}