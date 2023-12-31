package org.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Department class, its fields and methods.
 */
@Getter
@Setter
@EqualsAndHashCode
public class Department {
    private String id;
    private String departmentName;
    private static int nextId = 1;

    /**
     * Constructor for Department class.
     *
     * @param departmentName the name of the department name.
     */
    public Department(String departmentName) {
        this.id = String.format("D%03d", nextId++);
        this.departmentName = departmentName;

    }

    /**
     * toString method for the Department class.
     *
     * @return the formatted string.
     */
    @Override
    public String toString() {
        return String.format("Department{id= %s, department= %s}", id, departmentName);
    }
}
