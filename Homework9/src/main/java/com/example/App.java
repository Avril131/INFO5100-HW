package com.example;

public class App {
    public static void main(String[] args) {

        // create engineering class
        EngClass engClass = new EngClass();
        System.out.println("[success]: engineering class created!");
        
        // create students
        Student student1 = new Student("2025001", "John", "Doe");
        Student student2 = new Student("2025002", "Tianyang", "Zhao");
        Student student3 = new Student("2025003", "Alice", "A");
        Student student4 = new Student("2025004", "Bob", "Xyz");
        
        System.out.println("[success]: students created!");
        System.out.println();
        
        // test add students
        System.out.println("=== test add students ===");
        engClass.addStudent(student1);
        engClass.addStudent(student2);
        engClass.addStudent(student3);
        engClass.addStudent(student4);

        // print
        engClass.printStudents();
        System.out.println();

        
        // test delete students
        System.out.println("=== test delete students ===");
        engClass.deleteStudent("2025002");
        
        // print
        engClass.printStudents();
        System.out.println();

    }
}
