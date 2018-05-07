package com.example.ashutosh.dbproject;

public class Student {

    private String Fname;
    private char Minit;
    private String Lname;
    private String Roll_No;
    private char Sex;
    private String DOB;
    private int Dno;
    private String User_No;

    public Student()
    {

    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public char getMinit() {
        return Minit;
    }

    public void setMinit(char minit) {
        Minit = minit;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getRoll_No() {
        return Roll_No;
    }

    public void setRoll_No(String roll_No) {
        Roll_No = roll_No;
    }

    public char getSex() {
        return Sex;
    }

    public void setSex(char sex) {
        Sex = sex;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getDno() {
        return Dno;
    }

    public void setDno(int dno) {
        Dno = dno;
    }

    public String getUser_No() {
        return User_No;
    }

    public void setUser_No(String user_No) {
        User_No = user_No;
    }
}