package org.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
public class Student {
    private String fName;
    private String lName;
    private String id;
    private Course[] courses;
    // TODO Can Student take class from multiple department like humanity and english and compsci courses may belong to different department
    private Department department;
    private Gender gender;
    private String fullName;
    private static final int MAX_STUDENT_COURSE_REGISTRATION = 5;

    private static int courseNum = 0;
    private static int nextId = 1;

    /**
     * Constructor for Student class
     *
     * @param fName  first name of the student
     * @param lName  last name of the student
     * @param gender the gender of the student
     */
    public Student(String fName, String lName, Gender gender, Department department) { // String department??
        this.id = String.format("S%03d", nextId++);
        this.fName = fName;
        this.lName = lName;
        this.courses = new Course[MAX_STUDENT_COURSE_REGISTRATION];
        this.gender = gender;
        this.department = department;
        this.fullName = fullName();
    }


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

    private String getCoursesName() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Course course : courses) {
            if(course != null) {
                stringBuilder.append(course.getCourseName());
            }
        }
        return stringBuilder.toString();
    }
    // TODO if teacher tells me a student can take courses from multiple departmenets, make a method to get department name too
}
