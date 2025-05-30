package com.learningplatform.backend.dto;

public class CourseRequestDTO {
    private Long studentId;
    private String title;
    private String description;
    private int durationHours;

    public CourseRequestDTO() {
    }

    public CourseRequestDTO(Long studentId, String title, String description, int durationHours) {
        this.studentId = studentId;
        this.title = title;
        this.description = description;
        this.durationHours = durationHours;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }
}
