package com.sri;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
       
        StudentService studentService = new StudentService();
        System.out.println("Student Management System Initialized.");
        printSeparator();

       
        System.out.println("--- Initial Student List (READ ALL) ---");
        List<Student> allStudents = studentService.getAllStudents();
        allStudents.forEach(System.out::println);
        printSeparator();

       
        System.out.println("--- Adding a new student (CREATE) ---");
        Student newStudent = new Student(4, "David", 95.2, false);
        studentService.addStudent(newStudent);
        System.out.println("Added student: " + newStudent.getName());
        studentService.getAllStudents().forEach(System.out::println);
        printSeparator();

       
        System.out.println("--- Finding a student by ID (READ ONE) ---");
        System.out.println("Searching for student with ID 2...");
        Optional<Student> foundStudent = studentService.getStudentById(2);
        foundStudent.ifPresent(student -> System.out.println("Found: " + student));

        System.out.println("\nSearching for student with ID 99...");
        Optional<Student> notFoundStudent = studentService.getStudentById(99);
        if (notFoundStudent.isEmpty()) {
            System.out.println("Student with ID 99 not found.");
        }
        printSeparator();

        
        System.out.println("--- Updating student with ID 2 (UPDATE) ---");
        Student updatesForBob = new Student(2, "Bob", 93.5, true); 
        boolean isUpdated = studentService.updateStudent(2, updatesForBob);
        if(isUpdated){
            System.out.println("Student with ID 2 was updated successfully.");
        }
        studentService.getAllStudents().forEach(System.out::println);
        printSeparator();

       
        System.out.println("--- Deleting student with ID 1 (DELETE) ---");
        boolean isDeleted = studentService.deleteStudent(1);
        if (isDeleted) {
            System.out.println("Student with ID 1 was deleted successfully.");
        }
        System.out.println("--- Final Student List ---");
        studentService.getAllStudents().forEach(System.out::println);
        printSeparator();
    }

    private static void printSeparator() {
        System.out.println("\n" + "=".repeat(50) + "\n");
    }
}
