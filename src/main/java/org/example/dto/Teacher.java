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

    public Teacher(String lName, String fName, Department department, Gender gender) {
        this.id = String.format("T%03d", nextId++);
        this.fName = fName;
        this.department = department;
        this.lName = lName;
        this.gender = gender;

    }

    @Override
    public String toString() {
        return String.format("id= %s, first name= %s, last name= %s, gender= %s, department= %s", id, fName, lName,gender, department);
    }
}
