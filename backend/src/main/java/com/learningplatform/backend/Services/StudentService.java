package com.learningplatform.backend.Services;

import com.learningplatform.backend.Model.Student;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public StudentService() {
        // Precargar estudiantes por defecto
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Optional<Student> getStudentById(Long id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    public Student addStudent(Student student) {
        student.setId(idCounter.incrementAndGet());
        students.add(student);
        return student;
    }

    public boolean deleteStudent(Long id) {
        return students.removeIf(s -> s.getId().equals(id));
    }

    public Optional<Student> updateStudent(Long id, Student updatedStudent) {
        return getStudentById(id).map(student -> {
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setEmail(updatedStudent.getEmail());
            student.setAge(updatedStudent.getAge());
            student.setCountry(updatedStudent.getCountry());
            return student;
        });
    }
}
