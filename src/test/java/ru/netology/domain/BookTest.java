package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book first = new Book(1, "core", 200, "anyBody");
    private Book second = new Book(2, "fang", 300, "anyBody2");

    @Test
    void matches() {

        assertTrue(first.matches("core"));
    }

    @Test
    void matches2() {

        assertFalse(second.matches("core"));
    }

    @Test
    void matches3() {

        assertFalse(second.matches("anyBodyHere"));
    }

    @Test
    void matches4() {

        assertTrue(first.matches("anyBody"));
    }
}