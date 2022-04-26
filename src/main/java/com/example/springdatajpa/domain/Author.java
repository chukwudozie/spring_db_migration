package com.example.springdatajpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Long booksReferenced; // for entity relationship with books table with flyway

    public Author() {
    }

    public Author( String firstName, String lastName, int age ,Long booksReferenced) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.booksReferenced = booksReferenced;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getBooksReferenced() {
        return booksReferenced;
    }

    public void setBooksReferenced(Long booksReferenced) {
        this.booksReferenced = booksReferenced;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return getId().equals(author.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
