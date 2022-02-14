package ru.netology.domain;

public class Book extends Product {
    private String author;
//    private String name;

    public Book() {
        super();
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
            if (super.matches(search)) {
                return true;
            }
            if (this.matches(getAuthor())) {
                return true;
            }

    }
//        if (super.matches(search)) return true;
//        if (search == null || !getClass().equals(search.getClass())) return false;
//        Book book = new Book(getId(), getName(), getPrice(), author);
//        return Objects.equals(author, book.author);
//    }
}
