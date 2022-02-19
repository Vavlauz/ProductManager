package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        for (Product product : findAll()) {
            if (product.getId() == item.getId()) {
                throw new AlreadyExistsException("Element with id: " + item.getId() + " already exists");
            }

            }
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
        }
//        int result = items.length + 1;
//        Product[] tmp = new Product[result];
//        for (int i = 0; i < items.length; i++) {
//            tmp[i] = items[i];
//        }
//        tmp[tmp.length - 1] = item;
//        items = tmp;

//    }
//        int length = items.length + 1;
//        Product[] tmp = new Product[length];
//        System.arraycopy(items, 0, tmp, 0, items.length);
//                int lastIndex = tmp.length - 1;
//                tmp[lastIndex] = item;
//                items = tmp;

    public Product[] findAll() {
        return items;
    }

    public Product[] removeById(int id) throws NotFoundException {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return tmp;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

}
