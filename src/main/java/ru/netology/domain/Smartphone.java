package ru.netology.domain;

public class Smartphone extends Product {
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
            if (super.matches(search)) {
                return true;
            }
            if (this.getProductName().contains(search)) {
                return true;
            }
        return false;
    }
}
