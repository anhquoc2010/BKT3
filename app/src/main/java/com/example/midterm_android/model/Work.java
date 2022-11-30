package com.example.midterm_android.model;

import java.io.Serializable;

public class Work implements Serializable {
    private String name;
    private String description;
    private int stars;
    private int imageResourceID;
    private int idPerson;

    public Work() {
    }

    public Work(String name, String description, int stars, int imageResourceID, int idPerson) {
        this.name = name;
        this.description = description;
        this.stars = stars;
        this.imageResourceID = imageResourceID;
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }
}
