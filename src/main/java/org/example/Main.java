package org.example;

import org.example.dto.SchoolManagementSystem;

import java.io.Console;
import java.util.Scanner;

public class Main {

private static boolean isExit =true;
    public static void main(String[] args) {
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
                10 to print all teachers;
                11 to print all courses;
                11 to print all students;
                12 to modify course teacher;
                13 to register to a course;
                14 to unregister from a course.
                """);
        String input = scanner.next();
        switch (input) {
            case "0":
                System.out.println("You are exiting the School Management System.");
                isExit = false;
                break;
            case "1":
                addDepartment(scanner,school);
                break;
            case "2":
                System.out.println("Please enter a name for the department name.");

                school.addCourse();
                break;
            case "3":
                System.out.println("Please enter a name for the department name.");

                break;
            case 4:
                System.out.println("Please enter a name for the department name.");

                break;
            case 5:
                System.out.println("Please enter a name for the department name.");

                break;
            case 6:
                System.out.println("Please enter a name for the department name.");

                break;
            case 7:
                System.out.println("Please enter a name for the department name.");

                break;
            case 8:
                System.out.println("Please enter a name for the department name.");

                break;
            case 9:
                System.out.println("Please enter a name for the department name.");

                break;
            case 10:
                System.out.println("Please enter a name for the department name.");

                break;
            case 11:
                System.out.println("Please enter a name for the department name.");

                break;
            case 12:
                System.out.println("Please enter a name for the department name.");

                break;
            case 13:
                System.out.println("Please enter a name for the department name.");

                break;
            case 14:
                System.out.println("Please enter a name for the department name.");
                break;
            case 14:
                System.out.println("Please enter a name for the department name.");
                break;
            default:
                System.out.println("There is no action regarding the inputted number!  Please enter a number attributed to a valid integer.");

//        Department science = new Department("Sciente");
//        Course course1 = new Course(1.1,"Biology", science);
//        Course course2 = new Course(2.1,"Math", science);
//        course1.setDepartment(science);
//        school.addTeacher("teacher1","teacher2",Gender.MALE, science);
//        school.addTeacher("teacher11","teacher21",Gender.MALE, science);
//        school.addDepartment("Science");
//        school.addDepartment("CompsSci");
//
//
//        Teacher teacher1 = new Teacher("teacher1","teacher2", Gender.MALE, science);
//
//
//
//        Student student = new Student("fone","sone",Gender.MALE,science);
//        Student student1 = new Student("fone","sone",Gender.OTHERS,science);
//        Student student2 = new Student("fone","sone",Gender.FEMALE,science);
//
//        student1.addCourse(course1);
//        student1.addCourse(course2);
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(student1);
//        studentList.add(student2);
//
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(course1);
//        System.out.println(course2);
//        System.out.println(teacher1);
//        System.out.println(science);
    }
}

    private static void addDepartment(Scanner scanner, SchoolManagementSystem school) {
        System.out.println("Please enter a name for the department name.");
        String depName = scanner.nextLine();
        school.addDepartment(depName);
    }
}
