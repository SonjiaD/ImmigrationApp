package com.example.goafinalproject.Education.Adapters;

import static com.example.goafinalproject.GlobalResources.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goafinalproject.GlobalResources;
import com.example.goafinalproject.R;

public class EducationReviewAdapter extends RecyclerView.Adapter<EducationReviewAdapter.ViewHolder> {

//    ArrayList<Map.Entry<String, EducationPracticeTest.Choices>> questions;
//    Context context;
//    Activity activity;
//
//    public EducationReviewAdapter(ArrayList<Map.Entry<String, EducationPracticeTest.Choices>> questions, Context context, Activity activity) {
//        this.questions = questions;
//        this.context = context;
//        this.activity = activity;
//    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ViewGroup viewGroup;
        ImageView button;
        TextView question;
        TextView wronganswer;
        TextView correctanswer;
        TextView textView1;
        TextView textView2;

        public ViewHolder(@NonNull View view) {
            super(view);
            viewGroup = view.findViewById(R.id.E_Q_R_Q_back);
            button = view.findViewById(R.id.E_Q_R_Q_button);
            question = view.findViewById(R.id.E_Q_R_Q_question);
            wronganswer = view.findViewById(R.id.E_Q_R_Q_wronganswer);
            correctanswer = view.findViewById(R.id.E_Q_R_Q_correctanswer);
            textView1 = view.findViewById(R.id.E_Q_R_Q_textView1);
            textView2 = view.findViewById(R.id.E_Q_R_Q_textView2);
        }
    }

    @NonNull
    @Override
    public EducationReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_question, parent, false);
        return new EducationReviewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EducationReviewAdapter.ViewHolder holder, int position) {
        holder.question.setText(GlobalResources.getAnswers().get(position).getKey().getKey());
        try {
            holder.correctanswer.setText((String) GlobalResources.getAnswers().get(position).getKey().getValue().getClass().getDeclaredField("choice" + GlobalResources.getAnswers().get(position).getKey().getValue().correct).get(GlobalResources.getAnswers().get(position).getKey().getValue()));
            holder.wronganswer.setText((String) GlobalResources.getAnswers().get(position).getKey().getValue().getClass().getDeclaredField("choice" + (int) GlobalResources.getAnswers().get(position).getValue().getValue()).get(GlobalResources.getAnswers().get(position).getKey().getValue()));
        } catch (NoSuchFieldException | IllegalAccessException e) {e.printStackTrace();}
        holder.question.setCompoundDrawablesWithIntrinsicBounds(GlobalResources.getAnswers().get(position).getValue().getKey() ? R.drawable.checkmark : R.drawable.wrong, 0, 0, 0);
        holder.button.setOnClickListener(v -> {
            toggleVis(holder.correctanswer);
            toggleVis(holder.textView2);
            if (!GlobalResources.getAnswers().get(position).getValue().getKey()) {
                toggleVis(holder.wronganswer);
                toggleVis(holder.textView1);
            }
            holder.button.setRotation(holder.button.getRotation() == 0 ? 180 : 0);
        });
        holder.viewGroup.setOnClickListener(v -> {
            toggleVis(holder.correctanswer);
            toggleVis(holder.textView2);
            if (!GlobalResources.getAnswers().get(position).getValue().getKey()) {
                toggleVis(holder.wronganswer);
                toggleVis(holder.textView1);
            }
            holder.button.setRotation(holder.button.getRotation() == 0 ? 180 : 0);
        });
        holder.correctanswer.setVisibility(View.GONE);
        holder.textView2.setVisibility(View.GONE);
        holder.wronganswer.setVisibility(View.GONE);
        holder.textView1.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return GlobalResources.getAnswers().size();
    }
}
