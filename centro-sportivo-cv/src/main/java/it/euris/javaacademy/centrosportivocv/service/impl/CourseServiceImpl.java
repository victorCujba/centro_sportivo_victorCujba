package it.euris.javaacademy.centrosportivocv.service.impl;

import it.euris.javaacademy.centrosportivocv.entity.Course;
import it.euris.javaacademy.centrosportivocv.repository.CourseRepository;
import it.euris.javaacademy.centrosportivocv.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;


    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course insert(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Boolean deleteById(Long courseId) {
        courseRepository.deleteById(courseId);
        return courseRepository.findById(courseId).isEmpty();
    }

    @Override
    public Course findById(Long courseId) {
        return courseRepository.findById(courseId).orElse(Course.builder().build());
    }
}
