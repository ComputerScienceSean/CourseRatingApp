package com.example.courseratingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.nio.channels.SeekableByteChannel;

public class ShowCourseActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar subjectRelevans, teacherPerformance, teacherPreparation, amountOfFeedback, examples, jobOpportunities;
    private TextView subRelVal, teacherPerformanceVal, teacherPreparationVal, amountOfFeedbackVal, examplesVal, jobOpportunitiesVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_course);
        init();

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
        Intent rate = new Intent(this, ChooseCourseActivity.class);
        startActivity(rate);

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
