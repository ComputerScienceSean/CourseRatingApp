package com.example.courseratingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        loadStudents();

        if (savedInstanceState != null) {
            email.setText(savedInstanceState.getString("email"));
        }

    }

    public void loadStudents() {
        for (int i = 1; i < 10; i++) {
            Student student = new Student("sean" + i, "darcy", "sean0125@stud.kea.dk" + i, "280320202" + i);
        }
    }

    public void checkLogin(View view) {

       /* Intent login = new Intent(this, ShowCourseActivity.class);
        login.putExtra("email", this.email.getText().toString());
        startActivity(login);*/

        if (isEmailValid(this.email.getText().toString())) {


            if (this.email.getText().toString().contains("@stud.kea.dk") && email.getText().toString().length() > 0) {
                Intent login = new Intent(this, ChooseCourseActivity.class);
                startActivity(login);
                Toast loginSuccess = Toast.makeText(getApplicationContext(), "Welcome, " + email.getText(), Toast.LENGTH_LONG);
                loginSuccess.show();
            } else {
                Toast failedLogin = Toast.makeText(getApplicationContext(), "Invalid email, try again", Toast.LENGTH_LONG);
                failedLogin.show();
            }
        } else {
            Toast failedLogin = Toast.makeText(getApplicationContext(), "Invalid email, try again", Toast.LENGTH_LONG);
            failedLogin.show();
        }
    }

    public boolean isEmailValid(String email) {
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        final Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public void init() {
        this.email = findViewById(R.id.email);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("email", email.getText().toString());
    }
}
