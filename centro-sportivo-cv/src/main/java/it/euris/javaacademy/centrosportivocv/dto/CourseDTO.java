package it.euris.javaacademy.centrosportivocv.dto;

import it.euris.javaacademy.centrosportivocv.dto.archetype.Dto;
import it.euris.javaacademy.centrosportivocv.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.javaacademy.centrosportivocv.utility.DataConversionUtils.stringToBigInt;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO implements Dto {

    private String id;
    private Boolean deleted;
    private String denomination;
    private String difficulty;
    private String price;
    private String sport;

    @Override
    public Course toModel() {
        return Course
                .builder()
                .id(stringToBigInt(id))
                .deleted(deleted)
                .denomination(denomination)
                .difficulty(difficulty)
                .price(Double.valueOf(price))
                .sport(sport)
                .build();
    }
}
