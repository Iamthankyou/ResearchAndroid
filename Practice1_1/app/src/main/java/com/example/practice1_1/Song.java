package com.example.practice1_1;

public class Song {

    private String name,singer;
    private Integer id;
    private double time;

    public Song(Integer id, String name, String singer, double time) {
        this.name = name;
        this.singer = singer;
        this.id = id;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
