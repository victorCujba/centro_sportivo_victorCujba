package it.euris.javaacademy.centrosportivocv.service;

import it.euris.javaacademy.centrosportivocv.entity.CustomerCourse;

import java.util.List;

public interface CustomerCourseService {

    List<CustomerCourse> findAll();

    CustomerCourse insert(CustomerCourse customerCourse);

    CustomerCourse update(CustomerCourse customerCourse);

    Boolean deleteById(Long customerCourseId);

    CustomerCourse findById(Long customerCourseId);
}
