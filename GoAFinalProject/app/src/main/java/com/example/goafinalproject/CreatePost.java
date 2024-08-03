package com.example.goafinalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goafinalproject.Discussion.Adapters.rvAddedHtAdapter;
import com.example.goafinalproject.Discussion.Adapters.rvAddedImageAdapter;
import com.example.goafinalproject.Discussion.AddedHtData;
import com.example.goafinalproject.Discussion.AddedImageData;

public class CreatePost extends Fragment {
    RecyclerView rvAddedHt;
    RecyclerView rvAddedImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discussion_p1, container, false);

        rvAddedHt = view.findViewById(R.id.rvAddedHt);
        rvAddedHt.setHasFixedSize(true);
        rvAddedHt.setLayoutManager(new LinearLayoutManager(getContext()));
        AddedHtData[] AddedHtData = new AddedHtData[]{
                new AddedHtData("#chinese"),

        };
        rvAddedHtAdapter rvAddedHtAdapter = new rvAddedHtAdapter(AddedHtData, getContext());
        rvAddedHt.setAdapter(rvAddedHtAdapter);


        rvAddedImage = view.findViewById(R.id.rvAddedImage);
        rvAddedImage.setHasFixedSize(true);
        rvAddedImage.setLayoutManager(new LinearLayoutManager(getContext()));
        AddedImageData[] AddedImageData = new AddedImageData[]{
                new AddedImageData(R.drawable.noodles),
                new AddedImageData(R.drawable.wonton_2),

        };
        rvAddedImageAdapter rvAddedImageAdapter = new rvAddedImageAdapter(AddedImageData, getContext());
        rvAddedImage.setAdapter(rvAddedImageAdapter);

        view.findViewById(R.id.next_button).setOnClickListener(v -> Navigation.findNavController(getActivity(), R.id.discussions_nav).navigate(R.id.action_createPost_to_discussion_p1));
        return view;
    }

}
