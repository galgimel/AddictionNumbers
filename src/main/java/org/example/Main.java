package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Counter count = new Counter();
        Formatter formatter = new Formatter();

        System.out.println("Введите первое число для суммирования.");
        String input = scanner.nextLine();

        while (!input.equals("exit")) {
            System.out.println("Введите второе число для суммирования. ");
            String input2 = scanner.nextLine();
            if (!input2.equals("exit")) {
                int a = Integer.parseInt(input);
                int b = Integer.parseInt(input2);
                int result = count.count(a, b);
                String answer = formatter.format(a, b, result);
                System.out.println("Ответ:");
                System.out.println(answer);
                System.out.println("Для окончания введите 'exit'.");
                System.out.println("Введите первое число для суммирования.");
                input = scanner.nextLine();
            } else {
                break;
            }
        }
        System.out.println("Пока!");
    }
}