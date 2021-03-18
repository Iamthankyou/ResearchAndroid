package com.example.recycleview;

public class Person {
    private String name, year, img;

    public Person(String name, String year, String img) {
        this.name = name;
        this.year = year;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
