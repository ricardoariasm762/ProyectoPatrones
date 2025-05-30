package com.learningplatform.backend.Controllers;

import com.learningplatform.backend.Model.Course;
import com.learningplatform.backend.Services.CourseService;
import com.learningplatform.backend.Services.OpenAiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;
    private final OpenAiService openAiService;

    public CourseController(CourseService courseService, OpenAiService openAiService) {
        this.courseService = courseService;
        this.openAiService = openAiService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseService.updateCourse(id, course)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/{courseTitle}/ai-content")
    public ResponseEntity<String> getAiContentForCourse(@PathVariable String courseTitle) {
        String content = openAiService.generateLearningContent(courseTitle);
        return ResponseEntity.ok(content);
    }

}
