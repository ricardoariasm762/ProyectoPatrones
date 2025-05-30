package com.learningplatform.backend.Services;
import com.learningplatform.backend.Model.Course;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CourseService {

    private final List<Course> courses = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public List<Course> getAllCourses() {
        return courses;
    }

    public Optional<Course> getCourseById(Long id) {
        return courses.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Course addCourse(Course course) {
        course.setId(idCounter.incrementAndGet());
        courses.add(course);
        return course;
    }

    public boolean deleteCourse(Long id) {
        return courses.removeIf(c -> c.getId().equals(id));
    }

    public Optional<Course> updateCourse(Long id, Course updatedCourse) {
        return getCourseById(id).map(course -> {
            course.setTitle(updatedCourse.getTitle());
            course.setDescription(updatedCourse.getDescription());
            course.setDurationHours(updatedCourse.getDurationHours());
            return course;
        });
    }
}
