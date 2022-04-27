package com.example.springdatajpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookNatural {
    @Id
    private String title;
    private String author;
    private String isbn;

    public BookNatural() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
