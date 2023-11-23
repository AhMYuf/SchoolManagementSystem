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

    private static int nextId = 1;

    public Teacher(String lName, String fName, Department department) {
        this.id = String.format("T%03d", nextId++);
        this.fName = fName;
        this.department = department;
        this.lName = lName;
    }

    @Override
    public String toString(){
        return String.format("id=%s, first name=%s, last name= %s, department=%s", id, fName ,lName ,department);
    }
}
