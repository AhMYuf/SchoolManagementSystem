package org.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@EqualsAndHashCode
public class Student {
    private String fName;
    private String lName;
    private String id;
    private int courseNum;
    private Course[] courses;
    private Department department;
    private Gender gender;

    private static int nextId = 1;

    public Student(String fName, String lName, int courseNum, Course[] courses, Gender gender) {
        this.id = String.format("S%03d", nextId++);
        this.fName = fName;
        this.lName = lName;
        this.courseNum = courseNum;
        this.courses = courses;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("id= %s, first name= %s, last name= %s, gender= %s, number of courses= %d, courses= %s, department= %s", id, fName, lName, gender, courseNum, Arrays.toString(courses), department);
    }
}
