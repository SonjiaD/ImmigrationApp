package com.example.goafinalproject.Education.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.goafinalproject.GlobalResources;
import com.example.goafinalproject.R;


public class Education_Category extends Fragment {

    public Education_Category() {}

    public static Education_Category newInstance(String param1, String param2) {
        Education_Category fragment = new Education_Category();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_education__category, container, false);
        //Hide bottom navigation bar
        //@Requires Not Null: R.id.nav_bar
        GlobalResources.hideNavBar(true);
        //Set text for both options
        //@Requires Not Null: R.id.E_C_2_Text1, R.id.E_C_2_Text2, GlobalResources.category
        ((TextView) view.findViewById(R.id.E_C_2_Text1)).setText(GlobalResources.getCategory().text + ((TextView) view.findViewById(R.id.E_C_2_Text1)).getText());
        ((TextView) view.findViewById(R.id.E_C_2_Text2)).setText(GlobalResources.getCategory().text + ((TextView) view.findViewById(R.id.E_C_2_Text2)).getText());
        //Set navigation link for practice tests option
        //@Requires Not Null: R.id.E_C_2_VG1, R.id.education_nav, R.id.E_action_EC_to_QL
        view.findViewById(R.id.E_C_2_VG1).setOnClickListener(v -> Navigation.findNavController(getActivity(), R.id.education_nav).navigate(R.id.E_action_EC_to_QL));
        view.findViewById(R.id.E_C_2_VG2).setOnClickListener(v -> Toast.makeText(getContext(), "Feature coming soon.", Toast.LENGTH_SHORT).show());
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        GlobalResources.changeToolbar(GlobalResources.getCategory().text, true);
    }
}