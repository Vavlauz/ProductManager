package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductTest {
    private Product first = new Product(1, "core", 200);
    private Product second = new Product(2, "fang", 300);

    @Test
    void matches() {

        assertTrue(first.matches("core"));
    }

    @Test
    void matches2() {

        assertFalse(second.matches("core"));
    }

}