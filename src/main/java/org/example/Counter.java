package org.example;

public class Counter {
    public Integer count(int a, int b, String action) {
        int result;
        switch (action) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                if (a == 0 || b == 0) {
                    result = 0;
                } else {
                    result = a * b;
                }
                break;
            case "/":
                if (a == 0 || b == 0 || a < b) {
                    result = 0;
                } else {
                    result = a / b;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
        return result;
    }
}
