package com.example.sqlitedatabase;
//file>new class
public class StudentModel {
    private int ID;
    private String name;
    private String rollNo;
    private String isEnroll;

    @Override
    public String toString() {
        return
                "Name : '" + name + '\'' +
                ", RollNmber : " + rollNo +
                ", IsEnroll : " + isEnroll;
    }


    public StudentModel(String name, String rollNo, String isEnroll) {
        this.name = name;
        this.rollNo = rollNo;
        this.isEnroll = isEnroll;
    }
    public StudentModel(int id,String name, String rollNo, String isEnroll) {
        this.ID = id;
        this.name = name;
        this.rollNo = rollNo;
        this.isEnroll = isEnroll;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String isEnroll() {
        return isEnroll;
    }

    public void setEnroll(String  enroll) {
        isEnroll = enroll;
    }
}
