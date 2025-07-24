package com.sri;

public class Student {

    
    private int id;
    private String name;
    private double marks;
    private boolean feesPaid;

   
    public Student(int id, String name, double marks, boolean feesPaid) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.feesPaid = feesPaid;
    }
    
    
    public Student(Student other) {
        this.id = other.id;
        this.name = other.name;
        this.marks = other.marks;
        this.feesPaid = other.feesPaid;
    }

 
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        if (marks >= 0) {
            this.marks = marks;
        }
    }

    public boolean isFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(boolean feesPaid) {
        this.feesPaid = feesPaid;
    }
    @Override
    public String toString() {
        return "Student[ID=" + id + ", Name='" + name + "', Marks=" + marks + ", Fees Paid=" + feesPaid + "]";
    }
}
