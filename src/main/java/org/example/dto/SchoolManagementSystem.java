package org.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SchoolManagementSystem {
    private static final int MAX_DEPARTMENT_NUM = 5;
    private static final int MAX_STUDENT_NUM = 200;
    private static final int MAX_STUDENT_COURSE_REGISTRATION = 5;
    private static final int MAX_TEACHER_NUM = 20;
    private static final int MAX_COURSE_NUM = 30;
    private static final int MAX_REGISTRATION_COURSE = 5;

    public SchoolManagementSystem() {
    }

    public void findDepartment() {
        return; //not void
    }

    public void printTeachers() {
    }

    public void modifyCourseTeacher() {
    }

    public void addDepartment() {

    }

    public void printStudents() {

    }

    public void findStudent() {
        //not void
    }

    public void addCourse() {

    }

    public void registerCourse() {

    }

    public void addTeacher() {

    }

    public void findCourse() {
        //not void
    }

    public void printDepartments() {

    }

    public void addStudent() {

    }

    public void findTeacher() {
        // not void
    }
}
