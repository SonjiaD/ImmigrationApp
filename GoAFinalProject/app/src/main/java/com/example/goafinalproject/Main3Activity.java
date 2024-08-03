package com.example.goafinalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.metrics.Event;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_pg);

        RecyclerView recyclerView = findViewById(R.id.events_list);
        recyclerView.setLayoutManager(new LinearLayoutManager( this));
        redoAdapter adapter = new redoAdapter(new EventsCards[]{
                new EventsCards(0, BitmapFactory.decodeResource(getResources(), R.drawable.hamilton), "Hamilton Musical", "May 24, 2022", "8:00PM", "Queen Elizabeth Theatre", "600 Block Hamilton Street", "Vancouver, BC", "V6B 2P1"),
                new EventsCards(1, BitmapFactory.decodeResource(getResources(), R.drawable.japanese_trees), "Japanese Cultural Festival", "May 2, 2022", "10:00AM - 12:00PM", "Nikkei National Museum & Cultural Centre", "6688 Southoaks Crescent", "Burnaby, BC", "V5E 4M7"),
                new EventsCards(2, BitmapFactory.decodeResource(getResources(), R.drawable.olivia_rodrigo), "Olivia Rodrigo Concert", "April 7, 2022", "7:00PM - 12:00AM", "Doug Mitchell Thunderbird Sports Centre", "6066 Thunderbird Blvd", "Vancouver, BC", "V6T 1Z3")

        }, this);
        recyclerView.setAdapter(adapter);


    }
}