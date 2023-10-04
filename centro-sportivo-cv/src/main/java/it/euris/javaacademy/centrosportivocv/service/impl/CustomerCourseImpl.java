package it.euris.javaacademy.centrosportivocv.service.impl;

import it.euris.javaacademy.centrosportivocv.entity.CustomerCourse;
import it.euris.javaacademy.centrosportivocv.repository.CustomerCourseRepository;
import it.euris.javaacademy.centrosportivocv.service.CustomerCourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerCourseImpl implements CustomerCourseService {

    CustomerCourseRepository customerCourseRepository;

    @Override
    public List<CustomerCourse> findAll() {
        return customerCourseRepository.findAll();
    }

    @Override
    public CustomerCourse insert(CustomerCourse customerCourse) {
        return customerCourseRepository.save(customerCourse);
    }

    @Override
    public CustomerCourse update(CustomerCourse customerCourse) {
        return customerCourseRepository.save(customerCourse);
    }

    @Override
    public Boolean deleteById(Long customerCourseId) {
        customerCourseRepository.deleteById(customerCourseId);
        return customerCourseRepository.findById(customerCourseId).isEmpty();
    }

    @Override
    public CustomerCourse findById(Long customerCourseId) {
        return customerCourseRepository.findById(customerCourseId).orElse(CustomerCourse.builder().build());
    }
}
