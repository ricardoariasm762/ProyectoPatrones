package com.learningplatform.backend.Controllers;

import com.learningplatform.backend.Model.Student;
import com.learningplatform.backend.Services.StudentCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") // Para permitir peticiones desde Angular
@RequestMapping("/api/student-courses")
public class StudentCourseController {

    private final StudentCourseService studentCourseService;

    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Student> addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentCourseService.addCourseToStudent(studentId, courseId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Student> removeCourseFromStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentCourseService.removeCourseFromStudent(studentId, courseId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
