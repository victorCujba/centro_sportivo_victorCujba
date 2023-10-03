package it.euris.javaacademy.centrosportivocv.entity;


import it.euris.javaacademy.centrosportivocv.dto.CustomerCourseDTO;
import it.euris.javaacademy.centrosportivocv.dto.archetype.Model;
import it.euris.javaacademy.centrosportivocv.entity.key.CustomerCourseKey;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_course")
public class CustomerCourse implements Model {

    @EmbeddedId
    private CustomerCourseKey id;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "deleted")
    @Builder.Default
    private Boolean deleted = false;


    @Override
    public CustomerCourseDTO toDto() {
        return CustomerCourseDTO
                .builder()
                .courseId(course == null ? null : course.getId().toString())
                .costumerId(customer == null ? null : customer.getId().toString())
                .build();
    }
}
