package com.example.courseratingapp;

import android.app.assist.AssistStructure;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChooseCourseActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_course);
        init();

    }

    public void init(){
            this.recyclerView = findViewById(R.id.recyclerView_list);
            Set<Course> unAnsweredCourses = new HashSet<>();
            ArrayList<Course> allCourses = Course.getCourses();

            for (Course course : allCourses) {
                if (!course.isRated()){
                    unAnsweredCourses.add(course);
                }
            }

            Adapter adapter = new Adapter(this, new ArrayList<>(unAnsweredCourses));
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
