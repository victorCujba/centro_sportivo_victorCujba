package it.euris.javaacademy.centrosportivocv.controller;


import io.swagger.v3.oas.annotations.Operation;
import it.euris.javaacademy.centrosportivocv.dto.CustomerDTO;
import it.euris.javaacademy.centrosportivocv.entity.Customer;
import it.euris.javaacademy.centrosportivocv.exception.IdMustBeNullException;
import it.euris.javaacademy.centrosportivocv.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centrosportivocv.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    CustomerService customerService;

    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all the customers from the data base.
            """)
    public List<CustomerDTO> getAllCustomers() {
        return customerService.findAll().stream().map(Customer::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save a new customer to a data base.
            """)
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            Customer customer = customerDTO.toModel();
            return customerService.insert(customer).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update customer data .
            """)
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            Customer customer = customerDTO.toModel();
            return customerService.update(customer).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    @Operation(description = """
            This method is used to delete a customer from data base using as parameter customer ID
            """)
    public Boolean deleteCustomer(@PathVariable("id") Long customerId) {
        return customerService.deleteById(customerId);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
            This method is used to retrieve an customer using as parameter customer ID.
            """)
    public CustomerDTO getCustomerById(@PathVariable("id") Long customerId) {
        return customerService.findById(customerId).toDto();
    }
}
