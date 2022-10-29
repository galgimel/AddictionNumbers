package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    @ParameterizedTest
    @MethodSource("expectedAnswer")
    void makeDivision(int a, int b, String expected) {
        Division division = new Division();

        String actual = division.makeDivision(a, b);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> expectedAnswer() {
        return Stream.of(
                Arguments.of(14789, 20,
                        "_14789│20\n" +
                                " 140  │---\n" +
                                " ---  │739\n" +
                                "  _78\n" +
                                "   60\n" +
                                "   --\n" +
                                "  _189\n" +
                                "   180\n" +
                                "   ---\n" +
                                "     9\n"),
                Arguments.of(15, 4,
                        "_15│4\n" +
                                " 12│-\n" +
                                " --│3\n" +
                                "  3\n"),
                Arguments.of(73659, 3,
                                "_73659│3\n" +
                                " 6    │-----\n" +
                                " -    │24553\n" +
                                "_13\n" +
                                " 12\n" +
                                " --\n" +
                                " _16\n" +
                                "  15\n" +
                                "  --\n" +
                                "  _15\n" +
                                "   15\n" +
                                "   --\n" +
                                "    _9\n" +
                                "     9\n" +
                                "     -\n" +
                                "     0\n")
        );
    }
}