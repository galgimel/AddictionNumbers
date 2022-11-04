package org.example;

import static org.example.FormatterUtils.maxLineLength;

public class Formatter {
    public String format(int a, int b, int result, String action) {
        int[] ints = new int[]{a, b, result};
        String[] full = new String[3];
        int maxLineLength = maxLineLength(a, b, result);

        for (int i = 0; i < ints.length; i++) {
            String number = ints[i] + "";
            StringBuilder str = new StringBuilder(number);

            if (number.length() < maxLineLength) {
                int difference = maxLineLength - number.length();
                for (int j = 0; j < difference; j++) {
                    str.insert(0, " ");
                }
                full[i] = str.toString();
            } else if (number.length() == maxLineLength) {
                full[i] = str.toString();
            }
        }
        String space = space(maxLineLength, '-');
        return " " + full[0] + "\n" + action + full[1] + "\n" + space + "\n" + " " + full[2] + "\n";
    }

    public String space(int length, char c) {
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < length + 1; i++) {
            space.append(c);
        }
        return space.toString();
    }
}
