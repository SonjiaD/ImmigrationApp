package com.example.goafinalproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goafinalproject.Discussion.Adapters.rvAddHtAdapter;
import com.example.goafinalproject.Discussion.AddHtData;

public class AddHt extends AppCompatActivity {
    RecyclerView rvAddHt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_ht_page_cp);

        rvAddHt = findViewById(R.id.rvAddHt);
        rvAddHt.setHasFixedSize(true);
        rvAddHt.setLayoutManager(new LinearLayoutManager(this));
        AddHtData[] AddHtData = new AddHtData[]{
                new AddHtData("#korean"),
                new AddHtData("#foodcourt"),
                new AddHtData("#concerts"),
                new AddHtData("#slang"),
                new AddHtData("#chinesefood"),
                new AddHtData("#learningenglish"),
                new AddHtData("#bookstores"),
                new AddHtData("#jobopenings"),
                new AddHtData("#citizenship"),
                new AddHtData("#immigrating"),
                new AddHtData("#housing"),
                new AddHtData("#chinese"),
                new AddHtData("#koreangood"),
                new AddHtData("#queso"),
                new AddHtData("#millenials"),
                new AddHtData("#crystalmall"),
                new AddHtData("#books"),
                new AddHtData("#dumplings"),
                new AddHtData("#army"),
                new AddHtData("#biasd"),
                new AddHtData("#newhome"),
                new AddHtData("#crystalmall"),
                new AddHtData("#books"),
                new AddHtData("#dumplings"),

        };

        rvAddHtAdapter rvAddHtAdapter = new rvAddHtAdapter(AddHtData, AddHt.this);
        rvAddHt.setAdapter(rvAddHtAdapter);

    }

    }
