package com.tdep.tadlab.entity.projectDb;

import jakarta.persistence.Embeddable;

@Embeddable
public class Author {
    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author() {

    }

    @Override
    public String toString() {
        return  "{" +
                "first name='" + firstName + '\'' +
                ", last name='" + lastName + '\'' +
                '}';
    }
}
