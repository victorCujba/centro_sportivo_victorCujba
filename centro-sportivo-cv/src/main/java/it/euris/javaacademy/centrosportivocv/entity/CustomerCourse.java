package it.euris.javaacademy.centrosportivocv.entity;

import it.euris.javaacademy.centrosportivocv.dto.CustomerCourseDTO;
import it.euris.javaacademy.centrosportivocv.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

import static it.euris.javaacademy.centrosportivocv.utility.DataConversionUtils.bigIntToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_course")
public class CustomerCourse implements Model {

    @Column
    private BigInteger courseId;

    @Column
    private BigInteger costumerId;

    @Column
    @Builder.Default
    private Boolean deleted = false;


    @Override
    public CustomerCourseDTO toDto() {
        return CustomerCourseDTO
                .builder()
                .courseId(bigIntToString(courseId))
                .costumerId(bigIntToString(costumerId))
                .deleted(deleted)
                .build();
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
