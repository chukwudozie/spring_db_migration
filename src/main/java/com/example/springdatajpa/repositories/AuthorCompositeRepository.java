package com.example.springdatajpa.repositories;

import com.example.springdatajpa.domain.composite.AuthorComposite;
import com.example.springdatajpa.domain.composite.NamedId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NamedId> {
}
