package com.example.springdatajpa.domain.composite;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "author_composite")
public class AuthorEmbedded {

    @EmbeddedId
    private NamedId namedId;
    private String country;

    public AuthorEmbedded() {
    }

    public AuthorEmbedded(NamedId namedId) {
        this.namedId = namedId;
    }

    public NamedId getNamedId() {
        return namedId;
    }

    public void setNamedId(NamedId namedId) {
        this.namedId = namedId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
