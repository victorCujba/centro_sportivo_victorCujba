package it.euris.javaacademy.centrosportivocv.dto;

import it.euris.javaacademy.centrosportivocv.dto.archetype.Dto;
import it.euris.javaacademy.centrosportivocv.entity.CustomerCourse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.javaacademy.centrosportivocv.utility.DataConversionUtils.stringToBigInt;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerCourseDTO implements Dto {

    private String courseId;
    private String costumerId;
    private Boolean deleted;


    @Override
    public CustomerCourse toModel() {
        return CustomerCourse
                .builder()
                .costumerId(stringToBigInt(costumerId))
                .costumerId(stringToBigInt(costumerId))
                .deleted(deleted)
                .build();
    }
}
