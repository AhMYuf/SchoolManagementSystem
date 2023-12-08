package org.example.dto;

import java.util.Scanner;

/**
 * ActiveEngin class, its fields and methods.
 */
public class ActiveEngin {
    private static boolean isExit = true;
    private final SchoolManagementSystem school;
    private final Scanner scanner;

    /**
     * Constructor of Active engin.
     *
     * @param school initialized SchoolManagementSystem object.
     */
    public ActiveEngin(SchoolManagementSystem school) {
        this.school =  school;
        scanner = new Scanner(System.in);
    }

    /**
     * Method that keeps taking user input to create an interactive user experience.
     *
     * @param scanner initialized scanner object.
     * @param school  initialized SchoolManagementSystem object.
     */
    private void processUserAction(Scanner scanner, SchoolManagementSystem school) {
        System.out.println("\nPlease input a number depending on the action you wish to realize. Enter '0' to exit the program.");
        System.out.println("""
                Enter:
                0 to exit;
                1 to add a department;
                2 to add a course;
                3 to add a teacher;
                4 to add a student;
                5 to find a department;
                6 to find a course;
                7 to find a teacher;
                8 to find a student;
                9 to print all the departments;
                10 to print all courses;
                11 to print all teachers;
                12 to print all students;
                13 to modify course teacher;
                14 to register to a course;
                15 to unregister from a course.
                16 to get the number of departments;
                17 to get the number of courses;
                18 to get the number of teachers;
                19 to get the number of students;
                """);
        String input = scanner.nextLine();
        switch (input) {
            case "0":
                System.out.println("You are exiting the School Management System.");
                isExit = false;
                break;
            case "1":
                addDepartment(school);
                break;
            case "2":
                addCourse(school);
                break;
            case "3":
                addTeacher(school);
                break;
            case "4":
                addStudent(school);
                break;
            case "5":
                findDepartment(school);
                break;
            case "6":
                findCourse(school);
                break;
            case "7":
                findTeacher(school);
                break;
            case "8":
                findStudent(school);
                break;
            case "9":
                school.printDepartments();
                break;
            case "10":
                school.printCourses();
                break;
            case "11":
                school.printTeachers();
                break;
            case "12":
                school.printStudents();
                break;
            case "13":
                modifyCourseTeacher(school);
                break;
            case "14":
                registerCourse(school);
                break;
            case "15":
                unregisterCourse(school);
                break;
            case "16":
                numberOfDepartments();
                break;
            case "17":
                numberOfCourses();
                break;
            case "18":
                numberOfTeachers();
                break;
            case "19":
                numberOfStudents();
                break;
            default:
                System.out.println("There is no action regarding the inputted number! \nPlease enter a integer attributed to a valid action!");
        }
    }

    /**
     * Method that asks user questions to gather all necessary data to add a new department to SchoolManagementSystem.
     *
     * @param school initialized SchoolManagementSystem object.
     */
    private void addDepartment(SchoolManagementSystem school) {
        String depName = getUserInput("Please enter a name for the department.");
        school.addDepartment(depName);
    }

    /**
     * Method that asks user questions to gather all necessary data to add a new course to SchoolManagementSystem.
     *
     * @param school initialized SchoolManagementSystem object.
     */
    private void addCourse(SchoolManagementSystem school) {
        String creditStr = getUserInput("Please enter a credit number for the course.");
        String courseName = getUserInput("Please enter a name for the course.");
        school.printDepartments();
        String departmentId = getUserInput("Please enter a department id for the course (e.g.: D001).");
        double creditDouble = convertToDouble(creditStr);

        school.addCourse(creditDouble, courseName, departmentId);
    }

    /**
     * Method that asks user questions to gather all necessary data to add a new teacher to SchoolManagementSystem.
     *
     * @param school initialized SchoolManagementSystem object.
     */
    private void addTeacher(SchoolManagementSystem school) {
        String fName = getUserInput("Please enter the first name of the teacher.");
        String lName = getUserInput("Please enter the last name of the teacher.");
        String expStr = getUserInput("Please enter the years of experience of the teacher.");
        String gender = getUserInput("Please enter the gender of the teacher. The options are MALE, FEMALE or OTHERS.").toUpperCase();
        school.printDepartments();
        String departmentId = getUserInput("Please enter the department id of the teacher. (e.g.: D001).").toUpperCase();
        int expInt = convertToInt(expStr);
        school.addTeacher(fName, lName, expInt, Gender.valueOf(gender), departmentId);
    }

    /**
     * Method that asks user questions to gather all necessary data to add a new student to SchoolManagementSystem.
     *
     * @param school initialized SchoolManagementSystem object.
     */
    private void addStudent(SchoolManagementSystem school) {
        String fName = getUserInput("Please enter the first name of the student.");
        String lName = getUserInput("Please enter the last name of the student.");
        String gender = getUserInput("Please enter the gender of the student. The options are MALE, FEMALE or OTHERS.").toUpperCase();
        school.printDepartments();
        String departmentId = getUserInput("Please enter the department id (e.g.: D001).").toUpperCase();
        school.addStudent(fName, lName, Gender.valueOf(gender), departmentId);
    }

