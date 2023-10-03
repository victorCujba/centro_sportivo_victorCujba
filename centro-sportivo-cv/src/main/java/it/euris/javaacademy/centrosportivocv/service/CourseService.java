package it.euris.javaacademy.centrosportivocv.service;

import it.euris.javaacademy.centrosportivocv.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course insert(Course course);

    Course update(Course course);

    Boolean deleteById(Long courseId);

    Course findById(Long courseId);

}
