package com.example.sqlitedatabase;
//file>new class
public class StudentModel {
    private String name;
    private int rollNo;
    private boolean isEnroll;

    public StudentModel(String name, int rollNo, boolean isEnroll) {
        this.name = name;
        this.rollNo = rollNo;
        this.isEnroll = isEnroll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public boolean isEnroll() {
        return isEnroll;
    }

    public void setEnroll(boolean enroll) {
        isEnroll = enroll;
    }
}
