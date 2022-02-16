package ru.netology.manager;

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
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
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

    public Product[] findAllProducts() {
        return repository.findAll();
    }

    public Product[] removeByIdProducts(int id) {
        return repository.removeById(id);
    }

}
