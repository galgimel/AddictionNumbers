package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FormatterTest {


    void format(int a, int b, int result, String action, String expected) {
        Formatter formatter = new Formatter();

        String actual = formatter.format(a, b, result, action);
        assertEquals(expected, actual);
    }
    private static Stream<Arguments> expectedAnswer() {
        return Stream.of(
                Arguments.of(-5, -5, -10, "+", "  -5\n" + "+ -5\n" + "----\n" + " -10\n"),
                Arguments.of(5, -5, 10, "-", "  5\n" + "--5\n" + "---\n" + " 10\n"),
                Arguments.of(55, 55, 3025, "*", "   55\n" + "*  55\n" +  "-----\n" + " 3025\n")
        );
    }
}