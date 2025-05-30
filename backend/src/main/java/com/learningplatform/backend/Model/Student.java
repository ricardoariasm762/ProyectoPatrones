package com.learningplatform.backend.Model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String country;

    private List<Course> courses = new ArrayList<>();
}
