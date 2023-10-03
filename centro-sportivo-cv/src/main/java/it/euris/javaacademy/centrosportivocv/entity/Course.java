package it.euris.javaacademy.centrosportivocv.entity;

import it.euris.javaacademy.centrosportivocv.dto.CourseDTO;
import it.euris.javaacademy.centrosportivocv.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.List;

import static it.euris.javaacademy.centrosportivocv.utility.DataConversionUtils.bigIntToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "deleted")
    @Builder.Default
    private Boolean deleted = false;

    @Column(name = "denomination")
    private String denomination;


    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "price")
    private Double price;

    @Column(name = "sport")
    private String sport;


    @Override
    public CourseDTO toDto() {
        return CourseDTO
                .builder()
                .id(bigIntToString(id))
                .deleted(deleted)
                .denomination(denomination)
                .difficulty(difficulty)
                .price(String.valueOf(price))
                .sport(sport)
                .build();
    }

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    List<CustomerCourse> customerCourses;
}
