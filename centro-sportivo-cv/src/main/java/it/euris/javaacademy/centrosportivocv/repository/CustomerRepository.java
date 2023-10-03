package it.euris.javaacademy.centrosportivocv.repository;

import it.euris.javaacademy.centrosportivocv.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
