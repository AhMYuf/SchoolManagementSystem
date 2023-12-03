package org.example;

import org.example.dto.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SchoolManagementSystem sch = new SchoolManagementSystem();
        Department science = sch.findDepartment("D001");

        sch.addTeacher("teacher1","teacher2",Gender.MALE, science);
        sch.addTeacher("teacher11","teacher21",Gender.MALE, science);
        sch.addDepartment("Science");
        sch.addDepartment("CompsSci");


        Teacher teacher1 = new Teacher("teacher1","teacher2", Gender.MALE, science);

        Course course1 = new Course(1.1,"Biology");
        Course course2 = new Course(2.1,"Math");
        course1.setDepartment(science);
        course1.setTeacher(teacher1);

        Student student = new Student("fone","sone",Gender.MALE,science);
        Student student1 = new Student("fone","sone",Gender.OTHERS,science);
        Student student2 = new Student("fone","sone",Gender.FEMALE,science);

        student1.addCourse(course1);
        student1.addCourse(course2);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(course1);
        System.out.println(course2);
        System.out.println(teacher1);
        System.out.println(science);
    }
}
// TODO if lets say the id does not exist, then we ask the
// TODO can i turn all the methods private, create a method for them to constantly ask the user to prompt the correct input until they get it right?
// TODO ask the user the input inside the action method, meaning the question will be asked within the action

/*
while(true)
input = num.int
switch (num)
case 1 -> adddepAction()
 */