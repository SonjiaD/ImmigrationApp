package com.example.goafinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.util.Rfc822Token;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivityDashboard extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_dashboard, container, false);

        //1st recyclerview for Events
        RecyclerView recyclerView = view.findViewById(R.id.eventsRecyclerView);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        //content displayed
        redoAdapter adapter = new redoAdapter(new EventsCards[]{
               //EventsCards title from the EventsCards.java file
                new EventsCards(0, BitmapFactory.decodeResource(getResources(), R.drawable.hamilton), "Hamilton Musical", "May 24, 2022", "8:00PM", "Queen Elizabeth Theatre", "600 Block Hamilton Street", "Vancouver, BC", "V6B 2P1"),
                new EventsCards(1, BitmapFactory.decodeResource(getResources(), R.drawable.japanese_trees), "Japanese Cultural Festival", "May 2, 2022", "10:00AM - 12:00PM", "Nikkei National Museum & Cultural Centre", "6688 Southoaks Crescent", "Burnaby, BC", "V5E 4M7"),
                new EventsCards(2, BitmapFactory.decodeResource(getResources(), R.drawable.olivia_rodrigo), "Olivia Rodrigo Concert", "April 7, 2022", "7:00PM - 12:00AM", "Doug Mitchell Thunderbird Sports Centre", "6066 Thunderbird Blvd", "Vancouver, BC", "V6T 1Z3")

        }, getContext());
        recyclerView.setAdapter(adapter);

        //recycler view for quizzes
        RecyclerView recyclerView1 = view.findViewById(R.id.quizzesRecyclerView);
        recyclerView1.setLayoutManager( new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            //setting so the recyclerview is horizontal
        //content displayed
        QuizAdapter adapterQuizzes = new QuizAdapter(GlobalResources.getCategory().practiceTests, getContext(), getActivity());
            recyclerView1.setAdapter(adapterQuizzes);


        RecyclerView recyclerView2 = view.findViewById(R.id.discussionRecyclerView);
        recyclerView2.setLayoutManager( new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        DiscussionAdapter discussionAdapter = new DiscussionAdapter(new DiscussionData[]{
                new DiscussionData("Mmm This food is good!","@Soandso", "I discovered this queso at...", "1 day ago", "1537",(BitmapFactory.decodeResource(getResources(), R.drawable.queso_discussion))),
                new DiscussionData("Mmm This food is good!","@BerkleyJohnston", "Look at these chao shou they are so good!", "6 days ago", "27",(BitmapFactory.decodeResource(getResources(), R.drawable.chaoshou))),
        }, getContext());

        recyclerView2.setAdapter(discussionAdapter);

                //creating an array for adapter wrong

        RecyclerView recyclerView3 = view.findViewById(R.id.cardRandomFactOfTheDay);
        recyclerView3.setLayoutManager( new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        RfotdAdapter rfotdAdapter = new RfotdAdapter(new RfotdData[]{

                new RfotdData("LOL", "Slang word meaning very funny.", (BitmapFactory.decodeResource(getResources(), R.drawable.lol_rfotd))),
                new RfotdData("SUS", "Slang meaning someone is  suspicious.", (BitmapFactory.decodeResource(getResources(), R.drawable.among_gus))),
                new RfotdData("The Island", "nickname that refers to Vancouver Island, BC", (BitmapFactory.decodeResource(getResources(), R.drawable.island)))
        }, getContext());

        recyclerView3.setAdapter(rfotdAdapter);
        GlobalResources.hideNavBar(false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        GlobalResources.changeToolbar("AMIES", false);
        GlobalResources.hideNavBar(false);
    }
}

