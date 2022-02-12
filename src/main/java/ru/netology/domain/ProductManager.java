package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager() {
    }

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void saveProduct(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

//    public Film[] getAllFilms() {
//        Film[] items = repository.findAll();
//        Film[] result = new Film[items.length];
//        for (int i = 0; i < result.length; i++) {
//            int index = items.length - i - 1;
//            result[i] = items[index];
//        }
//        return result;
//    }

//    public Film[] removeByIdFilms(int id) {
//        return repository.removeById(id);
//    }

    public Product[] findAllFilms() {
        return repository.findAll();
    }

//    public int removeAllFilms() {
//        repository.removeAll();
//        return 0;
//    }
//
//    public Film findByIdFilms(int id) {
//        return repository.findById(id);
//    }
//
//    public int sum() {
//        int result = 0;
//        for (Film item : repository.findAll()) {
//            result = result + item.getProductPrice() * item.getCount();
//        }
//        return result;
//    }
}
