package com.tdep.tadlab.entity.projectDb;

import jakarta.persistence.Embeddable;

@Embeddable
public class Test {
    private String firstName;
    private String lastName;

    public Test(String fn, String ln) {
        this.firstName = fn;
        this.lastName = ln;
    }

    public Test() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
