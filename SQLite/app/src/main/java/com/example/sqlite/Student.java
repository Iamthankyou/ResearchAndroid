package com.example.sqlite;

public class Student {
    private int id;
    private String name;
    private String year;

    public Student(int id, String name, String year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
