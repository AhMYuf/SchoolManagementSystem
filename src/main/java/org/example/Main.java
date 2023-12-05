package org.example;

import org.example.dto.ActiveEngin;
import org.example.dto.Gender;
import org.example.dto.SchoolManagementSystem;

public class Main {
    public static void main(String[] args) {
        SchoolManagementSystem school = new SchoolManagementSystem();
        ActiveEngin activeEngin = new ActiveEngin();
        activeEngin.Menu();
    }
}