    /**
     * Method that asks user questions to gather all necessary data to find a department from SchoolManagementSystem.
     *
     * @param school initialized SchoolManagementSystem object.
     */
    private void findDepartment(SchoolManagementSystem school) {
        school.printDepartments();
        String departmentId = getUserInput("Please input the department id (e.g.: D001).");
        school.findDepartment(departmentId);
    }

    /**
     * Method that asks user questions to gather all necessary data to find a course from SchoolManagementSystem.
     *
     * @param school initialized SchoolManagementSystem object.
     */
    private void findCourse(SchoolManagementSystem school) {
        String courseId = getUserInput("Please input the course id (e.g.: C001).");
        school.findCourse(courseId);
    }

    /**
     * Method that asks user questions to gather all necessary data to find a teacher from SchoolManagementSystem.
     *
     * @param school initialized SchoolManagementSystem object.
     */
    private void findTeacher(SchoolManagementSystem school) {
        String teacherId = getUserInput("Please input the teacher id (e.g.: T001).");
        school.findTeacher(teacherId);
    }

    /**
     * Method that asks user questions to gather all necessary data to find a student from SchoolManagementSystem.
     *
     * @param school initialized SchoolManagementSystem object.
     */
    private void findStudent(SchoolManagementSystem school) {
        String studentId = getUserInput("Please input the student id (e.g.: S001).");
        school.findTeacher(studentId);
    }

    /**
     * Method that asks user questions to gather all necessary data to modify the teacher of a course from SchoolManagementSystem.
     *
     * @param school initialized SchoolManagementSystem object.
     */
    private void modifyCourseTeacher(SchoolManagementSystem school) {
        String teacherId = getUserInput("Please enter the teacher's id (e.g.: T001).");
        String courseId = getUserInput("Please enter the course's id (e.g.: C001).");
        school.modifyCourseTeacher(teacherId, courseId);
    }

    /**
     * Method that asks user questions to gather all necessary data to register a student to a course from SchoolManagementSystem.
     *
     * @param school initialized SchoolManagementSystem object.
     */
    private void registerCourse(SchoolManagementSystem school) {
        String studentId = getUserInput("Please enter the student id (e.g.: S001)");
        String courseId = getUserInput("Please enter the course id (e.g.: C001)");
        school.registerCourse(studentId, courseId);
    }

    /**
     * Method that asks user questions to gather all necessary data to unregister a student from course from SchoolManagementSystem.
     *
     * @param school initialized SchoolManagementSystem object.
     */
    private void unregisterCourse(SchoolManagementSystem school) {
        String studentId = getUserInput("Please enter the student id (e.g.: S001)");
        String courseId = getUserInput("Please enter the course id (e.g.: C001)");
        school.unregisterCourse(studentId, courseId);
    }

    /**
     * Method that prints registered department number.
     */
    private void numberOfDepartments() {
        System.out.println("[ " + school.getRegisteredDepartmentNumber() + " ]");
    }

    /**
     * Method that prints registered course number.
     */
    private void numberOfCourses() {
        System.out.println("[ " + school.getRegisteredCourseNumber() + " ]");
    }

    /**
     * Method that prints registered teacher number.
     */
    private void numberOfTeachers() {
        System.out.println("[ " + school.getRegisteredTeacherNumber() + " ]");
    }

    /**
     * Method that prints registered student number.
     */
    private void numberOfStudents() {
        System.out.println("[ " + school.getRegisteredStudentNumber() + " ]");
    }

    /**
     * Method that keeps asking question till it is valid.
     *
     * @param strIn user input.
     * @return the inputted
     */
    private String getUserInput(String strIn) {
        System.out.println(strIn);
        String strOut = scanner.nextLine();
        if (strOut == null) {
            System.out.println(strIn);
            strOut = scanner.nextLine();
        }
        return strOut;
    }

    /**
     * Method that converts a string to an integer.
     *
     * @param strIn the inputted string.
     * @return an integer.
     */
    private int convertToInt(String strIn) {
        int strOut = -1;
        try {
            strOut = Integer.parseInt(strIn);
        } catch (Exception e) {
            System.out.println("Tip: \t PLEASE PAY EXTRA ATTENTION TO WHEN YOU ARE ENTERING THE VALUES (integer)!");
        }
        return strOut;
    }

    /**
     * Method that converts a string to a double.
     *
     * @param strIn the inputted string.
     * @return a double.
     */
    private double convertToDouble(String strIn) {
        double strOut = -1;
        try {
            strOut = Double.parseDouble(strIn);
        } catch (Exception e) {
            System.out.println("Tip: \t PLEASE PAY EXTRA ATTENTION TO WHEN YOU ARE ENTERING THE VALUES (double)!");
        }
        return strOut;
    }

    /**
     * Method that runs the processUserAction method while isExit boolean is true.
     */
    public void menu() {
        while (isExit) {
            processUserAction(scanner, school);
        }
        scanner.close();
    }
}
