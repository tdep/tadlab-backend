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

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return  "{" +
                "first name='" + firstName + '\'' +
                ", last name='" + lastName + '\'' +
                '}';
    }
}
