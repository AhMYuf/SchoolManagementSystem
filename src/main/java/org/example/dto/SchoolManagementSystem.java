package org.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SchoolManagementSystem {
    private static final int MAX_DEPARTMENT_NUM = 5;
    private static final int MAX_STUDENT_NUM = 200;
    private static final int MAX_TEACHER_NUM = 20;
    private static final int MAX_REGISTRATION_COURSE = 5;
    private static final int MAX_COURSE_NUM = 30;

    private static int totalTeacher = 0;
    private static int totalStudent = 0;
    private static int totalCourse = 0;

    private Department[] departmentList;
    private Course[] courseList;
    private Teacher[] teacherList;
    private Student[] studentList;


    /**
     * Constructor of the SchoolManagementSystem class
     */
    public SchoolManagementSystem() {
        departmentList = new Department[MAX_DEPARTMENT_NUM];
        teacherList = new Teacher[MAX_TEACHER_NUM];
        studentList = new Student[MAX_STUDENT_NUM];
        courseList = new Course[MAX_COURSE_NUM];
    }

    /**
     * Method that finds a department
     *
     * @param departmentId the id of the department
     * @return all information regarding the department
     */
    public Department findDepartment(String departmentId) {
        for (Department department : departmentList) {
            if (department != null) {
                if (department.getId().equals(departmentId)) {
                    return department;
                }
            }
        }
        System.out.println("The department with the entered id does not exist.");
        return null;
        // TODO dont forget to null check
    }

    /**
     * Method that displays all the teachers
     */
    public void printTeachers() {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }
    public void printCourses() {
        for(Course course : courseList) {
            System.out.println(course);
        }
    }

    /**
     * Method that adds a course to a teacher
     *
     * @param teacherId the id of the teacher that gets a new course
     * @param courseId  id of the course that the teacher will be assigned to
     */
    public void modifyCourseTeacher(String teacherId, String courseId) {
        Teacher teacher = findTeacher(teacherId);
        Course course = findCourse(courseId);
        if (teacher == null || course == null) {
            if (teacher == null) {
                System.out.println("The researched teacher does not exist.");
            }
            if (course == null) {
                System.out.println("The researched course does not exist.");
            }
        } else {
            course.setTeacher(teacher);
        }
    }

    /**
     * Method that creates a new department
     *
     * @param departmentName name of the new department that will be created
     */
    public void addDepartment(String departmentName) {
        if (departmentList[MAX_DEPARTMENT_NUM - 1] != null) {
            System.out.printf("You have created %s\n", MAX_DEPARTMENT_NUM);
        } else {
            for (int i = 0; i < MAX_DEPARTMENT_NUM; i++) {
                if (departmentList[i] == null) {
                    departmentList[i] = new Department(departmentName);
                    break;
                }
            }
        }
    }

    /**
     * Method that print all the students exist in the school
     */
    public void printStudents() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    /**
     * Method that finds a student
     *
     * @param studentId the id of the student
     * @return the information of the that is researched
     */
    public Student findStudent(String studentId) {
        for (Student student : studentList) {
            if (student != null) {
                if (student.getId().equals(studentId)) {
                    return student;
                }
            }
        }
        System.out.println("The student with the entered id does not exist.");
        return null;
    }

    /**
     * Method that adds a course to the school
     *
     * @param courseName the name of the course that will be added to the school
     */
    public void addCourse(double credit, String courseName, String departmentId) {
        courseList[totalCourse++] = new Course(credit, courseName, findDepartment(departmentId));
        //TODO check if courses are full
    }

    public void registerCourse(String studentId, String courseId) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseId);
        if (student == null || course == null) {
            if (student == null) {
                System.out.println("The researched student does not exist.");
                //TODO return;
            }
            if (course == null) {
                System.out.println("The researched course does not exist.");
            }
        } else {
            student.addCourse(course);
            course.addStudent(student);
        }
    }

    public void unregisterCourse(String studentId, String courseId) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseId);
        if (student == null || course == null) {
            if (student == null) {
                System.out.println("The researched student does not exist.");
            }
            if (course == null) {
                System.out.println("The researched course does not exist.");
            }
        } else {
            student.removeCourse(course);
            course.removeStudent(student);
        }
    }


    public void addTeacher(String fName, String lName, byte experience, Gender gender, String departmentId) {
        String fNameUpper = toUpper(fName);
        String lNameUpper = toUpper(lName);
        System.out.println("Please input the gender in uppercase. The options are MALE, FEMALE or OTHERS.");
        teacherList[totalTeacher++] = new Teacher(fNameUpper, lNameUpper, experience, gender, findDepartment(departmentId));
    }


    /**
     * Method that finds a course
     *
     * @param courseId the name of the searched course
     */
    public Course findCourse(String courseId) {
        for (Course course : courseList) {
            if (course != null) {
                if (course.getId().equals(courseId)) {
                    return course;
                }
            }
        }
        System.out.println("The department with the entered id does not exist.");
        return null;
    }

    /**
     * Method that prints all the departments
     */
    public void printDepartments() {
        for (Department department : departmentList) {
            System.out.println(department);
        }
    }


    public void addStudent(String fName, String lName, Gender gender, String avgGrade, String departmentId) {
        String fNameUpper = toUpper(fName);
        String lNameUpper = toUpper(lName);
        studentList[totalStudent++] = new Student(fNameUpper, lNameUpper, gender, avgGrade, findDepartment(departmentId));
    }

    /**
     * Method that finds a teacher
     *
     * @param teacherId the identification assigned to a teacher
     * @return the asked teachers information
     */


    public Teacher findTeacher(String teacherId) {
        for (Teacher teacher : teacherList) {
            if (teacher != null) {
                if (teacher.getId().equals(teacherId)) {
                    return teacher;
                }
            }
        }
        System.out.println("The department with the entered id does not exist.");
        return null;
    }

    private String toUpper(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }

//    private double calculateGrade() {
//
//    }
}
