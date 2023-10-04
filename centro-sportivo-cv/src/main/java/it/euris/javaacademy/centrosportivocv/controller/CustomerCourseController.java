package it.euris.javaacademy.centrosportivocv.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.javaacademy.centrosportivocv.dto.CustomerCourseDTO;
import it.euris.javaacademy.centrosportivocv.entity.CustomerCourse;
import it.euris.javaacademy.centrosportivocv.exception.IdMustBeNullException;
import it.euris.javaacademy.centrosportivocv.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centrosportivocv.service.CustomerCourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customers-courses")
public class CustomerCourseController {

    CustomerCourseService customerCourseService;


    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all the coustomers-course from data base.
            """)
    public List<CustomerCourseDTO> getAllCustomerCourse() {
        return customerCourseService.findAll().stream().map(CustomerCourse::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save new customer course to data base.
            """)
    public CustomerCourseDTO saveCustomerCourse(@RequestBody CustomerCourseDTO customerCourseDTO) {
        try {
            CustomerCourse customerCourse = customerCourseDTO.toModel();
            return customerCourseService.insert(customerCourse).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update customer course data.
            """)
    public CustomerCourseDTO updateCustomerCourse(@RequestBody CustomerCourseDTO customerCourseDTO) {
        try {
            CustomerCourse customerCourse = customerCourseDTO.toModel();
            return customerCourseService.update(customerCourse).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @DeleteMapping("/v1/{id}")
    @Operation(description = """
            This method is used to delete customer course from data base using as parameter customerCourseId.
            """)
    public Boolean deleteCustomerCourse(@PathVariable("id") Long customerCourseId) {
        return customerCourseService.deleteById(customerCourseId);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
            This method is used to find customer course in data base using as parameter customerCourseId.
            """)
    public CustomerCourseDTO getCustomerCourseById(@PathVariable("id") Long customerCourseId) {
        return customerCourseService.findById(customerCourseId).toDto();
    }


}
