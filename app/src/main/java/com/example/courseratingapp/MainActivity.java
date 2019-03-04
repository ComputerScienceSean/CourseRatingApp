package com.example.courseratingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        loadStudents();
    }

    public void loadStudents(){
        for (int i = 1; i > 10; i++){
            Student student = new Student("sean", "darcy", "sean0125@stud.kea.dk", "2803202020");
        }
    }

    public void init(){

    }


}
