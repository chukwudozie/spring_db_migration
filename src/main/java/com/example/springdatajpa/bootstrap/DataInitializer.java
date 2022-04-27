package com.example.springdatajpa.bootstrap;

import com.example.springdatajpa.domain.AuthorUuid;
import com.example.springdatajpa.domain.Book;
import com.example.springdatajpa.domain.BookUuid;
import com.example.springdatajpa.repositories.AuthorUuidRepository;
import com.example.springdatajpa.repositories.BookRepository;
import com.example.springdatajpa.repositories.BookUuidRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile({"local", "default","dev"}) // This data initialization will only happen for local and default profiles
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorUuidRepository authorUuidRepository;
    private final BookUuidRepository bookUuidRepository;

    public DataInitializer(BookRepository bookRepository, AuthorUuidRepository authorUuidRepository,
                           BookUuidRepository bookUuidRepository) {
        this.bookRepository = bookRepository;
        this.authorUuidRepository = authorUuidRepository;
        this.bookUuidRepository = bookUuidRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        Book book1 = new Book("Introduction to SpringBoot","1234","SpringGuru",109,null);
        Book book2 = new Book("Rabbit MQ basics","4321","Thompson",505,null);
        Book book3 = new Book("Introduction to git","0987","Ifeanyi", 120,null);
        System.out.println("ID before Save: "+book1.getId());
        List<Book> books =  bookRepository.saveAll(List.of(book1,book2,book3));
//        books.forEach(book -> {
//            System.out.println("Book ID: "+book.getId());
//            System.out.println("Book title: "+book.getTitle());
//            System.out.println("Book Author: "+book.getAuthor());
//            System.out.println("Number of Pages: "+book.getNumberOfPages());
//            System.out.println("=========================================");
//        });
        bookRepository.findAll().forEach(savedBooks -> {
            System.out.println("Saved Book ID: "+savedBooks.getId());
            System.out.println("Saved Book title: "+savedBooks.getTitle());
            System.out.println("Saved Book Author: "+savedBooks.getAuthor());
            System.out.println("Saved Number of Pages: "+savedBooks.getNumberOfPages());
            System.out.println("=========================================");
        });

        AuthorUuid authorUuid = new AuthorUuid();
        authorUuid.setFirstName("Emeka");
        authorUuid.setLastName("Chukwudozie");
        AuthorUuid savedAuthorUuid = authorUuidRepository.save(authorUuid);
        System.out.println("Saved Author UUID : "+savedAuthorUuid.getId());

        BookUuid bookUuid = new BookUuid("New Book","123456","John Thompson",290);
        BookUuid savedBook = bookUuidRepository.save(bookUuid);
        System.out.println("Saved Book UUID : "+savedBook.getId());

    }
}
