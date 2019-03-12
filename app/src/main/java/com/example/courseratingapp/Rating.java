package com.example.courseratingapp;

public class Rating {
    private int subjectRelevans = 1;
    private int teacherPerformance = 1;
    private int teacherPreparation = 1;
    private int amountOfFeedback = 1;
    private int examples = 1;
    private int jobOpportunities = 1;

    public Rating() {
    }

    public int getSubjectRelevans() {
        return subjectRelevans;
    }

    public void setSubjectRelevans(int subjectRelevans) {
        this.subjectRelevans = subjectRelevans;
    }

    public int getTeacherPerformance() {
        return teacherPerformance;
    }

    public void setTeacherPerformance(int teacherPerformance) {
        this.teacherPerformance = teacherPerformance;
    }

    public int getAmountOfFeedback() {
        return amountOfFeedback;
    }

    public void setAmountOfFeedback(int amountOfFeedback) {
        this.amountOfFeedback = amountOfFeedback;
    }

    public int getTeacherPreparation() {
        return teacherPreparation;
    }

    public void setTeacherPreparation(int teacherPreparation) {
        this.teacherPreparation = teacherPreparation;
    }

    public int getExamples() {
        return examples;
    }

    public void setExamples(int examples) {
        this.examples = examples;
    }

    public int getJobOpportunities() {
        return jobOpportunities;
    }

    public void setJobOpportunities(int jobOpportunities) {
        this.jobOpportunities = jobOpportunities;
    }
}
