package com.example.springdatajpa.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class BookUuid {

    @Id
    @GeneratedValue(generator = "uuid2")
    // this tells hibernate to use 4122 compliant UUID
    @GenericGenerator(name = "uuid2",strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;
    private String title;
    private String isbn;
    private String author;
    private int numberOfPages;


    public BookUuid(String title, String isbn, String author, int numberOfPages) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public BookUuid() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

}
