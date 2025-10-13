package com.example;

import java.util.ArrayList;
import java.util.List;

public class EngClass {
    private List<Student> students;

    public EngClass() {
        this.students = new ArrayList<>();
    }

    
    /*
     * @Description: add student into class
     * @param student
     * @Return: boolean
     * @Author: Tianyang Zhao
     * @Date: 2025/10/8 13:22
     */
    public boolean addStudent(Student student) {
        if (student == null) {
            System.out.println("error: student can't be null");
            return false;
        }

        for (Student existingStudent : students) {
            if (existingStudent.getStudentID().equals(student.getStudentID())) {
                System.out.println("error: " + student.getStudentID() + " already exists");
                return false;
            }
        }
        
        students.add(student);
        System.out.println("[success]: " + student.getFirstName() + " " + student.getLastName() +
                          " already added!");
        return true;
    }
    
    /*
     * @Description:
     * @param studentID
     * @Return: boolean
     * @Author: Tianyang Zhao
     * @Date: 2025/10/8 13:22
     */
    public boolean deleteStudent(String studentID) {
        if (studentID == null || studentID.trim().isEmpty()) {
            System.out.println("[error]: studentID can't be null]");
            return false;
        }
        
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID().equals(studentID)) {
                Student removedStudent = students.remove(i);
                System.out.println("[success]: " + removedStudent.getFirstName() + " " + removedStudent.getLastName() +
                        " already deleted!");
                return true;
            }
        }

        return false;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    /*
     * @Description:print students list
     * @param
     * @Return: void
     * @Author: Tianyang Zhao
     * @Date: 2025/10/8 13:24
     */
    public void printStudents() {
        
        System.out.println("=== students list ===");
        System.out.println("size: " + students.size());
        System.out.println("-------------------");
        
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println((i + 1) + ". " + student.toString());
        }
        
        System.out.println("===================");
    }
    
    /*
     * @Description: get size of class
     * @param
     * @Return: int
     * @Author: Tianyang Zhao
     * @Date: 2025/10/8 13:26
     */
    public int getStudentCount() {
        return students.size();
    }
    

}

