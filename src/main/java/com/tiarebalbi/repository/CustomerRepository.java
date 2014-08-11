package com.tiarebalbi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.tiarebalbi.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>, QueryDslPredicateExecutor<Customer> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}
