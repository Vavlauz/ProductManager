package ru.netology.domain;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {

    }

    public boolean matches(String search) {
        if (this.equals(search)) return true;
        if (search == null || !getClass().equals(search.getClass())) return false;
        Product product = new Product();
        return id == product.id && price == product.price && Objects.equals(name, product.name);
//        Product product = new Product();
//        if (product.getName().contains(search)) {
//            return true;
//        } else {
//            return false;
//        }


    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



}
