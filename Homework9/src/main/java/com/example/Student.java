package com.example;

public class Student {
    private String studentID;
    private String firstName;
    private String lastName;
    
    /*
     * @Description: Constructor with params
     * @param studentID
     * @param firstName
     * @param lastName
     * @Return:
     * @Author: Tianyang Zhao
     * @Date: 2025/10/8 13:18
     */
    public Student(String studentID, String firstName, String lastName) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getStudentID() {
        return studentID;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /*
     * @Description: Override toString used to print student info
     * @param
     * @Return: java.lang.String
     * @Author: Tianyang Zhao
     * @Date: 2025/10/8 13:20
     */
    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

