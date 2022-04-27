package com.example.springdatajpa.domain.composite;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class NamedId implements Serializable {
    private String firstName;
    private String lastName;

    public NamedId() {
    }

    public NamedId(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NamedId)) return false;

        NamedId namedId = (NamedId) o;

        if (getFirstName() != null ? !getFirstName().equals(namedId.getFirstName()) : namedId.getFirstName() != null)
            return false;
        return getLastName() != null ? getLastName().equals(namedId.getLastName()) : namedId.getLastName() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
    }
}
