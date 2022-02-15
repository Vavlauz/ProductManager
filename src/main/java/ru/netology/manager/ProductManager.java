package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void saveProduct(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                return new Product[]{product};// "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

//        public boolean matches(Product product,String search) {
//            if (product.matches(search)) {
//            return true;
//        } else {
//            return false;
//        }
//        // или в одну строку:
//        // return product.getName().contains(search);
//    }

    public boolean matches(Product product, String search) {
        if (Book.matches(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

    public Product[] findAllProducts() {
        return repository.findAll();
    }

    public Product[] removeByIdProducts(int id) {
        return repository.removeById(id);
    }

}
