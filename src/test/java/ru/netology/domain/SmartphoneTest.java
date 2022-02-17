package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone first = new Smartphone(1, "core", 200, "anyBody");
    private Smartphone second = new Smartphone(2, "fang", 300, "anyBody2");

    @Test
    void matches() {

        assertTrue(first.matches("core"));
    }

    @Test
    void matches2() {

        assertFalse(second.matches("core"));
    }
}