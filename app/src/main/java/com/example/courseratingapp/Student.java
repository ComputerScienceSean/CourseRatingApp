package com.example.courseratingapp;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private Set<Course> courses = new HashSet<>();
    private String firstname;
    private String lastname;
    private String email;
    private String CPR;

    public Student() {
    }

    public Student(String firstname, String lastname, String email, String CPR) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.CPR = CPR;
    }

    public Student(Set<Course> courses) {
        this.courses = courses;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }
}
