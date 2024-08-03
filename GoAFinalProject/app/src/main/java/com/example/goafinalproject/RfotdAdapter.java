package com.example.goafinalproject;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RfotdAdapter extends RecyclerView.Adapter<RfotdAdapter.ViewHolder> {

    RfotdData[] rfotdData;
    Context context;
    //capitalized RfotdData. the 'R' dk if it is supposed to

    public RfotdAdapter(RfotdData[] RfotdData, Context context) {
        this.rfotdData = RfotdData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.randomfact_card,parent,false);

        return new ViewHolder(view);
        //inline viewholder
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.rfotdtitle.setText(rfotdData[position].getRfotdtitle());
       holder.rfotddescription.setText(rfotdData[position].getRfotddescription());
       holder.rfotdphoto.setImageBitmap(rfotdData[position].getRfotdphoto());
    }

    @Override
    public int getItemCount() { return rfotdData.length; }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        //static
        TextView rfotdtitle;
        TextView rfotddescription;
        ImageView rfotdphoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rfotdtitle = itemView.findViewById(R.id.rfotdtitle);
            rfotddescription = itemView.findViewById(R.id.rfotddescription);
            rfotdphoto = itemView.findViewById(R.id.rfotdphoto);

        }
    }

}
