package org.example;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Group {
    private static ArrayList<Student> students;

    public Group(ArrayList<Student> students) {
        Group.students = students;
    }

    public void print() {
        students.forEach(Student::print);
    }


    public static void gradeRandomStudent() {
        Student st = students.get(ThreadLocalRandom.current().nextInt(0, students.size()));
        Integer grade = ThreadLocalRandom.current().nextInt(0, 11);
        st.addGrade(grade);
    }

    public static void showGradedStudents() {
        students.forEach(Student::printIfGraded);
    }

    public static Group createGroup() {
        ArrayList<Student> students = new ArrayList<Student>();
        int ch;
        String path = "/Users/filledevoler/Desktop/Coding/Java/Homework2/src/main/java/org/example/students.txt";
        StringBuilder firstName = new StringBuilder();
        StringBuilder lastName = new StringBuilder();
        boolean flag = false;
        try (FileReader fr = new FileReader(path)) {
            while ((ch = fr.read()) != -1) {
                if ((char) ch == '\n') {
                    Student student = new Student(firstName.toString(), lastName.toString());
                    students.add(student);
                    firstName = new StringBuilder();
                    lastName = new StringBuilder();
                    flag = false;
                } else if ((char) ch == ' ') {
                    flag = true;
                } else {
                    if (!flag) {
                        firstName.append((char) ch);
                    } else {
                        lastName.append((char) ch);
                    }
                }
            }
            // иначе не запишется студент, который стоит последним
            Student student = new Student(firstName.toString(), lastName.toString());
            students.add(student);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new Group(students);
    }
}
