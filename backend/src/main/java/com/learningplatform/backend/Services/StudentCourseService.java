package com.learningplatform.backend.Services;

import com.learningplatform.backend.Model.Course;
import com.learningplatform.backend.Model.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentCourseService {

    private final StudentService studentService;
    private final CourseService courseService;

    public StudentCourseService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public Optional<Student> addCourseToStudent(Long studentId, Long courseId) {
        Optional<Student> studentOpt = studentService.getStudentById(studentId);
        Optional<Course> courseOpt = courseService.getCourseById(courseId);

        if (studentOpt.isEmpty() || courseOpt.isEmpty()) {
            return Optional.empty();
        }

        Student student = studentOpt.get();
        Course course = courseOpt.get();

        // Validación: máximo 3 cursos
        if (student.getCourses().size() >= 3) {
            return Optional.empty();
        }

        // Evitar duplicados
        boolean alreadyAssigned = student.getCourses().stream()
                .anyMatch(c -> c.getId().equals(courseId));

        if (alreadyAssigned) {
            return Optional.of(student);
        }

        student.getCourses().add(course);
        return Optional.of(student);
    }

    public Optional<Student> removeCourseFromStudent(Long studentId, Long courseId) {
        Optional<Student> studentOpt = studentService.getStudentById(studentId);

        if (studentOpt.isEmpty()) {
            return Optional.empty();
        }

        Student student = studentOpt.get();
        student.getCourses().removeIf(c -> c.getId().equals(courseId));
        return Optional.of(student);
    }
}
