package org.example;

import org.example.dto.*;

public class Main {
    public static void main(String[] args) {
        SchoolManagementSystem school = new SchoolManagementSystem();

        school.addDepartment("Science");
        school.addTeacher("Teacher1","teacher",3,Gender.MALE,"D001");
        school.addCourse(1.2,"Biology", "D001");

        school.addStudent("Ahmet","Yusuf",Gender.MALE, "D001");
        school.addStudent("Ahmet1","Yusuf",Gender.MALE, "D001");
        school.addStudent("Ahmet2","Yusuf",Gender.MALE, "D001");
        school.registerCourse("S001","C001");
        school.registerCourse("S002","C001");
        school.registerCourse("S003","C001");
        ActiveEngin activeEngin = new ActiveEngin(school);
        activeEngin.Menu();
    }
}
