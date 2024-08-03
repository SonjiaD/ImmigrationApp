package com.example.goafinalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Personalization extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personalization, container, false);
        //1st set of bubbles
        ArrayList<String> bubbles = new ArrayList<>(List.of(
                "RESETTLEMENT ADMISSIONS PROGRAM",
                "RESETTLEMENT AGENCY",
                "CANADA LAWS",
                "FIRST 30 DAYS",
                "WORKING IN CANADA",
                "RIGHTS AND RESPONSIBILITIES",
                "EDUCATION & ENGLISH CLASSES"
        ));

        RowLayout rowLayout = view.findViewById(R.id.row_layout);
        for (String bubble : bubbles) {
            TextView textView = new TextView(getContext());
            textView.setTextColor(getResources().getColor(R.color.woodBrown));
            textView.setText(bubble);
            textView.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.bubble_not_selected));
            textView.setOnClickListener(v -> {
                boolean clicked = false;
                textView.setBackground(AppCompatResources.getDrawable(getContext(), clicked ? R.drawable.bubble_not_selected : R.drawable.bubble_selected));
                clicked = !clicked;
            });
            rowLayout.addView(textView);

            //can i do it through a forloop?
        }
        //2nd Rowlayout
        ArrayList<String> bubbles1 = new ArrayList<>(List.of(
                "TRANSPORTATION",
                "HOUSING COMMUNITY",
                "SERVICES",
                "COMMUNITY INVOLVEMENT",
                "NEIGHBOURHOODS"

        ));

        RowLayout rowLayout1 = view.findViewById(R.id.row_layout1);
        for (String bubble1 : bubbles1) {
            TextView textView1 = new TextView(getContext());
            textView1.setText(bubble1);
            textView1.setTextColor(getResources().getColor(R.color.woodBrown));
            textView1.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.bubble_not_selected));
            textView1.setOnClickListener(v -> {
                boolean clicked = false;
                textView1.setBackground(AppCompatResources.getDrawable(getContext(), clicked ? R.drawable.bubble_not_selected : R.drawable.bubble_selected));
                clicked = !clicked;
            });
            rowLayout1.addView(textView1);
        }
        //3rd Rowlayout
//        ArrayList<String> bubbles2 = new ArrayList<>(List.of(
//                "CITIZENSHIP TEST",
//                "ENGLISH",
//                "SLANG",
//                "CULTURAL CUSTOMS"
//        ));

        ArrayList<String> bubbles2 = (ArrayList<String>) GlobalResources.getCategories().stream().map(v -> v.text).collect(Collectors.toList());
        ArrayList<Boolean> bubbles2a = new ArrayList<>(Collections.nCopies(bubbles2.size(), false));

        RowLayout rowLayout2 = view.findViewById(R.id.row_layout2);
        for (String bubble2 : bubbles2) {
            TextView textView2 = new TextView(getContext());
            textView2.setText(bubble2);
            textView2.setTextColor(getResources().getColor(R.color.woodBrown));
            textView2.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.bubble_not_selected));
            textView2.setOnClickListener(v -> {
                textView2.setBackground(AppCompatResources.getDrawable(getContext(),bubbles2a.get(bubbles2.indexOf(textView2.getText())) ? R.drawable.bubble_not_selected : R.drawable.bubble_selected));
                bubbles2a.set(bubbles2.indexOf(textView2.getText()), !bubbles2a.get(bubbles2.indexOf(textView2.getText())));
            });
            rowLayout2.addView(textView2);}

        view.findViewById(R.id.update).setOnClickListener(v -> {
            for (int i = bubbles2.size() - 1; i >= 0; i--) {
                if (!bubbles2a.get(i)) {
                    GlobalResources.getCategories().remove(i);
                }
            }
            System.out.println(GlobalResources.getCategories());
            Navigation.findNavController(getActivity(), R.id.main_nav_container).navigate(R.id.mainActivityDashboard);
        });
        return view;
    }
}
