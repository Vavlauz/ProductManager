package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();
    private Book coreJava = new Book(1, "core", 200, "first");
    private Book whiteFang = new Book(2, "fang", 300, "first");
    private Book blackFang = new Book(3, "fang", 550, "three");
    private Smartphone oneX = new Smartphone(4, "one", 5000, "phone1");
    private Smartphone oneXX = new Smartphone(4, "oneXX", 6000, "phone2");


    @Test
    void removeByIdAll() throws NotFoundException {
        repo.save(coreJava);
        repo.save(whiteFang);
        repo.save(blackFang);
        repo.save(oneX);

        repo.removeById(1);
        repo.removeById(2);
        repo.removeById(3);
        repo.removeById(4);

        Product[] actual = repo.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdNotFound() throws NotFoundException {
        repo.save(coreJava);
        repo.save(whiteFang);
        repo.save(blackFang);
        repo.save(oneX);

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(111));

        Product[] actual = repo.findAll();
        Product[] expected = {coreJava, whiteFang, blackFang, oneX};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdOneProd() {
        repo.save(coreJava);
        repo.save(whiteFang);
        repo.save(blackFang);
        repo.save(oneX);

        repo.removeById(2);

        Product[] actual = repo.findAll();
        Product[] expected = {coreJava, blackFang, oneX};

        assertArrayEquals(expected, actual);
    }

    @Test
    void save() {
        repo.save(coreJava);
        repo.save(whiteFang);
        repo.save(blackFang);
        repo.save(oneX);

        Product[] actual = repo.findAll();
        Product[] expected = {coreJava, whiteFang, blackFang, oneX};

        assertArrayEquals(expected, actual);
    }

    @Test
    void saveAlreadyExistsException() {
        repo.save(coreJava);
        repo.save(whiteFang);
        repo.save(blackFang);
        repo.save(oneX);

        Assertions.assertThrows(AlreadyExistsException.class, () -> repo.save(oneXX));

        Product[] actual = repo.findAll();
        Product[] expected = {coreJava, whiteFang, blackFang, oneX};

        assertArrayEquals(expected, actual);
    }

}