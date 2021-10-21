package com.example.coldcallerapp;

public class Student {
    private int name;
    private int image;

    public Student(int name, int image) {
        this.name = name;
        this.image = image;
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
}
