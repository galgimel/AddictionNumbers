package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @ParameterizedTest
    @MethodSource("expectedAnswer")
    void count(String action, int a, int b, int expected) {
        Counter counter = new Counter();

        int actual = counter.count(a, b, action);
        assertEquals(expected, actual);

    }

    private static Stream<Arguments> expectedAnswer() {
        return Stream.of(
                Arguments.of("+", 1, -1, 0),
                Arguments.of("*", 1, -1, -1),
                Arguments.of("*", 0, 1, 0),
                Arguments.of("*", 7, 0, 0),
                Arguments.of("-", -7, 3, -10),
                Arguments.of("-", -10, -50, 40)
        );
    }
}