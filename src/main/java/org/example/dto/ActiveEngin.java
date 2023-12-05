package org.example.dto;

import java.util.Scanner;

public class ActiveEngin {
    private static boolean isExit = true;
    private SchoolManagementSystem school;
    private Scanner scanner;
    public ActiveEngin() {
        school = new SchoolManagementSystem();
        scanner = new Scanner(System.in);
    }

    private void menu(Scanner scanner, SchoolManagementSystem school) {
        System.out.println("Please input a number depending on the action you wish to realize. Enter '0' to exit the program.");
        System.out.println("""
                Enter:
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
                """);
        String input = scanner.nextLine();
        switch (input) {
            case "0":
                System.out.println("You are exiting the School Management System.");
                boolean isExit = false;
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
                registerCourse(scanner, school);
                break;
            case "15":
                unregisterCourse(scanner, school);
                break;
            default:
                System.out.println("There is no action regarding the inputted number! \nPlease enter a number attributed to a valid integer!");

        }
    }

    private void addTeacher(SchoolManagementSystem school) {
        String fName = getUserInput("Please enter the first name of the teacher.");
        String lName = getUserInput("Please enter the last name of the teacher.");
        String expStr = getUserInput("Please enter the years of experience of the teacher.");
        String gender = getUserInput("Please enter the gender of the teacher. The options are MALE, FEMALE or OTHERS.").toUpperCase();
        school.printDepartments();
        String departmentId = getUserInput("Please enter the department id of the teacher.").toUpperCase();
        int expInt = convertToInt(expStr);
        school.addTeacher(fName, lName, expInt, Gender.valueOf(gender), departmentId);
    }

    private void addDepartment(SchoolManagementSystem school) {
        String depName = getUserInput("Please enter a name for the department.");
        school.addDepartment(depName);
    }

    private void addCourse(SchoolManagementSystem school) {
        String creditStr = getUserInput("Please enter a credit number for the course."); //TODO decimal not integer
        String courseName = getUserInput("Please enter a name for the course.");
school.printDepartments();
String departmentId = getUserInput("Please enter a department for the course.");
        double creditDouble = convertToDouble(creditStr);

        school.addCourse(creditDouble, courseName, departmentId);
    }

    private void addStudent(SchoolManagementSystem school) {
        String fName = getUserInput("Please enter the first name of the student.");
        String lName = getUserInput("Please enter the last name of the student.");
        String gender = getUserInput("Please enter the gender of the student. Please input the gender in uppercase. The options are MALE, FEMALE or OTHERS.").toUpperCase();
       school.printDepartments();
        String departmentId = getUserInput("Please enter the student id.");
        school.addStudent(fName, lName, Gender.valueOf(gender), departmentId);
    }


    private void findDepartment(SchoolManagementSystem school) {
        school.printDepartments();
        String departmentId = getUserInput("Please input the department id (e.g.: D001).");
        school.findDepartment(departmentId);
    }

    private void findCourse(SchoolManagementSystem school) {
        String courseId = getUserInput("Please input the course id (e.g.: C001).");
        school.findCourse(courseId);
    }

    private void findTeacher(SchoolManagementSystem school) {
        String teacherId = getUserInput("Please input the teacher id (e.g.: T001).");
        school.findTeacher(teacherId);
    }

    private void findStudent(SchoolManagementSystem school) {
        String studentId = getUserInput("Please input the student id (e.g.: S001).");
        school.findTeacher(studentId);
    }

    private void modifyCourseTeacher(SchoolManagementSystem school) {
        String teacherId = getUserInput("Please enter the teacher's id (e.g.: T001).");
        String courseId = getUserInput("Please enter the course's id (e.g.: T001).");
        school.modifyCourseTeacher(teacherId, courseId);
    }

    private void registerCourse(Scanner scanner, SchoolManagementSystem school) {
        String studentId = getUserInput("Please enter the student id (e.g.: S001)");
        String courseId = getUserInput("Please enter the course id (e.g.: C001)");
        school.registerCourse(studentId, courseId);
    }

    private void unregisterCourse(Scanner scanner, SchoolManagementSystem school) {
        String studentId = getUserInput("Please enter the student id (e.g.: S001)");
        String courseId = getUserInput("Please enter the course id (e.g.: C001)");
        school.unregisterCourse(studentId, courseId);
    }


    private String getUserInput(String question) {
        System.out.println(question);
        String ans = scanner.nextLine();
        if (ans == null) {
            System.out.println(question);
            ans = scanner.nextLine();
        }
        return ans;
    }

    private int convertToInt(String input) {
        int output = -1;
        try {
            output = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Tip: \t PLEASE PAY EXTRA ATTENTION TO WHEN YOU ARE ENTERING THE VALUES (integer)!");
        }
        return output;
    }

    private double convertToDouble(String input) {
        double output = -1;
        try {
            output = Double.parseDouble(input);
        } catch (Exception e) {
            System.out.println("Tip: \t PLEASE PAY EXTRA ATTENTION TO WHEN YOU ARE ENTERING THE VALUES (double)!");
        }
        return output;
    }

    public void Menu() {

        while (isExit) {
            menu(scanner, school);
        }
        scanner.close();
    }
}

