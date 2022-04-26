package com.example.springdatajpa;

import com.example.springdatajpa.domain.Book;
import com.example.springdatajpa.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//The @DataJpaTest will autoconfigure h2 in-memory database and entities for DB transactions
//This annotation doesn't allow the data initializer we use component scan to bring it in
@DataJpaTest
// The component scan picks up the Data Initializer class from the package
@ComponentScan(basePackages = {"com.example.springdatajpa.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootJPASliceTest {
    @Autowired
    private BookRepository bookRepository;

//    @Rollback(value = false)
    @Commit
    @Order(1)
    @Test
    public void testJpaSplice(){
        long countBefore = bookRepository.count();
        bookRepository.save(new Book("Test","1233","emeka",9,null));
        long countAfter = bookRepository.count();
        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    public void testJpaSpliceTransaction(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(4);

    }
}
