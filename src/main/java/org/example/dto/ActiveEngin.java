package org.example.dto;

import java.util.Scanner;

public class ActiveEngin {
    private static boolean isExit = true;

    public ActiveEngin() {
        SchoolManagementSystem school = new SchoolManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (isExit) {
            menu(scanner, school);
        }
        scanner.close();
    }

    private static void menu(Scanner scanner, SchoolManagementSystem school) {
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
        String input = scanner.next();
        switch (input) {
            case "0":
                System.out.println("You are exiting the School Management System.");
                boolean isExit = false;
                break;
            case "1":
                addDepartment(scanner,school);
                break;
            case "2":
                addCourse(scanner,school);
                break;
            case "3":
                addTeacher(scanner, school);
                break;
            case "4":
                addStudent(scanner, school);
                break;
            case "5":
                findDepartment(scanner, school);
                break;
            case "6":
                findCourse(scanner, school);
                break;
            case "7":
                findTeacher(scanner, school);
                break;
            case "8":
                findStudent(scanner, school);
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
                modifyCourseTeacher(scanner, school);
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

    private static void addDepartment(Scanner scanner, SchoolManagementSystem school) {
        System.out.println("Please enter a name for the department.");
        String depName = scanner.nextLine();
        school.addDepartment(depName);
    }

    private static void addCourse(Scanner scanner, SchoolManagementSystem school) {
        try {
            System.out.println("Please enter a credit number for the course.");
            double credit = scanner.nextDouble();
            System.out.println("Please enter a name for the course.");
            String courseName = scanner.nextLine();
            System.out.println("Please enter a department for the course.");
            String department = scanner.nextLine();
            school.addCourse(credit, courseName, department);
        } catch (Exception e) {
            System.out.println("One of the inputted values is not valid. Please restart the process over again.");
            System.out.println("Tip: \t PLEASE PAY EXTRA ATTENTION TO WHEN YOU ARE ENTERING THE VALUES!");
        }
    }

    private static void addTeacher(Scanner scanner, SchoolManagementSystem school) {
        try {
            System.out.println("Please enter the first name of the teacher.");
            String fName = scanner.nextLine();
            System.out.println("Please enter the last name of the teacher.");
            String lName = scanner.nextLine();
            System.out.println("Please enter the years of experience of the teacher.");
            byte experience = scanner.nextByte();
            System.out.println("Please enter the gender of the teacher.");
            String gender = scanner.nextLine().toUpperCase();
            System.out.println("Please enter the department id of the teacher.");
            String departmentId = scanner.nextLine();
            school.addTeacher(fName, lName, experience, Gender.valueOf(gender), departmentId);
        } catch (Exception e) {
            System.out.println("One of the inputted values is not valid. Please restart the process over again.");
            System.out.println("Tip: \t PLEASE PAY EXTRA ATTENTION TO WHEN YOU ARE ENTERING THE VALUES!");
        }
    }

    private static void addStudent(Scanner scanner, SchoolManagementSystem school) {
        try {
            System.out.println("Please enter the first name of the student.");
            String fName = scanner.nextLine();
            System.out.println("Please enter the last name of the student.");
            String lName = scanner.nextLine();
            System.out.println("Please enter the gender of the student.");
            String gender = scanner.nextLine().toUpperCase();
            System.out.println("Please enter the students grades.");
            String scores = scanner.nextLine();
            System.out.println("Please enter the student id.");
            String departmentId = scanner.nextLine();
            school.addStudent(fName, lName, Gender.valueOf(gender), scores, departmentId);
        } catch (Exception e) {
            System.out.println("One of the inputted values is not valid. Please restart the process over again.");
            System.out.println("Tip: \t PLEASE PAY EXTRA ATTENTION TO WHEN YOU ARE ENTERING THE VALUES!");
        }
    }
    private static void findDepartment(Scanner scanner, SchoolManagementSystem school) {
        try {
            System.out.println("Please input the department id (e.g.: D001).");
            String departmentId = scanner.nextLine();
            school.findDepartment(departmentId);
        } catch (Exception e) {
            System.out.println("The inputted id does not match any existing department id!");
        }
    }
    private static void findCourse(Scanner scanner, SchoolManagementSystem school) {
        try {
            System.out.println("Please input the course id (e.g.: C001).");
            String courseId = scanner.nextLine();
            school.findCourse(courseId);
        } catch (Exception e) {
            System.out.println("The inputted id does not match any existing course id!");
        }
    }

    private static void findTeacher(Scanner scanner, SchoolManagementSystem school) {
        try {
            System.out.println("Please input the teacher id (e.g.: T001).");
            String teacherId = scanner.nextLine();
            school.findTeacher(teacherId);
        } catch (Exception e) {
            System.out.println("The inputted id does not match any existing teacher id!");
        }
    }

    private static void findStudent(Scanner scanner, SchoolManagementSystem school) {
        try {
            System.out.println("Please input the student id (e.g.: S001).");
            String studentId = scanner.nextLine();
            school.findTeacher(studentId);
        } catch (Exception e) {
            System.out.println("The inputted id does not match any existing student id!");
        }
    }
    private static void modifyCourseTeacher(Scanner scanner, SchoolManagementSystem school) {
        try {
            System.out.println("Please enter the teacher's id (e.g.: T001).");
            String teacherId = scanner.next();
            System.out.println("Please enter the course's id (e.g.: T001).");
            String courseId = scanner.next();
            school.modifyCourseTeacher(teacherId, courseId);
        } catch (Exception e) {
            System.out.println("One or both of the ids entered are wrong.");
        }
    }

    private static void registerCourse(Scanner scanner, SchoolManagementSystem school) {
        try {
            System.out.println("Please enter the student id (e.g.: S001)");
            String studentId = scanner.nextLine();
            System.out.println("Please enter the course id (e.g.: C001)");
            String courseId = scanner.nextLine();
            school.registerCourse(studentId, courseId);
        } catch (Exception e) {
            System.out.println("One or both of the entered ids are invalid.");
        }
    }
    private static void unregisterCourse(Scanner scanner, SchoolManagementSystem school) {
        try {
            System.out.println("Please enter the student id (e.g.: S001)");
            String studentId = scanner.nextLine();
            System.out.println("Please enter the course id (e.g.: C001)");
            String courseId = scanner.nextLine();
            school.unregisterCourse(studentId, courseId);
        } catch (Exception e) {
            System.out.println("One or both of the entered ids are invalid.");
        }
    }
}

