package com.example.springdatajpa;

import com.example.springdatajpa.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @Test
    public void testMySQL(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);

    }
}
