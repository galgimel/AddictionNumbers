package org.example;

public class FormatterUtils {

    public static String space(int length, char c) {
        StringBuilder space = new StringBuilder();
        space.append(String.valueOf(c).repeat(Math.max(0, length +1)));
        return space.toString();
    }

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