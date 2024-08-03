package com.example.goafinalproject.Education.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.goafinalproject.Education.EducationPracticeTest;
import com.example.goafinalproject.GlobalResources;
import com.example.goafinalproject.R;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Education_QuizView extends Fragment {

    public Education_QuizView() {}

    public static Education_QuizView newInstance() {
        Education_QuizView fragment = new Education_QuizView();
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
        View view = inflater.inflate(R.layout.fragment_education__quiz_view, container, false);
        //Hide bottom navigation bar
        //@Requires Not Null: R.id.nav_bar
        GlobalResources.hideNavBar(true);
        //Set the toolbar title
        //@Requires Not Null: toolbar, GlobalResources.getPracticeTest()
        GlobalResources.changeToolbar(GlobalResources.getPracticeTest().getTitle());
        //Create ArrayList size of questions
        //@Requires Not Null: GlobalResources.practiceTest.questions
        ArrayList<Map.Entry<String, EducationPracticeTest.Choices>> questions = new ArrayList<>(Collections.nCopies(GlobalResources.getPracticeTest().getQuestions().size(), null));
        //Randomize order of questions and put them into ArrayList
        //@Requires Not Null: R.id.E_Q_progress_text, R.id.E_Q_question_text, GlobalResources.practiceTest, questions.get(i)
        GlobalResources.getPracticeTest().getQuestions().forEach((k, v) -> {
            //0 < Random number < GlobalResources.practiceTest.getQuestions().size()
            int random = (int) (Math.random() * GlobalResources.getPracticeTest().getQuestions().size());
            //If that index is already taken, re-roll number until find open spot
            while (questions.get(random) != null) {
                random = (int) (Math.random() * GlobalResources.getPracticeTest().getQuestions().size());
            }
            //Insert values into questions at index random
            questions.set(random, new AbstractMap.SimpleEntry<>(k, v));
        });
        //Create ArrayList for holding whether correct answer was clicked and fill with values of questions and falses
        //@Requires Not Null: R.id.E_Q_progress_text, R.id.E_Q_question_text, GlobalResources.practiceTest, questions.get(i)
        ArrayList<Map.Entry<Map.Entry<String, EducationPracticeTest.Choices>, Map.Entry<Boolean, Integer>>> answers = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) { answers.add(i, new AbstractMap.SimpleEntry<>(questions.get(i), new AbstractMap.SimpleEntry<>(false, 0))); }
        //Start showing the layout for the questions
        //@Requires Not Null: view, questions, answers
        setValues(view, questions, answers);
        return view;
    }

    int i = 0;

    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables", "RedundantCast"})
    public void setValues(View view, ArrayList<Map.Entry<String, EducationPracticeTest.Choices>> questions, ArrayList<Map.Entry<Map.Entry<String, EducationPracticeTest.Choices>, Map.Entry<Boolean, Integer>>> answers) {
        //Scroll to top
        //@Requires Not Null: R.id.E_Q_scrollview
        ((ScrollView) view.findViewById(R.id.E_Q_scrollview)).scrollTo(0,0);
        //Set text of progress fraction and question
        //@Requires Not Null: R.id.E_Q_progress_text, R.id.E_Q_question_text, GlobalResources.practiceTest, questions.get(i)
        ((TextView) view.findViewById(R.id.E_Q_progress_text)).setText(GlobalResources.getPracticeTest().getProgressText());
        ((TextView) view.findViewById(R.id.E_Q_question_text)).setText(questions.get(i).getKey());
        //Set the progress bar
        //@Requires Not Null: R.id.E_Q_progress_bar, GlobalResources.practiceTest
        ((ProgressBar) view.findViewById(R.id.E_Q_progress_bar)).setProgress((int) (((double) GlobalResources.getPracticeTest().getProgress() / (double) GlobalResources.getPracticeTest().getProgressFull()) * 100));
        //Set the answer text
        //@Requires Not Null: R.id.E_Q_answer_text, questions.get(i)
        ((TextView) view.findViewById(R.id.E_Q_answer_text)).setText("The correct answer is " + (char) (questions.get(i).getValue().correct + 64) + ".");
        //Reset the answer text drawable
        //@Requires Not Null: R.id.E_Q_answer_text
        ((TextView) view.findViewById(R.id.E_Q_answer_text)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        //Disable the next button
        //@Requires Not Null: R.id.E_Q_next
        ((Button) view.findViewById(R.id.E_Q_next)).setEnabled(false);
        ((Button) view.findViewById(R.id.E_Q_next)).setAlpha(0.5f);
        //Hide the learn more text
        //@Requires Not Null: R.id.E_Q_more_hidden
        ((TextView) view.findViewById(R.id.E_Q_more_hidden)).setVisibility(View.GONE);
        //Set the more text text
        //@Requires Not Null: R.id.E_Q_more_hidden, questions.get(i)
        ((TextView) view.findViewById(R.id.E_Q_more_hidden)).setText(questions.get(i).getValue().more);
        //Reset background for all answer blocks
        //@Requires Not Null: R.id.E_Q_answer1, R.id.E_Q_answer2, R.id.E_Q_answer3, R.id.E_Q_answer4 R.drawable.answer_block_back)
        view.findViewById(GlobalResources.getResId("E_Q_answer" + 1, R.id.class)).setBackground(getResources().getDrawable(R.drawable.answer_block_back));
        view.findViewById(GlobalResources.getResId("E_Q_answer" + 2, R.id.class)).setBackground(getResources().getDrawable(R.drawable.answer_block_back));
        view.findViewById(GlobalResources.getResId("E_Q_answer" + 3, R.id.class)).setBackground(getResources().getDrawable(R.drawable.answer_block_back));
        view.findViewById(GlobalResources.getResId("E_Q_answer" + 4, R.id.class)).setBackground(getResources().getDrawable(R.drawable.answer_block_back));
        //Create on click listener for all answer blocks
        View.OnClickListener onClickListener = v -> {
            //Boolean if correct
            //@Requires Not Null: v, R.id.E_Q_answer[correct value for questions.get(i)], questions.get(i)
            boolean correct = v.equals(view.findViewById(GlobalResources.getResId("E_Q_answer" + questions.get(i).getValue().correct, R.id.class)));
            //Set background for correct block to correct background
            //@Requires Not Null: R.id.E_Q_answer[correct value for questions.get(i)], questions.get(i), R.drawable.answer_block_back_correct
            view.findViewById(GlobalResources.getResId("E_Q_answer" + questions.get(i).getValue().correct, R.id.class)).setBackground(getResources().getDrawable(R.drawable.answer_block_back_correct));
            //If answer clicked is wrong, set background to wrong background
            //@Requires Not Null: v, R.drawable.answer_block_back_correct
            if (!correct) { v.setBackground(getResources().getDrawable(R.drawable.answer_block_back_wrong)); }
            //Set text and drawable of and show answer text
            //@Requires Not Null: R.id.E_Q_answer_text, R.drawable.checkcircle, R.drawable.xcircle
            ((TextView) view.findViewById(R.id.E_Q_answer_text)).setText((correct ? "Good job! " : "Nice try! ")  + ((TextView) view.findViewById(R.id.E_Q_answer_text)).getText());
            ((TextView) view.findViewById(R.id.E_Q_answer_text)).setCompoundDrawablesWithIntrinsicBounds(correct ? R.drawable.checkcircle : R.drawable.xcircle, 0, 0, 0);
            ((TextView) view.findViewById(R.id.E_Q_answer_text)).setVisibility(View.VISIBLE);
            //Set visibility of learn more
            //@Requires Not Null: R.id.E_Q_more
            ((LinearLayout) view.findViewById(R.id.E_Q_more)).setVisibility(View.VISIBLE);
            //Enable the next button
            //@Requires Not Null: R.id.E_Q_next
            ((Button) view.findViewById(R.id.E_Q_next)).setEnabled(true);
            ((Button) view.findViewById(R.id.E_Q_next)).setAlpha(1f);
            //Store whether correct or not
            //@Requires Exists: answers.get(i)
            answers.get(i).setValue(new AbstractMap.SimpleEntry<>(correct, Integer.parseInt(getResources().getResourceName(v.getId()).substring(getResources().getResourceName(v.getId()).lastIndexOf("/") + 1).replace("E_Q_answer", ""))));
        };
        //Set text and on click listeners for all answer blocks
        //@Requires Not Null: R.id.E_Q_A1_answer, R.id.E_Q_answer1, R.id.E_Q_A2_answer, R.id.E_Q_answer2, R.id.E_Q_A3_answer, R.id.E_Q_answer3, R.id.E_Q_A4_answer, R.id.E_Q_answer4, questions,get(i)
        ((TextView) view.findViewById(R.id.E_Q_A1_answer)).setText(questions.get(i).getValue().choice1);
        ((LinearLayout) view.findViewById(R.id.E_Q_answer1)).setOnClickListener(onClickListener);
        ((TextView) view.findViewById(R.id.E_Q_A2_answer)).setText(questions.get(i).getValue().choice2);
        ((LinearLayout) view.findViewById(R.id.E_Q_answer2)).setOnClickListener(onClickListener);
        ((TextView) view.findViewById(R.id.E_Q_A3_answer)).setText(questions.get(i).getValue().choice3);
        ((LinearLayout) view.findViewById(R.id.E_Q_answer3)).setOnClickListener(onClickListener);
        ((TextView) view.findViewById(R.id.E_Q_A4_answer)).setText(questions.get(i).getValue().choice4);
        ((LinearLayout) view.findViewById(R.id.E_Q_answer4)).setOnClickListener(onClickListener);
        //Hide the answer text
        //@Requires Not Null: R.id.E_Q_answer_text
        ((TextView) view.findViewById(R.id.E_Q_answer_text)).setVisibility(View.GONE);
        //Hide the learn more
        //@Requires Not Null: R.id.E_Q_more
        ((LinearLayout) view.findViewById(R.id.E_Q_more)).setVisibility(View.GONE);
        //Set on click listener of learn more
        //@Requires Not Null: R.id.E_Q_more
        ((LinearLayout) view.findViewById(R.id.E_Q_more)).setOnClickListener(v -> {
            //Toggle visibility of the learn more text
            //@Requires Not Null: R.id.more_hidden
            view.findViewById(R.id.E_Q_more_hidden).setVisibility(view.findViewById(R.id.E_Q_more_hidden).getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            //If learn more text was hidden and is now showing, scroll to bottom of page
            //@Requires Not Null: R.id.E_Q_more_hidden, R.id.E_Q_scrollview
            if (view.findViewById(R.id.E_Q_more_hidden).getVisibility() == View.VISIBLE) {
                ((ScrollView) view.findViewById(R.id.E_Q_scrollview)).postDelayed(() -> ((ScrollView) view.findViewById(R.id.E_Q_scrollview)).fullScroll(ScrollView.FOCUS_DOWN), 100);
            }
        });
        //Set on click listener of next button
        //@Requires Not Null: R.id.E_Q_next
        ((Button) view.findViewById(R.id.E_Q_next)).setOnClickListener(v -> {
            //If at end of questions, go to review quiz screen
            //Else, load next question
            //@Requires Not Null: questions, GlobalResources.practiceTest, R.id.education_nav, R.id.E_action_QV_to_QR
            if (i + 1 == questions.size()) {
                GlobalResources.setAnswers(answers);
                Navigation.findNavController(getActivity(), R.id.education_nav).navigate(R.id.E_action_QV_to_QR);
            } else {
                i++;
                GlobalResources.getPracticeTest().setProgress(i + 1);
                setValues(view, questions, answers);
            }
        });
    }
}