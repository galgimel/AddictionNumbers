package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormatterTest {

    @Test
    void format() {

        Formatter formatter = new Formatter();
        int a = -5;
        int b = -5;
        int result = -10;
        String expected = "  -5\n" + "+ -5\n" + " -10\n";
        String actual = formatter.format(a, b, result);

        assertEquals(expected, actual);

        a = 1;
        b = 5;
        result = -4;
        expected = "  1\n" + "+ 5\n" + " -4\n";
        actual = formatter.format(a, b, result); // не записит от результата

        assertEquals(expected, actual);

        a = 8;
        b = 92;
        result = 100;
        expected = "   8\n" + "+ 92\n" + " 100\n";
        actual = formatter.format(a, b, result);

        assertEquals(expected, actual);
    }
}