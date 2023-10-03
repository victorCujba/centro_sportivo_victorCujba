package it.euris.javaacademy.centrosportivocv.repository;

import it.euris.javaacademy.centrosportivocv.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
