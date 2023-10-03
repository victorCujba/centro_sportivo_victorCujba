package it.euris.javaacademy.centrosportivocv.service.impl;

import it.euris.javaacademy.centrosportivocv.entity.Customer;
import it.euris.javaacademy.centrosportivocv.repository.CustomerRepository;
import it.euris.javaacademy.centrosportivocv.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer insert(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Boolean deleteById(Long customerId) {
        customerRepository.deleteById((customerId));
        return customerRepository.findById(customerId).isEmpty();
    }


    @Override
    public Customer findById(Long customerId) {
        return customerRepository.findById((customerId)).orElse(Customer.builder().build());
    }
}
