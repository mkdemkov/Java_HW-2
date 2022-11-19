package org.example;

import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Integer> grades;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        grades = new ArrayList<>();
    }

    // вывести студента в консоль
    public void print() {
        System.out.print(firstName + " ");
        System.out.println(lastName);
    }

    // добавить оценку студенту
    public void addGrade(Integer grade) {
        grades.add(grade);
    }

    // вывести, если есть оценка
    public void printIfGraded() {
        if (!grades.isEmpty()) {
            System.out.printf("Студент %s %s имеет следующие оценки: %s\n", firstName, lastName, grades);
        }
    }
}
