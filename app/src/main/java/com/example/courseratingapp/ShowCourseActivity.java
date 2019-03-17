package com.example.courseratingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ShowCourseActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar subjectRelevans, teacherPerformance, teacherPreparation, amountOfFeedback, examples, jobOpportunities;
    private TextView subRelVal, teacherPerformanceVal, teacherPreparationVal, amountOfFeedbackVal, examplesVal, jobOpportunitiesVal, courseTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_course);
        init();

        //get intent

        Intent intent = getIntent();
        Course course = intent.getParcelableExtra("Course");
        this.courseTitle.setText(course.getSubject());


        if (savedInstanceState != null){
            subRelVal.setText(savedInstanceState.getString("subjectRelevans"));
            teacherPerformanceVal.setText(savedInstanceState.getString("teacherPerformance"));
            teacherPreparationVal.setText(savedInstanceState.getString("teacherPreparation"));
            amountOfFeedbackVal.setText(savedInstanceState.getString("amountOfFeedback"));
            examplesVal.setText(savedInstanceState.getString("examples"));
            jobOpportunitiesVal.setText(savedInstanceState.getString("jobOpportunities"));
        }
    }

    public void onRateClick(View view){
        Toast answeredRate = Toast.makeText(getApplicationContext(), "Thank you for the rating of the course: " + courseTitle.getText(), Toast.LENGTH_LONG);
        answeredRate.show();
        Intent rate = new Intent(this, ChooseCourseActivity.class);
        startActivity(rate);
        sendEmail();

    }

    protected void sendEmail() {
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        Log.i("Send email", "");

        String[] TO = {email};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        int totalScore = subjectRelevans.getProgress() + teacherPerformance.getProgress() + teacherPreparation.getProgress() +
                amountOfFeedback.getProgress() + examples.getProgress() + jobOpportunities.getProgress();

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your rating of the " + courseTitle.getText() + " course");
        emailIntent.putExtra(Intent.EXTRA_TEXT,
                "Welcome to the recap of the score you've given to the " + courseTitle.getText() + " course\n\n" +
                "You gave the subject relevans a score of: \n" + subRelVal.getText().toString() + "\n\n" +
                "You gave the teacher performance a score of: \n" + teacherPerformanceVal.getText().toString() + "\n\n" +
                "You gave the teacher preparation a score of: \n" + teacherPreparationVal.getText().toString() + "\n\n" +
                "You gave the amount of feedback a score of: \n" + amountOfFeedbackVal.getText().toString() + "\n\n" +
                "You gave the examples a score of: \n" + examplesVal.getText().toString() + "\n\n" +
                "You gave the job opportunities a score of: \n" + jobOpportunitiesVal.getText().toString() + "\n\n" +
                "You've given your teacher a total score of: \n" + totalScore);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ShowCourseActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.subjectRelevans:
                this.subRelVal.setText(""+ progress + " / 100");
                break;
            case R.id.teacherPerformance:
                this.teacherPerformanceVal.setText("" + progress + " / 100");
                break;
            case R.id.teacherPreparation:
                this.teacherPreparationVal.setText("" + progress + " / 100");
                break;
            case R.id.amountOfFeedback:
                this.amountOfFeedbackVal.setText("" + progress + " / 100");
                break;
            case R.id.examples:
                this.examplesVal.setText("" + progress + " / 100");
                break;
            case R.id.jobOpportunities:
                this.jobOpportunitiesVal.setText("" + progress + " / 100");
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void init(){
        this.courseTitle = findViewById(R.id.courseTitle);

        this.subjectRelevans = findViewById(R.id.subjectRelevans);
        this.subjectRelevans.setOnSeekBarChangeListener(this);
        this.teacherPerformance = findViewById(R.id.teacherPerformance);
        this.teacherPerformance.setOnSeekBarChangeListener(this);
        this.teacherPreparation = findViewById(R.id.teacherPreparation);
        this.teacherPreparation.setOnSeekBarChangeListener(this);
        this.amountOfFeedback = findViewById(R.id.amountOfFeedback);
        this.amountOfFeedback.setOnSeekBarChangeListener(this);
        this.examples = findViewById(R.id.examples);
        this.examples.setOnSeekBarChangeListener(this);
        this.jobOpportunities = findViewById(R.id.jobOpportunities);
        this.jobOpportunities.setOnSeekBarChangeListener(this);

        this.subRelVal = findViewById(R.id.subRelVal);
        this.teacherPerformanceVal = findViewById(R.id.teacherPerformanceVal);
        this.teacherPreparationVal = findViewById(R.id.teacherPreparationVal);
        this.amountOfFeedbackVal = findViewById(R.id.amountOfFeedbackVal);
        this.examplesVal = findViewById(R.id.examplesVal);
        this.jobOpportunitiesVal = findViewById(R.id.jobOpportunitiesVal);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("subjectRelevans", subRelVal.getText().toString());
        outState.putString("teacherPerformance", teacherPerformanceVal.getText().toString());
        outState.putString("teacherPreparation", teacherPreparationVal.getText().toString());
        outState.putString("amountOfFeedback", amountOfFeedbackVal.getText().toString());
        outState.putString("examples", examplesVal.getText().toString());
        outState.putString("jobOpportunities", jobOpportunitiesVal.getText().toString());
    }
}
