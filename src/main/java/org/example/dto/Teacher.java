package org.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Teacher {
    private int experience;
    private String lName;
    private String fName;
    private Department department;
    private String id;
    private Gender gender;
    private String fullName;

    private static int nextId = 1;

    /**
     * Constructor for Teacher class
     *
     * @param lName  first name of the teacher
     * @param fName  last name of the teacher
     * @param gender the gender of the teacher
     */
    public Teacher(String lName, String fName, int experience, Gender gender, Department department) {
        this.id = String.format("T%03d", nextId++);
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.experience = experience;
        this.department = department;
        this.fullName = fullName();
    }

    public String fullName() {
        return String.format("%s %s", fName, lName);
    }

    /**
     * toString method for the Teacher class
     *
     * @return the formatted string
     */
    @Override
    public String toString() {
        return String.format("Teacher{id= %s, first name= %s, last name= %s, experience= %d, gender= %s, department= %s}",
                id, fName, lName, experience, gender, department.getDepartmentName());
    }

}
