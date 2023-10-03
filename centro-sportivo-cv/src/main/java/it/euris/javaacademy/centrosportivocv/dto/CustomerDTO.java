package it.euris.javaacademy.centrosportivocv.dto;

import it.euris.javaacademy.centrosportivocv.dto.archetype.Dto;
import it.euris.javaacademy.centrosportivocv.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO implements Dto {

    private Long id;
    private LocalDateTime birthDate;
    private Boolean deleted;
    private String name;
    private String surname;
    private String taxCode;


    @Override
    public Customer toModel() {
        return Customer
                .builder()
                .id(id)
                .birthDate(birthDate)
                .deleted(deleted)
                .name(name)
                .surname(surname)
                .taxCode(taxCode)
                .build();
    }
}
