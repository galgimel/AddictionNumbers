package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxLineLengthTest {

    @Test
    void maxLineLength() {
        MaxLineLength max = new MaxLineLength();

        int expected = 2;
        int actual = max.maxLineLength(5, -5, 0);

        assertEquals(expected, actual);

        expected = 4;
        actual = max.maxLineLength(54, -565, 654);

        assertEquals(expected, actual);

        expected = 1;
        actual = max.maxLineLength(1, 1, 2);

        assertEquals(expected, actual);
    }
}