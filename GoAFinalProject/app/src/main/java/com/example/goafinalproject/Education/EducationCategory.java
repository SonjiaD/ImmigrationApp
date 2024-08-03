package com.example.goafinalproject.Education;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

import com.example.goafinalproject.GlobalResources;
import com.example.goafinalproject.JSONParsable;
import com.example.goafinalproject.R;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class EducationCategory extends JSONParsable<EducationCategory> {
    public String text;
    public Drawable image;
    public String imageString;
    public ArrayList<EducationPracticeTest> practiceTests;
    public String practiceTestArrayList;

    public EducationCategory(String text, Drawable image, ArrayList<EducationPracticeTest> practiceTests) {
        this.text = text;
        this.image = image;
        this.practiceTests = practiceTests;
    }

    public EducationCategory() {}

    @Override
    public String toString() {
        return "EducationCategory{" +
                "text='" + text + '\'' +
                ", image=" + image +
                ", practiceTests=" + practiceTests +
                '}';
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @SuppressWarnings("DanglingJavadoc")
    @Override
    public void props() throws IOException {
        super.props();
        /**Assign imageString to image**/
        image = GlobalResources.context.getDrawable(GlobalResources.getResId(imageString, R.drawable.class));

        /**Assign practiceTestArrayList to practiceTests**/
        //Define practiceTests
        practiceTests = new ArrayList<>();
        //Split practice tests up by custom "|" syntax
        for (String s : practiceTestArrayList.replaceAll("\\{", "").replaceAll("\\}", "").split("\\|")) {
            //Split s into elements by commas
            ArrayList<String> practiceTestStringList = new ArrayList<>(List.of(s.split(", ")));
            //1st element is the title
            //2nd element is the boolean for stared
            //3rd element is progress
            //4th element is progressFull
            EducationPracticeTest educationPracticeTest = new EducationPracticeTest(
                    Boolean.parseBoolean(practiceTestStringList.get(1)),
                    practiceTestStringList.get(0),
                    Integer.parseInt(practiceTestStringList.get(2)),
                    Integer.parseInt(practiceTestStringList.get(3)),
                    new TreeMap<>()
            );
            //Starting at the 5th element, questions are defined in blocks of 7
            //1st element of the block is the question
            //2nd, 3rd, 4th, 5th element of the block are the answers
            //6th element of the block is the correct answer
            //7th element of the block is the learn more text
            //Loop through blocks starting at 4 by incrementing by 7
            for (int i = 4; i+6 < practiceTestStringList.size(); i+=7) {
                educationPracticeTest.getQuestions().put(practiceTestStringList.get(i), new EducationPracticeTest.Choices(
                        practiceTestStringList.get(i+1),
                        practiceTestStringList.get(i+2),
                        practiceTestStringList.get(i+3),
                        practiceTestStringList.get(i+4),
                        Integer.parseInt(practiceTestStringList.get(i+5)),
                        practiceTestStringList.get(i+6)
                ));
            }
            //Add practice test to list
            practiceTests.add(educationPracticeTest);
        }
    }

    @Override
    public ArrayList<String> properties() {
        return new ArrayList<>(List.of(Arrays.stream(getThis().getClass().getDeclaredFields()).map(Field::getName).filter(f -> !f.equals("practiceTests") && !f.equals("image") && !f.equals("properties")).toArray(String[]::new)));
    }
}
