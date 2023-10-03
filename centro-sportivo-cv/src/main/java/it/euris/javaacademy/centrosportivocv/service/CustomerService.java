package it.euris.javaacademy.centrosportivocv.service;

import it.euris.javaacademy.centrosportivocv.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer insert(Customer customer);

    Customer update(Customer customer);

    Boolean deleteById(Long customerId);

    Customer findById(Long customerId);
}
