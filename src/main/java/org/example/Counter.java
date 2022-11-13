package org.example;

import static org.example.Constants.*;

public class Counter {
    public Integer count(int a, int b, String action) {
        int result;
        switch (action) {
            case PLUS:
                result = a + b;
                break;
            case MINUS:
                result = a - b;
                break;
            case MULTIPLY:
                if (a == 0 || b == 0) {
                    result = 0;
                } else {
                    result = a * b;
                }
                break;
            case DIVISION:
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