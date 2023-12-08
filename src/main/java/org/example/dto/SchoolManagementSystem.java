package org.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * SchoolManagementSystem class, its fields and methods.
 */
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

    private Department[] departmentList;
    private Course[] courseList;
    private Teacher[] teacherList;
    private Student[] studentList;

    /**
     * Constructor of SchoolManagementSystem class.
     */
    public SchoolManagementSystem() {
        departmentList = new Department[MAX_DEPARTMENT_NUM];
        teacherList = new Teacher[MAX_TEACHER_NUM];
        studentList = new Student[MAX_STUDENT_NUM];
        courseList = new Course[MAX_COURSE_NUM];
    }

    /**
     * Method that adds a department to SchoolManagementSystem.
     * @param departmentName name of the department that is being added to SchoolManagementSystem.
     */
    public void addDepartment(String departmentName) {
        String departmentNameUpper = toUpper(departmentName);
        if (departmentList[MAX_DEPARTMENT_NUM - 1] != null) {
            System.out.printf("You have created %s. Max number of departments reached, add a new department failed.\n", MAX_DEPARTMENT_NUM);
        } else {
            for (int i = 0; i < MAX_DEPARTMENT_NUM; i++) {
                if (departmentList[i] == null) {
                    departmentList[i] = new Department(departmentNameUpper);
                    System.out.println("You have successfully created a new department.");
                    break;
                }
            }
        }
    }

    /**
     * Method that adds a course to SchoolManagementSystem.
     * @param credit the credit of the course.
     * @param courseName the name of the course.
     * @param departmentId the id of the department.
     */
    public void addCourse(double credit, String courseName, String departmentId) {
        String courseNameUpper = toUpper(courseName);
        if (courseList[MAX_COURSE_NUM - 1] != null) {
            System.out.printf("You have created %s. Max number of courses reached, add a new course failed.\n", MAX_COURSE_NUM);
        } else {
            for (int i = 0; i < MAX_COURSE_NUM; i++) {
                if (courseList[i] == null) {
                    courseList[i] = new Course(credit, courseNameUpper, findDepartment(departmentId));
                    System.out.println("You have successfully created a new course.");
                    break;
                }
            }
        }
    }

    /**
     * Method that adds a teacher to SchoolManagementSystem.
     *
     * @param fName        the first name of the teacher.
     * @param lName        the last name of the student.
     * @param experience   the experience of the teacher.
     * @param gender       the gender of the teacher.
     * @param departmentId the id of the teacher.
     */
    public void addTeacher(String fName, String lName, int experience, Gender gender, String departmentId) {
        String fNameUpper = toUpper(fName);
        String lNameUpper = toUpper(lName);
        if (teacherList[MAX_TEACHER_NUM - 1] != null) {
            System.out.printf("You have created %s. Max number of teachers reached, add a new teacher failed.\n", MAX_TEACHER_NUM);
        } else {
            for (int i = 0; i < MAX_TEACHER_NUM; i++) {
                if (teacherList[i] == null) {
                    teacherList[i] = new Teacher(fNameUpper, lNameUpper, experience, gender, findDepartment(departmentId));
                    System.out.println("You have successfully created a new teacher.");
                    break;
                }
            }
        }
    }

    /**
     * Method that adds a student to SchoolManagementSystem.
     *
     * @param fName        the first name of the student.
     * @param lName        the last name of the student.
     * @param gender       the gender of the student.
     * @param departmentId the id of the student.
     */
    public void addStudent(String fName, String lName, Gender gender, String departmentId) {
        String fNameUpper = toUpper(fName);
        String lNameUpper = toUpper(lName);
        if (studentList[MAX_STUDENT_NUM - 1] != null) {
            System.out.printf("You have created %s students. Max number of students reached, add a new student failed.\n", MAX_STUDENT_NUM);
        } else {
            for (int i = 0; i < MAX_STUDENT_NUM; i++) {
                if (studentList[i] == null) {
                    studentList[i] = new Student(fNameUpper, lNameUpper, gender, findDepartment(departmentId));
                    System.out.println("You have successfully created a new student.");
                    break;
                }
            }
        }
    }

    /**
     * Method that finds a department from SchoolManagementSystem.
     * @param departmentId the id of the department.
     * @return (String) the department or null.
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
    }

    /**
     * Method that finds a course from SchoolManagementSystem.
     * @param courseId the id of the course.
     * @return (String) the course or null.
     */
    public Course findCourse(String courseId) {
        for (Course course : courseList) {
            if (course != null) {
                if (course.getId().equals(courseId)) {
                    return course;
                }
            }
        }
        System.out.println("The course with the entered id does not exist.");
        return null;
    }

    /**
     * Method that finds a teacher from SchoolManagementSystem.
     * @param teacherId the id of the teacher.
     * @return (String) the teacher or null.
     */
    public Teacher findTeacher(String teacherId) {
        for (Teacher teacher : teacherList) {
            if (teacher != null) {
                if (teacher.getId().equals(teacherId)) {
                    return teacher;
                }
            }
        }
        System.out.println("The teacher with the entered id does not exist.");
        return null;
    }

    /**
     * Method that finds a student from SchoolManagementSystem.
     * @param studentId the id of the student.
     * @return (String) the student or null.
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
     * Method that registers a student to a course.
     * @param studentId the id of the student.
     * @param courseId the id of the course.
     */
    public void registerCourse(String studentId, String courseId) {
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
            student.addCourse(course);
            course.addStudent(student);
        }
    }

    /**
     * Method that unregisters a student to a course.
     *
     * @param studentId the id of the student.
     * @param courseId  the id of the course.
     */
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

    /**
     * Method that changes the teacher of a course.
     *
     * @param teacherId the id of the teacher.
     * @param courseId  the id of the course.
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
     * Method that prints all the departments from SchoolManagementSystem.
     */
    public void printDepartments() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Department department : departmentList) {
            if (department != null)
                stringBuilder.append(String.format("{%s-%s}", department.getId(), department.getDepartmentName()));
        }
        System.out.println(stringBuilder);
    }

    /**
     * Method that prints all the courses from SchoolManagementSystem.
     */
    public void printCourses() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Course course : courseList) {
            if (course != null) stringBuilder.append(String.format("{%s-%s}", course.getId(), course.getCourseName()));
        }
        System.out.println(stringBuilder);
    }

    /**
     * Method that prints all the teachers from SchoolManagementSystem.
     */
    public void printTeachers() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Teacher teacher : teacherList) {
            if (teacher != null) stringBuilder.append(String.format("{%s-%s}", teacher.getId(), teacher.getFullName()));
        }
        System.out.println(stringBuilder);
    }

    /**
     * Method that prints all the students from SchoolManagementSystem.
     */
    public void printStudents() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student : studentList) {
            if (student != null) {
                stringBuilder.append(String.format("{%s-%s}", student.getId(), student.getFullName()));
            }
        }
        System.out.println(stringBuilder);
    }

    /**
     * Method that finds the number of registered students to SchoolManagementSystem.
     *
     * @return the number of students.
     */
    public int getRegisteredStudentNumber() {
        int totalStudent = 0;
        for (Student student : studentList) {
            if (student == null) {
                break;
            }
            totalStudent++;
        }
        return totalStudent;
    }

    /**
     * Method that finds the number of registered teachers to SchoolManagementSystem.
     * @return the number of teachers.
     */
    public int getRegisteredTeacherNumber() {
        int totalTeacher = 0;
        for (Teacher teacher : teacherList) {
            if (teacher == null) {
                break;
            }
            totalTeacher++;
        }
        return totalTeacher;
    }

    /**
     * Method that finds the number of registered courses to SchoolManagementSystem.
     *
     * @return the number of courses.
     */
    public int getRegisteredCourseNumber() {
        int totalCourse = 0;
        for (Course course : courseList) {
            if (course == null) {
                break;
            }
            totalCourse++;
        }
        return totalCourse;
    }

    /**
     * Method that finds the number of registered departments to SchoolManagementSystem.
     *
     * @return the number of departments.
     */
    public int getRegisteredDepartmentNumber() {
        int totalDepartment = 0;
        for (Department department : departmentList) {
            if (department == null) {
                break;
            }
            totalDepartment++;
        }
        return totalDepartment;
    }

    /**
     * Method that takes a string and makes the first letter uppercase with the rest being lowercase.
     *
     * @param string the inputted string.
     * @return the string.
     */
    private String toUpper(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }
}
