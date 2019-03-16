package com.example.courseratingapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Course implements Parcelable {
    private String teachername;
    private String subject;
    private ArrayList<Rating> ratings = new ArrayList<>();



    public Course() {
    }

    public Course(String subject) {
        this.subject = subject;
    }

    public Course(String teachername, String subject, ArrayList<Rating> ratings) {
        this.teachername = teachername;
        this.subject = subject;
        this.ratings = ratings;

    }


    protected Course(Parcel in) {
        teachername = in.readString();
        subject = in.readString();
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(teachername);
        dest.writeString(subject);
    }
}
