package com.example.midterm_android.model;

import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private String name;
    private boolean gender;
    private double age;
    private String description;
    private int imageResourceID;

    public Person() {
    }

    public Person(int id, String name, boolean gender, double age, String description, int imageResourceID) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.description = description;
        this.imageResourceID = imageResourceID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }
}
