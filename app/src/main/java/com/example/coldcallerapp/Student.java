package com.example.coldcallerapp;

import java.io.Serializable;

public class Student implements Serializable {
    private int name;
    private int image;

    private int callRate;

    public Student(int name, int image) {
        this.name = name;
        this.image = image;
        this.callRate = 0;
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
