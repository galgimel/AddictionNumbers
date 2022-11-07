package org.example;

public class FormatterUtils {
    public static int maxLineLength(int a, int b, int result) {
        int[] ints = new int[]{a, b, result};
        int maxLineLength = 0;

        for (int i : ints) {
            String number = i + "";
            if (number.length() > maxLineLength) {
                maxLineLength = number.length();
            }
        }
        return maxLineLength;
    }
}