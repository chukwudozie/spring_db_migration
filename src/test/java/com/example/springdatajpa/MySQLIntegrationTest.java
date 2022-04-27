package com.example.springdatajpa;

import com.example.springdatajpa.domain.AuthorUuid;
import com.example.springdatajpa.domain.BookNatural;
import com.example.springdatajpa.domain.BookUuid;
import com.example.springdatajpa.domain.composite.AuthorComposite;
import com.example.springdatajpa.domain.composite.AuthorEmbedded;
import com.example.springdatajpa.domain.composite.NamedId;
import com.example.springdatajpa.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("local")// Enables the local profile for this specific test
@DataJpaTest
@ComponentScan(basePackages = {"com.example.springdatajpa.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
/*
  By default, @DataJpaTest annotation uses the H2 database,
  The other annotations used in this class ensures that the
  Database that will be used is MySql configured in the local profile
 */
public class MySQLIntegrationTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
     private BookUuidRepository bookUuidRepository;
    @Autowired
    private AuthorUuidRepository authorUuidRepository;
    @Autowired
    private BooKNaturalRepository booKNaturalRepository;
    @Autowired
    private AuthorCompositeRepository authorCompositeRepository;

    @Autowired
    private AuthorEmbedRepository authorEmbedRepository;

    @Test
    public void testMySQL(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }

    @Test
    public void testSaveAuthorUuid(){
        long initialAuthorsCount = authorUuidRepository.count();
        authorUuidRepository.save(new AuthorUuid("test first Name","test last Name"));
        long finalAuthorCount = authorUuidRepository.count();
        assertThat(finalAuthorCount).isGreaterThan(initialAuthorsCount);
    }

    @Test
    public void  testGetIdForAuthorUuid(){
        AuthorUuid newAuthor =  new AuthorUuid("test Name", "get ID");
        AuthorUuid savedAuthor = authorUuidRepository.save(newAuthor);
        AuthorUuid authorById = authorUuidRepository.getById(savedAuthor.getId());
        assertThat(savedAuthor.getId()).isNotNull();
        assertEquals(authorById,savedAuthor);
    }

    @Test
    public void testSaveBookUuid(){
        long initialBooksCount = bookUuidRepository.count();
        bookUuidRepository.save(new BookUuid());
        long finalBooksCount = authorUuidRepository.count();
        assertThat(finalBooksCount).isGreaterThan(initialBooksCount);
    }

    @Test
    public void  testGetIdForBookUuid(){
        BookUuid newBook =  new BookUuid();
        BookUuid savedBook = bookUuidRepository.save(newBook);
        BookUuid bookById = bookUuidRepository.getById(savedBook.getId());
        assertThat(savedBook.getId()).isNotNull();
        assertEquals(bookById,savedBook);
    }

    @Test
    public void bookNaturalTest(){
        BookNatural naturalBook = new BookNatural();
        naturalBook.setTitle("Test title");
        booKNaturalRepository.save(naturalBook);
        BookNatural fetched = booKNaturalRepository.getById(naturalBook.getTitle());
        assertThat(fetched).isNotNull();
    }

    @Test
    public void testAuthorCompositeKey(){
        NamedId namedId = new NamedId("Donald", "Trump");
        AuthorComposite authorComposite = new AuthorComposite();
        authorComposite.setFirstName(namedId.getFirstName());
        authorComposite.setLastName(namedId.getLastName());
        authorComposite.setCountry("Nigeria");
        AuthorComposite saved = authorCompositeRepository.save(authorComposite);
        assertThat(saved).isNotNull();
        AuthorComposite fetched = authorCompositeRepository.getById(namedId);
        assertThat(fetched).isNotNull();
    }

    @Test
    public void authorEmbedTest(){
        NamedId namedId = new NamedId("Donald", "Trump");
        AuthorEmbedded authorEmbedded = new AuthorEmbedded(namedId);
        AuthorEmbedded saved = authorEmbedRepository.save(authorEmbedded);
        AuthorEmbedded fetch = authorEmbedRepository.getById(namedId);
        assertThat(saved).isNotNull();
        assertThat(fetch).isNotNull();
    }
}
