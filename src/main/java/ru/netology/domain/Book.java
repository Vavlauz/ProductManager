package ru.netology.domain;

public class Book extends Product {
    private String author;

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
        if (this.getAuthor().contains(search)) {
            return true;
        }

        return false;
    }
//        if (super.matches(search)) return true;
//        if (search == null || !getClass().equals(search.getClass())) return false;
//        Book book = new Book(getId(), getName(), getPrice(), author);
//        return Objects.equals(author, book.author);
//    }
}
