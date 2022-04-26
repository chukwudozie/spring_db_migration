package com.example.springdatajpa.repositories;

import com.example.springdatajpa.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
