package com.example.goafinalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class redoAdapter extends RecyclerView.Adapter<redoAdapter.ViewHolder>{
    //recyclerVIew

    //DEFINITIONS
//    RedoAdapter
//        def = EventsCards.java
//            holder.use defs created at the bottom
//
//    MainActivity.java
//        events_pg = xml for the whole pg
//        events_list = recyclerview for the list
//    EventsCards


    EventsCards[] eventsCards;
    Context context;

    public redoAdapter(EventsCards[] eventsCards, Context context) {
        this.eventsCards = eventsCards;
        this.context = context;
    }


//    public redoAdapter () {
//    //9:12
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //tells program what its gonna create view from, what to multiply
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new ViewHolder(view);

//
//
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.cardview, parent, false);
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;
////                movieitemlist 10:06
//                //cardview not connecting to xml file
//                //cant attachtoRoot:false
//
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.eventImage.setImageBitmap(eventsCards[position].getImageView());
        //going to set bitmap for the imageview
        holder.textViewTitle.setText(eventsCards[position].getTitle());
        holder.textViewDate.setText(eventsCards[position].getDate());
        holder.textViewLocationDescription.setText(eventsCards[position].getLocationDescription());
        holder.textViewTime.setText(eventsCards[position].getTime());
        holder.textViewCityProvince.setText(eventsCards[position].getCity_province());
        holder.textViewPostalCode.setText(eventsCards[position].getPostalCode());
        holder.textViewStreetAddress.setText(eventsCards[position].getStreetAddress());
    }

    @Override
    public int getItemCount() {
        return eventsCards.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView eventImage;
        ImageView calendar;
        ImageView map;
        TextView textViewTitle;
        TextView textViewDate;
        TextView textViewLocationDescription;
        TextView textViewTime;
        TextView textViewCityProvince;
        TextView textViewPostalCode;
        TextView textViewStreetAddress;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventImage = itemView.findViewById(R.id.imageView);
            calendar = itemView.findViewById(R.id.imageView2);
            map = itemView.findViewById(R.id.imageView3);
            textViewTitle = itemView.findViewById(R.id.title);
            textViewDate = itemView.findViewById(R.id.date);
            textViewLocationDescription = itemView.findViewById(R.id.discussiondescription);
            textViewTime = itemView.findViewById(R.id.time);
            textViewCityProvince = itemView.findViewById(R.id.city_province);
            textViewPostalCode = itemView.findViewById(R.id.postalCode);
            textViewStreetAddress = itemView.findViewById(R.id.streetAddress);
            //11:45

        }
    }
}
