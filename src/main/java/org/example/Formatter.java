package org.example;

public class Formatter {
    public String format(int a, int b, int result) {
        MaxLineLength max = new MaxLineLength();

        int maxLineLength = max.maxLineLength(a, b, result);
        int[] ints = new int[]{a, b, result};
        String[] full = new String[3];

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

        return " " + full[0] + "\n" + "+" + full[1] + "\n" + " " + full[2] + "\n";
    }
}
