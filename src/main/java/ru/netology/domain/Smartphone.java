package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    //    private String name;
    private String productName;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String productName) {
        super(id, name, price);
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) return true;
        if (search == null || !getClass().equals(search.getClass())) return false;
        Smartphone smartphone = new Smartphone(getId(), getName(), getPrice(), productName);
        return Objects.equals(productName, smartphone.productName);
    }
}
