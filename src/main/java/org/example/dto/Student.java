package org.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Student class, its fields and methods.
 */
@Getter
@Setter
@EqualsAndHashCode
public class Student {
    private String fName;
    private String lName;
    private String id;
    private Course[] courses;
    private Department department;
    private Gender gender;
    private String fullName;
    private static final int MAX_STUDENT_COURSE_REGISTRATION = 5;

    private static int courseNum = 0;
    private static int nextId = 1;

    /**
     * Constructor for Student class.
     *
     * @param fName  first name of the student.
     * @param lName  last name of the student.
     * @param gender the gender of the student.
     * @param department the department of the student class.
     */
    public Student(String fName, String lName, Gender gender, Department department) {
        this.id = String.format("S%03d", nextId++);
        this.fName = fName;
        this.lName = lName;
        this.courses = new Course[MAX_STUDENT_COURSE_REGISTRATION];
        this.gender = gender;
        this.department = department;
        this.fullName = fullName();
    }

    /**
     * Method that adds a student to a course.
     *
     * @param course the course that the student is going to be registered to.
     */
    public void addCourse(Course course) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null && course.getId().equals(courses[i].getId())) {
                System.out.println("Student has been already registered this course.");
            } else {
                courses[i] = course;
                System.out.println("Student has been registered provided course successfully.");
                courseNum++;
                break;
            }
        }
    }


    /**
     * Method that removes a student from a course.
     *
     * @param course the course that the student is going to be registered to.
     */
    public void removeCourse(Course course) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null && course.getId().equals(courses[i].getId())) {
                courses[i] = null;
                courseNum--;
                System.out.println("Student has been removed provided course successfully.");
                break;
            } else {
                System.out.println("Student has not been already registered this course.");
            }
        }
    }

    /**
     * Method that takes the first and last name of the student and returns his entire name.
     *
     * @return the full name of the student.
     */
    public String fullName() {
        return String.format("%s %s", fName, lName);
    }

    /**
     * toString method for the Student class
     *
     * @return the formatted string
     */
    @Override
    public String toString() {
        return String.format("Student{id= %s, first name= %s, last name= %s, gender= %s, number of courses= %d, courses= %s, department= %s}",
                id, fName, lName, gender, courseNum, getCoursesName(), department.getDepartmentName());
    }

    /**
     * Method that gets the name of the courses that the student is registered to.
     *
     * @return (String) name of the courses.
     */
    private String getCoursesName() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Course course : courses) {
            if(course != null) {
                stringBuilder.append(course.getCourseName());
            }
        }
        return stringBuilder.toString();
    }
}
