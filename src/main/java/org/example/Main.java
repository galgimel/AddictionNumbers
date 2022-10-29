package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Counter count = new Counter();
        Formatter formatter = new Formatter();
        Division division = new Division();

        System.out.println("Введите действие: '+', '-' или '*', '/'.");
        String action = scanner.nextLine();

        while (!action.equals("exit")) {
            System.out.println("Введите первое число.");
            String input = scanner.nextLine();

            if (!input.equals("exit")) {
                System.out.println("Введите второе число.");
                String input2 = scanner.nextLine();

                if (!input2.equals("exit")) {
                    int a = Integer.parseInt(input);
                    int b = Integer.parseInt(input2);
                    int result = count.count(a, b, action);
                    String answer = "";

                    if (action.equals("/") && b != 0) {
                        answer = division.makeDivision(a, b);
                        division.cleanCache();
                    } else if (action.equals("/")) {
                        System.out.println("На ноль делить нельзя!");
                    } else {
                        answer = formatter.format(a, b, result, action);
                    }
                    System.out.println("Ответ:");
                    System.out.println(answer);
                    System.out.println("Для окончания введите 'exit'.\nВведите действие: '+', '-' или '*'.");
                    action = scanner.nextLine();
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println("Пока!");
    }
}