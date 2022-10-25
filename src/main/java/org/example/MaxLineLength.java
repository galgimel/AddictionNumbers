package org.example;

public class MaxLineLength {
    public int maxLineLength(int a, int b, int result) {
        int[] ints = new int[]{a, b, result};
        int maxLineLength = 0;

        for (int i = 0; i < ints.length; i++) {
            String number = ints[i] + "";
            if (number.length() > maxLineLength) {
                maxLineLength = number.length();
            }
        }
        return maxLineLength;
    }
}
