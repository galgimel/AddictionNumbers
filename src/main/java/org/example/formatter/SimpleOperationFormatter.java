package org.example.formatter;

import static org.example.Constants.*;
import static org.example.FormatterUtils.maxLineLength;
import static org.example.FormatterUtils.space;

public class SimpleOperationFormatter implements Formatter {
    public String formatByAction(int a, int b, int result, String action) {
        return format(a, b, result).replace("#", action);
    }

    public String format(int a, int b, int result) {
        int[] ints = new int[]{a, b, result};
        String[] full = new String[3];
        int maxLineLength = maxLineLength(a, b, result);

        for (int i = 0; i < ints.length; i++) {
            String number = ints[i] + EMPTY_SPACE;
            StringBuilder str = new StringBuilder(number);

            if (number.length() < maxLineLength) {
                int difference = maxLineLength - number.length();
                for (int j = 0; j < difference; j++) {
                    str.insert(0, SPACE_SPLIT);
                }
                full[i] = str.toString();
            } else if (number.length() == maxLineLength) {
                full[i] = str.toString();
            }
        }
        String space = space(maxLineLength, CHAR_MINUS);
        return SPACE_SPLIT + full[0] + "\n" + "#" + full[1] + "\n" + space + "\n" + SPACE_SPLIT + full[2] + "\n";
    }
}