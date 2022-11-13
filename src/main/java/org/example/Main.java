package org.example;

import org.example.formatter.DivisionFormatter;
import org.example.formatter.Formatter;
import org.example.formatter.SimpleOperationFormatter;

import java.util.Scanner;

import static org.example.Constants.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Counter count = new Counter();
        SimpleOperationFormatter formatter = new SimpleOperationFormatter();
        DivisionCalculator divisionCalculator = new DivisionCalculator();
        Formatter divisionFormatter = new DivisionFormatter(divisionCalculator);

        System.out.println("Введите действие: '" +
            PLUS + "', '" + MINUS + "' или '" + MULTIPLY + "', '" + DIVISION +
            "'.");
        String action = scanner.nextLine();

        while (!action.equals(EXIT_WORD)) {
            System.out.println("Введите первое число.");
            String input = scanner.nextLine();

            if (!input.equals(EXIT_WORD)) {
                System.out.println("Введите второе число.");
                String input2 = scanner.nextLine();

                if (!input2.equals(EXIT_WORD)) {
                    int a = Integer.parseInt(input);
                    int b = Integer.parseInt(input2);
                    int result = count.count(a, b, action);
                    String answer = "";
                    if (action.equals(DIVISION) && b != 0) {
                        answer = divisionFormatter.format(a, b, result);
                    } else if (action.equals(DIVISION)) {
                        System.out.println("На ноль делить нельзя!");
                    } else {
                        answer = formatter.formatByAction(a, b, result, action);
                    }
                    System.out.println("Ответ:");
                    System.out.println(answer);
                    System.out.println("Для окончания введите '" + EXIT_WORD +
                        "'.\nВведите действие: '" +
                        PLUS + "', '" + MINUS + "' или '" + MULTIPLY + "', '" + DIVISION +
                        "'.");
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