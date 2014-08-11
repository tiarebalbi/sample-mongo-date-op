package com.tiarebalbi.entity;

import java.util.Calendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Customer {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Calendar lastVisit;
    
    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastVisit = Calendar.getInstance();
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s', lastVisit=%s]",
                id, firstName, lastName, lastVisit.getTime().toString());
    }

}

