package org.example;


import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Counter count = new Counter();
            Formatter formatter = new Formatter();

            System.out.println("Введите 2 числа через пробел для суммирования. Для окончания введите 'exit'.");
            String input = scanner.nextLine();

            while(!input.equals("exit")) {
                String[] stringNumbers =  input.split(" ");
                if (stringNumbers.length == 2) {
                    int a = Integer.parseInt(stringNumbers[0]);
                    int b = Integer.parseInt(stringNumbers[1]);
                    int result = count.count(a , b);
                    String answer = formatter.format(a, b, result);
                    System.out.println(answer);
                    input = scanner.nextLine();
                } else {
                    System.out.println("Ошибка! Введено больше двух чисел!");
                    break;
                }
            }
        }
}