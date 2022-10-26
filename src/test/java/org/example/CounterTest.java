package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @Test
    void count() {
        Counter counter = new Counter();
        String action = "+";
        int a = -1;
        int b = 1;
        int expected = 0;
        int actual = counter.count(a, b, action);

        assertEquals(expected, actual);

        action = "*";
        a = -1;
        b = 1;
        expected = -1;
        actual = counter.count(a, b, action);

        assertEquals(expected, actual);

        action = "*";
        a = 0;
        b = 1;
        expected = 0;
        actual = counter.count(a, b, action);

        assertEquals(expected, actual);

        action = "*";
        a = 7;
        b = 0;
        expected = 0;
        actual = counter.count(a, b, action);

        assertEquals(expected, actual);

        action = "-";
        a = -7;
        b = 3;
        expected = -10;
        actual = counter.count(a, b, action);

        assertEquals(expected, actual);

        action = "-";
        a = -10;
        b = -50;
        expected = 40;
        actual = counter.count(a, b, action);

        assertEquals(expected, actual);
    }
}