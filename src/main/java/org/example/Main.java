package org.example;

import org.example.dto.ActiveEngin;
import org.example.dto.Gender;
import org.example.dto.SchoolManagementSystem;

public class Main {
    public static void main(String[] args) {
        // Initiate the SchoolManagementSystem and ActiveEngin class.
        SchoolManagementSystem school = new SchoolManagementSystem();
        ActiveEngin activeEngin = new ActiveEngin(school);

        // Adding a permanent department to SchoolManagementSystem.
        school.addDepartment("Science");

        // Adding a permanent teacher to SchoolManagementSystem.
        school.addTeacher("Wang", "Yi", 8, Gender.MALE, "D001");

        // Adding a course to SchoolManagementSystem.
        school.addCourse(1.5, "Computer Science", "D001");

        // Adding permanent students to SchoolManagementSystem.
        school.addStudent("Ahmet","Yusuf",Gender.MALE, "D001");
        school.addStudent("Emily", "Rodriguez", Gender.FEMALE, "D001");
        school.addStudent("Alex", "Johnson", Gender.OTHERS, "D001");

        // Adding the students to the created course.
        school.registerCourse("S001","C001");
        school.registerCourse("S002","C001");
        school.registerCourse("S003","C001");

        // Using the menu method from ActiveEngin class which creates an interactive user experience. The objects created in main will always be there when the menu method is activated.
        activeEngin.menu();
    }
}
