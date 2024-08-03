package com.example.goafinalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class First_Page extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_welcome_pg, container, false);
        GlobalResources.hideNavBar(true);
        view.findViewById(R.id.get_started).setOnClickListener(v -> Navigation.findNavController(getActivity(), R.id.main_nav_container).navigate(R.id.personalization));
        return view;
    }
}
