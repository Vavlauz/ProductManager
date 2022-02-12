package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;

    }

//    public Product[] getAll() {
//        int resultLength = items.length;
//        if (resultLength > limit) {
//            resultLength = limit;
//        } else {
//            resultLength = items.length;
//        }
//
//        Film[] items = findAll();
//        Film[] result = new Film[resultLength];
//        for (int i = 0; i < result.length; i++) {
//            int index = result.length - i - 1;
//            result[i] = items[index];
//        }
//        return result;
//    }

    public Product[] findAll() {
        return items;
    }

//    public Film findById(int id) {
//        for (Film item : items) {
//            if (item.getId() == id) {
//                return item;
//            }
//        }
//        return null;
//    }

//    public Film[] removeAll() {
//        return new Film[0];
//    }

    public Product[] removeById(int id) {
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

//    public void addById(int id) {
//        int length = items.length + 1;
//        Film[] tmp = new Film[length];
//        int index = 0;
//        for (Film item : items) {
//            if (item.getId() == id) {
//                tmp[index] = item;
//                index++;
//            }
//        }
//        items = tmp;
//    }

}
