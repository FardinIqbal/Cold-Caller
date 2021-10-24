package com.example.coldcallerapp;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private int name;
    private int image;
    private int callRate;
    private ArrayList<String> dateAndTimeLastCalled = new ArrayList<String>();

    public Student(int name, int image) {
        this.name = name;
        this.image = image;
        this.callRate = 0;
    }

    public void addToLastDateAndTimeCalled(String dateAndTime) {
        dateAndTimeLastCalled.add(0, dateAndTime);
    }
    public String getLastDateAndTimeCalled() {
        return dateAndTimeLastCalled.get(0);
    }
    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getCallRate() {
        return callRate;
    }

    public void setCallRate(int callRate) {
        this.callRate = callRate;
    }
}
