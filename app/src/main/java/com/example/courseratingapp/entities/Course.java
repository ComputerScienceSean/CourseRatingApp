package com.example.courseratingapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Course implements Parcelable {
    private String teachername;
    private String subject;
    private static ArrayList<Course> courses = new ArrayList<>();
    private boolean rated;


    public Course(String subject) {
        this.subject = subject;
    }

    public Course(String teachername, String subject, ArrayList<Course> courses) {
        this.teachername = teachername;
        this.subject = subject;
        this.courses = courses;

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

    public boolean isRated() {
        return rated;
    }

    public void setRated(boolean rated) {
        this.rated = rated;
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

    public static void setCourses(ArrayList<Course> courses) {
        Course.courses = courses;
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

    public static void loadCourses(){
        ArrayList<Course> mlist = new ArrayList<>();
        mlist.add(new Course("Python"));
        mlist.add(new Course("Android"));
        mlist.add(new Course("Angular"));
        mlist.add(new Course("C#"));
        courses = mlist;
    }

    public static ArrayList<Course> getCourses(){
        return courses;
    }


    public static void updateCourse(Course course){
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getSubject().equals(course.getSubject())){
                courses.set(i, course);
            }
        }
    }

}
