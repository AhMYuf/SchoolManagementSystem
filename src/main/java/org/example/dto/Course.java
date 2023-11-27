package org.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@EqualsAndHashCode
public class Course {
    private double credit;
    private String id;
    private Student[] students;
    private Department department;
    private int studentNum;
    private Teacher teacher;
    private String courseName;

    private static int nextId = 1;

    /**
     * Constructor for Course class
     *
     * @param credit     the credit of the class
     * @param students   the students
     * @param department the department that the course belongs to
     * @param studentNum the number of the students registered to the course
     * @param teacher    the teacher's characteristics
     * @param courseName the name of the course
     */
    public Course(double credit, Student[] students, Department department, int studentNum, Teacher teacher, String courseName) {
        this.id = String.format("C%03d", nextId++);
        this.credit = credit;
        this.department = department;
        this.students = students;
        this.studentNum = studentNum;
        this.teacher = teacher;
        this.courseName = courseName;
    }

    /**
     * toString method for the Course class
     *
     * @return the formatted string
     */
    @Override
    public String toString() {
        return String.format("Course{id= %s, credit= %f, department= %s, student= %s, student number= %d, teacher= %s, course name= %s}", id, credit, department, Arrays.toString(students), studentNum, teacher, courseName);
    }
}
