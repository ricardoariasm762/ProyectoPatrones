package com.learningplatform.backend.Model;

public class Course {
    private Long id;
    private String title;
    private String description;
    private int durationHours;

    public Course() {}

    public Course(Long id, String title, String description, int durationHours) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.durationHours = durationHours;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getDurationHours() { return durationHours; }
    public void setDurationHours(int durationHours) { this.durationHours = durationHours; }
}
