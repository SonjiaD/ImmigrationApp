package com.example.goafinalproject.Education;

import android.widget.ProgressBar;

import java.util.TreeMap;

public class EducationPracticeTest {
    private boolean stared;
    private String title;
    private String progressText;
    private int progress;
    private int progressFull;
    private TreeMap<String, Choices> questions;

    public EducationPracticeTest(boolean stared, String title, int progress, int progressFull, TreeMap<String, Choices> questions) {
        this.stared = stared;
        this.title = title;
        this.progressText = progress + "/" + progressFull;
        this.progress = progress;
        this.progressFull = progressFull;
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "EducationPracticeTest{" +
                "stared=" + stared +
                ", title='" + title + '\'' +
                ", progressText='" + progressText + '\'' +
                ", progress=" + progress +
                ", progressFull=" + progressFull +
                ", questions=" + questions +
                '}';
    }

    /**Getters and Setters*/
    public boolean isStared() { return stared; }
    public void setStared(boolean stared) { this.stared = stared; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getProgressText() { return progressText; }
    public void setProgressText(String progressText) { this.progressText = progressText; }
    public int getProgress() { return progress; }
    public void setProgress(int progress) { this.progress = progress; progressText = progress + "/" + progressFull; }
    public int getProgressFull() { return progressFull; }
    public void setProgressFull(int progressFull) { this.progressFull = progressFull; progressText = progress + "/" + progressFull; }
    public TreeMap<String, Choices> getQuestions() { return questions; }
    public void setQuestions(TreeMap<String, Choices> questions) { this.questions = questions; }

    public static class Choices {
        public String choice1;
        public String choice2;
        public String choice3;
        public String choice4;
        public int correct;
        public String more;

        public Choices(String choice1, String choice2, String choice3, String choice4, int correct, String more) {
            this.choice1 = choice1;
            this.choice2 = choice2;
            this.choice3 = choice3;
            this.choice4 = choice4;
            this.correct = correct;
            this.more = more;
        }

        @Override
        public String toString() {
            return "Choices{" +
                    "choice1='" + choice1 + '\'' +
                    ", choice2='" + choice2 + '\'' +
                    ", choice3='" + choice3 + '\'' +
                    ", choice4='" + choice4 + '\'' +
                    ", correct=" + correct +
                    '}';
        }
    }
}
