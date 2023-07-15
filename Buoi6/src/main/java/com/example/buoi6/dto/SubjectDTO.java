package com.example.buoi6.dto;

public class SubjectDTO {
    private String name;
    private int student_id;
    public SubjectDTO() {
    }
    public SubjectDTO(String name) {
        this.name = name;
    }
    public SubjectDTO(String name, int student_id) {
        this.name = name;
        this.student_id = student_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
