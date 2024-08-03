package com.example.goafinalproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.goafinalproject.Education.EducationCategory;
import com.example.goafinalproject.Education.EducationPracticeTest;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@SuppressLint({"StaticFieldLeak"})
@SuppressWarnings({"unchecked", "unused", "ConstantConditions"})
public class GlobalResources extends Application {
    public static Context context;
    public static Activity activity;
    public static NavigationBackMethod navigationBackMethod;
    public static BottomNavigationView bottomNavigationView;

    @Override
    public void onCreate() {
        super.onCreate();
        GlobalResources.context = getApplicationContext();
        navigationBackMethod = NavigationBackMethod.OTHER;
        try {
            categories = new ArrayList<>((Collection<? extends EducationCategory>) JSONParser.parseJSON(new BufferedReader(new InputStreamReader(context.getAssets().open("Categories.json"))), EducationCategory.class));
            category = categories.get(0);
        } catch (IOException | InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setActivity(Activity currentActivity, @IdRes int toolb) {
        GlobalResources.setActivity(currentActivity, toolb, null);
    }

    public static void setActivity(Activity currentActivity, @IdRes int toolb, BottomNavigationView bottomNavigationView) {
        activity = currentActivity;
        Toolbar toolbar = activity.findViewById(toolb);
        ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        GlobalResources.bottomNavigationView = bottomNavigationView;
    }

    public static void setToolbar(@IdRes int id, String title) {
        if (activity != null) {
            Toolbar toolbar = activity.findViewById(id);
            ((AppCompatActivity) activity).setSupportActionBar(toolbar);
            ((AppCompatActivity) GlobalResources.activity).getSupportActionBar().setTitle(title);
            toolbar.setNavigationOnClickListener(v -> {
                if (navigationBackMethod.equals(NavigationBackMethod.NAVIGATION_COMPONENT_FRAGMENT)) {
                    Navigation.findNavController(activity, R.id.education_nav).popBackStack();
                } else if (navigationBackMethod.equals(NavigationBackMethod.NAVIGATION_COMPONENT_DISCUSSIONS)) {
                    Navigation.findNavController(activity, R.id.discussions_nav).popBackStack();
                }
            });
        }
    }

    public static void changeToolbar(String newTitle) {
        if (activity != null) {
            ((AppCompatActivity) GlobalResources.activity).getSupportActionBar().setTitle(newTitle);
        }
    }

    public static void changeToolbar(String newTitle, boolean back) {
        if (activity != null) {
            ((AppCompatActivity) GlobalResources.activity).getSupportActionBar().setTitle(newTitle);
            if (back) {
                ((AppCompatActivity) GlobalResources.activity).getSupportActionBar().setHomeAsUpIndicator(R.drawable.nav_back);
            }
            ((AppCompatActivity) GlobalResources.activity).getSupportActionBar().setDisplayHomeAsUpEnabled(back);
        }
    }

    public static void hideNavBar(boolean hidden) {
        if (bottomNavigationView != null) {
            bottomNavigationView.setVisibility(hidden ? View.GONE : View.VISIBLE);
        }
    }

    public static void intent(Context start, Class<? extends SwitchableClass> end) {
        Intent i = new Intent(start, end);
        start.startActivity(i);
    }

    enum NavigationBackMethod {
        NAVIGATION_COMPONENT_FRAGMENT,
        NAVIGATION_COMPONENT_DISCUSSIONS,
        INTENT,
        OTHER
    }

    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void toggleVis(View view) {
        view.setVisibility(view.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
    }


    //Education
    private static ArrayList<EducationCategory> categories;
    public static ArrayList<EducationCategory> getCategories() { return categories; }
    public static void setCategories(ArrayList<EducationCategory> categories) { GlobalResources.categories = categories; }

    private static EducationCategory category;
    public static EducationCategory getCategory() { return category; }
    public static void setCategory(EducationCategory category) { GlobalResources.category = category; }

    private static EducationPracticeTest practiceTest;
    public static EducationPracticeTest getPracticeTest() { return practiceTest; }
    public static void setPracticeTest(EducationPracticeTest practiceTest) { GlobalResources.practiceTest = practiceTest; }

    private static ArrayList<Map.Entry<Map.Entry<String, EducationPracticeTest.Choices>, Map.Entry<Boolean, Integer>>> answers;
    public static ArrayList<Map.Entry<Map.Entry<String, EducationPracticeTest.Choices>, Map.Entry<Boolean, Integer>>> getAnswers() {return answers;}
    public static void setAnswers(ArrayList<Map.Entry<Map.Entry<String, EducationPracticeTest.Choices>, Map.Entry<Boolean, Integer>>> answers) {GlobalResources.answers = answers;}


    //Discussion
    private static String hashtag;
    public static String getHashtag() {return hashtag;}
    public static void setHashtag(String hashtag) {GlobalResources.hashtag = hashtag;}

    public static NavController navController;

}