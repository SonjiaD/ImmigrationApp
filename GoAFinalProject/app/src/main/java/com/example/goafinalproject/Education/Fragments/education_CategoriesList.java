package com.example.goafinalproject.Education.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goafinalproject.Education.Adapters.EducationCategoryAdapter;
import com.example.goafinalproject.GlobalResources;
import com.example.goafinalproject.R;

public class education_CategoriesList extends Fragment {

    public education_CategoriesList() {}

    public static education_CategoriesList newInstance(String param1, String param2) {
        education_CategoriesList fragment = new education_CategoriesList();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_education__categories_list, container, false);
        //Show bottom navigation bar
        //@Requires Not Null: R.id.nav_bar
        GlobalResources.hideNavBar(false);
        //RecyclerView stuff
        //@Requires Not Null: E_C_Recycler, EducationCategoryAdapter, GlobalResources.categories
        RecyclerView ECatagoriesRecyclerView = view.findViewById(R.id.E_C_Recycler);
        EducationCategoryAdapter ECategoriesAdapter = new EducationCategoryAdapter(GlobalResources.getCategories(), getContext(), getActivity());
        ECatagoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ECatagoriesRecyclerView.setAdapter(ECategoriesAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        GlobalResources.changeToolbar("Education", false);
    }
}