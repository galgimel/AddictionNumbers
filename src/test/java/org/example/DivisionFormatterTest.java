package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DivisionFormatterTest {

    @ParameterizedTest
    @MethodSource("expectedAnswer")
    void divisionFormat(int a, int b, int result, String expected) {
        DivisionFormatter divisionFormatter = new DivisionFormatter();

        String actual = divisionFormatter.DivisionFormat(a, b, result);
        assertEquals(expected, actual);
    }
    private static Stream<Arguments> expectedAnswer() {
        return Stream.of(
                Arguments.of(12, 2, 6,
                        "_12|2\n" +
                        " 12|-\n" +
                        " --|6\n" +
                        "  0\n"),
                Arguments.of(73569, 3, 24523,
                        "_73569|3\n" +
                        " 6    |-----\n" +
                        " -    |24523\n" +
                        "_13\n" +
                        " 12\n" +
                        " --\n" +
                        " _15\n" +
                        "  15\n" +
                        "  --\n" +
                        "   _6\n" +
                        "    6\n" +
                        "    -\n" +
                        "    _9\n" +
                        "     9\n" +
                        "     -\n" +
                        "     0\n"),
                Arguments.of(607, 9, 67,
                        "_607|9\n" +
                        " 54 |--\n" +
                        " -- |67\n" +
                        " _67\n" +
                        "  63\n" +
                        "  --\n" +
                        "   4\n")
        );
    }
}