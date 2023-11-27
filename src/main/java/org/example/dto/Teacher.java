package org.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Teacher {
    private String lName;
    private String fName;
    private Department department;
    private String id;
    private Gender gender;

    private static int nextId = 1;

    /**
     * Constructor for Teacher class
     *
     * @param lName      first name of the teacher
     * @param fName      last name of the teacher
     * @param department the department of the teacher
     * @param gender     the gender of the teacher
     */
    public Teacher(String lName, String fName, Department department, Gender gender) {
        this.id = String.format("T%03d", nextId++);
        this.fName = fName;
        this.department = department;
        this.lName = lName;
        this.gender = gender;

    }

    /**
     * toString method for the Teacher class
     *
     * @return the formatted string
     */
    @Override
    public String toString() {
        return String.format("Teacher{id= %s, first name= %s, last name= %s, gender= %s, department= %s}", id, fName, lName, gender, department);
    }
}
