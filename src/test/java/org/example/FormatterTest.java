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
        String action = "+";
        String expected = "  -5\n" + "+ -5\n" + " -10\n";
        String actual = formatter.format(a, b, result, action);

        assertEquals(expected, actual);

        a = 5;
        b = -5;
        result = 10;
        action = "-";
        expected = "  5\n" + "--5\n" + " 10\n";
        actual = formatter.format(a, b, result, action);

        assertEquals(expected, actual);

        a = 55;
        b = 55;
        result = 3025;
        action = "*";
        expected = "   55\n" + "*  55\n" + " 3025\n";
        actual = formatter.format(a, b, result, action);

        assertEquals(expected, actual);
    }
}