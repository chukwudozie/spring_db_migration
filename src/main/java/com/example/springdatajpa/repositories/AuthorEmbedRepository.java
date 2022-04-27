package com.example.springdatajpa.repositories;

import com.example.springdatajpa.domain.composite.AuthorEmbedded;
import com.example.springdatajpa.domain.composite.NamedId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorEmbedRepository extends JpaRepository<AuthorEmbedded, NamedId> {
}
