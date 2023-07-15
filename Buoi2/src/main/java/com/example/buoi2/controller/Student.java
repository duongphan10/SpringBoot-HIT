package com.example.buoi2.controller;

public class Student {
    private int msv;
    private int age;
    private String name;

    public void setMsv(int msv) {
        this.msv = msv;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMsv() {
        return msv;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Student(int msv, int age, String name) {
        this.msv = msv;
        this.age = age;
        this.name = name;
    }

}
