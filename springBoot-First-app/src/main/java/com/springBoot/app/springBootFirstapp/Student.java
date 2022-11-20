package com.springBoot.app.springBootFirstapp;

public class Student {
    private String FirstName;
    private String LastName;
    //Getters And Setters for Student name.
     public Student(String FirstName,String LastName){
         this.FirstName=FirstName;
         this.LastName=LastName;
     }

     public String getStudentFirstName() {
         return FirstName ;
     }
    public void SetStudentFirstName() {
        this.FirstName=FirstName;
    }
    public String getStudentLastName() {
        return LastName ;
    }
    public void SetStudentLastName() {
        this.LastName = LastName;
    }
}
