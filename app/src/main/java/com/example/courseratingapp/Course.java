package com.example.courseratingapp;

import java.util.ArrayList;

public class Course {
    private String teachername;
    private String subject;
    private ArrayList<Rating> ratings = new ArrayList<>();

    public Course(String teachername, String subject, ArrayList<Rating> ratings) {
        this.teachername = teachername;
        this.subject = subject;
        this.ratings = ratings;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }
}
