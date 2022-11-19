package org.example;

import java.util.Scanner;

public class Task1 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Group group = Group.createGroup();
        group.print(); // выводим всех студентов
        process();
    }

    // вывод подсказок в консоль
    private static void showHints() {
        System.out.println("Вы можете ввести команду \"/r\", чтобы поставить рандомному студенту рандомную оценку, " +
                "команду \"/l\", чтобы показать список студентов с оценками, \"/e\", чтобы выйти, \"/h\", " +
                "чтобы показать подсказку");
    }

    // запускаем решение задачи
    private static void process() {
        String command;
        while (!(command = scanner.nextLine()).replaceAll(" ", "").equals("/e")) {
            switch (command) {
                case "/r":
                    Group.gradeRandomStudent();
                    break;
                case "/l":
                    Group.showGradedStudents();
                    break;
                case "/h":
                    showHints();
                    break;
                default:
                    System.out.println("Такой команды не существует");
            }
        }
    }
}