package org.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Course class, its fields and methods.
 */
@Getter
@Setter
@EqualsAndHashCode
public class Course {
    private double credit;
    private String id;
    private Student[] students;
    private Department department;
    private Teacher teacher;
    private String courseName;

    private static int registeredStudents = 0;
    private static int studentNum = 0;
    private static int nextId = 1;
    private static final int MAX_REGISTRATION_COURSE = 5;

    /**
     * Constructor for Course class
     *
     * @param credit     the credit of the class
     * @param courseName the name of the course
     * @param department the department the course is part of.
     */
    public Course(double credit, String courseName, Department department) {
        this.id = String.format("C%03d", nextId++);
        this.credit = credit;
        this.students = new Student[MAX_REGISTRATION_COURSE];
        this.department = department;
        this.courseName = courseName;
    }

    /**
     * Method that adds a student to the department.
     *
     * @param student the student that is being adds to a course.
     */
    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && student.getId().equals(students[i].getId())) {
                System.out.println("Student has been already registered this course.");
            } else {
                students[i] = student;
                System.out.println("Student has been registered provided course successfully.");
                studentNum++;
                break;
            }
        }
    }

    /**
     * Method that removes a student to the department.
     *
     * @param student the student that is being removed from a course.
     */
    public void removeStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && student.getId().equals(students[i].getId())) {
                students[i] = null;
                System.out.println("Student has been removed provided course successfully.");
                studentNum--;
                break;
            } else {
                System.out.println("Student has not been already registered this course.");
            }
        }
    }

    /**
     * toString method for the Course class.
     *
     * @return the formatted string.
     */
    @Override
    public String toString() {
        return String.format("Course{id= %s, credit= %f, department= %s, studentList= %s, student number= %d, teacher= %s, course name= %s}",
                id, credit, department.getDepartmentName(), getStudentsName(), studentNum, teacher.fullName(), courseName);
    }

    /**
     * Method that gets the name of the students that registered to the course.
     *
     * @return (String) name of the students.
     */
    private String getStudentsName() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student : students) {
            if (student != null) {
                stringBuilder.append(student.getFName()).append(student.getLName());
            }
        }
        return stringBuilder.toString();
    }
}
