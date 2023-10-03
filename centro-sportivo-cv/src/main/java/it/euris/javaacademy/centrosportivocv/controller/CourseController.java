package it.euris.javaacademy.centrosportivocv.controller;


import io.swagger.v3.oas.annotations.Operation;
import it.euris.javaacademy.centrosportivocv.dto.CourseDTO;
import it.euris.javaacademy.centrosportivocv.entity.Course;
import it.euris.javaacademy.centrosportivocv.exception.IdMustBeNullException;
import it.euris.javaacademy.centrosportivocv.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centrosportivocv.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    CourseService courseService;

    @GetMapping
    @Operation(description = """
            This method is used to get all courses from data base.
            """)
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @PostMapping
    @Operation(description = """
            This method is used to save a new course to data base.
            """)
    public CourseDTO saveCourse(@RequestBody CourseDTO courseDTO) {
        try {
            Course course = courseDTO.toModel();
            return courseService.insert(course).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping
    @Operation(description = """
            This method is used to update course data.
            """)
    public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO) {
        try {
            Course course = courseDTO.toModel();
            return courseService.update(course).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping
    @Operation(description = """
            This method is used to delete a course using courseId as parameter.
            """)
    public Boolean deleteCourse(@PathVariable("id") Long courseId) {
        return courseService.deleteById(courseId);
    }

    @GetMapping
    @Operation(description = """
            This method is used to get a course using courseId as parameter
            """)
    public CourseDTO getCourseById(@PathVariable("id") Long courseId) {
        return courseService.findById(courseId).toDto();
    }
}
