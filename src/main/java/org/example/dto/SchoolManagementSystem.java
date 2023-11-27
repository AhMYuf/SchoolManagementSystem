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
    private Department[] departmentList;
    private Course[] courseList;
    private Teacher[] teacherList;
    private Student[] studentList;

    /**
     * Constructor of the SchoolManagementSystem class
     */
    public SchoolManagementSystem(String ignoredString) {
        departmentList = new Department[MAX_DEPARTMENT_NUM];
        teacherList = new Teacher[MAX_TEACHER_NUM];
        studentList = new Student[MAX_STUDENT_NUM];
    }

    /**
     * Method that finds a department
     *
     * @param departmentId the id of the department
     * @return all information regarding the department
     */
    public Department findDepartment(String departmentId) {
        return null;
    }

    /**
     * Method that displays all the teachers
     */
    public void printTeachers() {
    }

    /**
     * Method that adds a course to a teacher
     *
     * @param teacherId the id of the teacher that gets a new course
     * @param courseId  id of the course that the teacher will be assigned to
     */
    public void modifyCourseTeacher(String teacherId, String courseId) {
    }

    /**
     * Method that creates a new department
     *
     * @param departmentName name of the new department that will be created
     */
    public void addDepartment(String departmentName) {
        for (int i = 0; i < departmentList.length; i++) {
            if (departmentList[i] == null) {
                departmentList[i] = new Department(departmentName);
            }
        }
    }

    /**
     * Method that print all the students exist in the school
     */
    public void printStudents() {

    }

    /**
     * Method that finds a student
     *
     * @param studentId the id of the student
     * @return the information of the that is researched
     */
    public Student findStudent(String studentId) {
        return null;
    }

    /**
     * Method that adds a course to the school
     *
     * @param courseName the name of the course that will be added to the school
     */
    public void addCourse(String courseName) {

    }

    /**
     *
     */
    public void registerCourse() {

    }

    /**
     * Method that adds a new teacher to the school
     *
     * @param lName the last name of the teacher
     * @param fName the first name of the teacher
     * @param id    identification number assigned to the teacher
     */
    public void addTeacher(String lName, String fName, String id) {

    }

    /**
     * Method that finds a course
     *
     * @param courseName the name of the searched course
     */
    public Course findCourse(String courseName) {
        return null;
    }

    /**
     * Method that prints all the departments
     */
    public void printDepartments() {

    }

    /**
     * Method that adds a student to the school
     *
     * @param fName   the first name of the student
     * @param lName   the last name of the student
     * @param courses the courses that the student is registered to
     */
    public void addStudent(String fName, String lName, Course[] courses) {

    }

    /**
     * Method that finds a teacher
     *
     * @param id the identification assigned to a teacher
     * @return the asked teachers information
     */
    public Teacher findTeacher(String id) {
        return null;
    }
}
