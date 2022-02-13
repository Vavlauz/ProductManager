package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductManager manager = new ProductManager(new ProductRepository());

    @Test
    void shouldSaveOneItem() {
        Book coreJava = new Book();

        manager.saveProduct(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = manager.findAllProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllItems() {
        Book coreJava = new Book();
        Book WhiteFang = new Book();
        Smartphone OneX = new Smartphone();

        manager.saveProduct(coreJava);
        manager.saveProduct(WhiteFang);
        manager.saveProduct(OneX);

        Product[] expected = new Product[]{coreJava, WhiteFang, OneX};
        Product[] actual = manager.findAllProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByString() {
        Book coreJava = new Book(1, "core", 200, "first");
        Book WhiteFang = new Book(2, "fang", 300, "second");
        Smartphone OneX = new Smartphone(1, "one", 5000, "phone1");

        manager.saveProduct(coreJava);
        manager.saveProduct(WhiteFang);
        manager.saveProduct(OneX);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = manager.searchBy("core");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        Book coreJava = new Book(1, "core", 200, "first");
        Book WhiteFang = new Book(2, "fang", 300, "second");
        Smartphone OneX = new Smartphone(3, "one", 5000, "phone1");

        manager.saveProduct(coreJava);
        manager.saveProduct(WhiteFang);
        manager.saveProduct(OneX);

        Product[] expected = new Product[]{coreJava,OneX};
        Product[] actual = manager.removeByIdProducts(2);

        assertArrayEquals(expected, actual);
    }

}