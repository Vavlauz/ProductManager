package ru.netology.domain;

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
}
