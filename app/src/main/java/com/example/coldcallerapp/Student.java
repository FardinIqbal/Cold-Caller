package com.example.coldcallerapp;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private int name;
    private int image;
    private int callTracker;
    private String fullName;

    private ArrayList<String> dateAndTimeLastCalled = new ArrayList<String>();

    public Student(int name, int image, String fullName) {
        this.name = name;
        this.image = image;
        this.fullName = fullName;
        this.callTracker = 0;
    }

    public String toString() {
        String space1 = "";
        String space2 = "                       ";
        while(fullName.length() + space1.length() <= 35){
            space1 = space1 + " ";
        }
        if (dateAndTimeLastCalled.size() == 0) {
            return fullName;
        }
        return fullName
                + space1
                + getLastDateAndTimeCalled()
                + space2
                + getCallTracker();
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

    public int getCallTracker() {
        return callTracker;
    }

    public void setCallTracker(int callRate) {
        this.callTracker = callRate;
    }
}
