package org.example;

import org.example.formatter.SimpleOperationFormatter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FormatterTest {

    @ParameterizedTest
    @MethodSource ("expectedAnswer")
    void format(int a, int b, int result, String action, String expected) {
        SimpleOperationFormatter formatter = new SimpleOperationFormatter();

        String actual = formatter.formatByAction(a, b, result, action);
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