package it.euris.javaacademy.centrosportivocv.dto;

import it.euris.javaacademy.centrosportivocv.dto.archetype.Dto;
import it.euris.javaacademy.centrosportivocv.entity.Course;
import it.euris.javaacademy.centrosportivocv.entity.Customer;
import it.euris.javaacademy.centrosportivocv.entity.CustomerCourse;
import it.euris.javaacademy.centrosportivocv.entity.key.CustomerCourseKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.javaacademy.centrosportivocv.utility.DataConversionUtils.stringToLong;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCourseDTO implements Dto {

    private String courseId;
    private String costumerId;
    private Boolean deleted;


    @Override
    public CustomerCourse toModel() {
        return CustomerCourse
                .builder()
                .id(new CustomerCourseKey(stringToLong(courseId), stringToLong(costumerId)))
                .course(Course.builder().id(stringToLong(courseId)).build())
                .customer(Customer.builder().id(stringToLong(costumerId)).build())
                .build();
    }
}
