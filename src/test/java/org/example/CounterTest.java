package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @Test
    void count() {
        Counter counter = new Counter();
        int a = -1;
        int b = 1;
        int expected = 0;
        int actual = counter.count(a, b);

        assertEquals(expected, actual);

        a = -3;
        b = -3;
        expected = -6;
        actual = counter.count(a, b);

        assertEquals(expected, actual);

        a = 500;
        b = 500;
        expected = 1000;
        actual = counter.count(a, b);

        assertEquals(expected, actual);
    }
}