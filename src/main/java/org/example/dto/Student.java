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

    /**
     * Constructor for Student class
     *
     * @param fName      first name of the student
     * @param lName      last name of the student
     * @param courseNum  the number of courses the student is taking
     * @param courses    the courses that the student is registered to
     * @param department the department of the student
     * @param gender     the gender of the student
     */
    public Student(String fName, String lName, int courseNum, Course[] courses, Department department, Gender gender) {
        this.id = String.format("S%03d", nextId++);
        this.fName = fName;
        this.lName = lName;
        this.courseNum = courseNum;
        this.courses = courses;
        this.department = department;
        this.gender = gender;
    }

    /**
     * toString method for the Student class
     *
     * @return the formatted string
     */
    @Override
    public String toString() {
        return String.format("Student{id= %s, first name= %s, last name= %s, gender= %s, number of courses= %d, courses= %s, department= %s}", id, fName, lName, gender, courseNum, Arrays.toString(courses), department);
    }
}
