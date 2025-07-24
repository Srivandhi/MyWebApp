package com.sri;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class StudentService {

    private List<Student> studentList;

    public StudentService() {
        this.studentList = new ArrayList<>();
        // Initialize with some default data
        studentList.add(new Student(1, "Alice", 88.5, true));
        studentList.add(new Student(2, "Bob", 92.0, false));
        studentList.add(new Student(3, "Charlie", 76.8, true));
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

  
    public List<Student> getAllStudents() {
        return studentList.stream()
                .map(Student::new) 
                .collect(Collectors.toList());
    }
    public Optional<Student> getStudentById(int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }
    public boolean updateStudent(int id, Student updatedInfo) {
        Optional<Student> studentOptional = getStudentById(id);

        if (studentOptional.isPresent()) {
            Student originalStudent = studentOptional.get();
            originalStudent.setMarks(updatedInfo.getMarks());
            originalStudent.setFeesPaid(updatedInfo.isFeesPaid());
            return true;
        }
        return false;
    }
    public boolean deleteStudent(int id) {
        return studentList.removeIf(student -> student.getId() == id);
    }
}
