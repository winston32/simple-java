package com.example.simplejava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic tests for App.add(...)
 */
class AppTest {

    @Test
    void testAddPositiveNumbers() {
        assertEquals(5, App.add(2, 3));
    }

    @Test
    void testAddWithZeroAndNegative() {
        assertEquals(0, App.add(-1, 1));
        assertEquals(-5, App.add(-2, -3));
    }
}