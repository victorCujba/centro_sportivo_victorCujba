package it.euris.javaacademy.centrosportivocv.dto;

import it.euris.javaacademy.centrosportivocv.dto.archetype.Dto;
import it.euris.javaacademy.centrosportivocv.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.javaacademy.centrosportivocv.utility.DataConversionUtils.stringToLocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO implements Dto {

    private String id;
    private String birthDate;
    private Boolean deleted;
    private String name;
    private String surname;
    private String taxCode;


    @Override
    public Customer toModel() {
        return Customer
                .builder()
                .id(Long.valueOf((id)))
                .birthDate(stringToLocalDateTime(birthDate))
                .deleted(deleted)
                .name(name)
                .surname(surname)
                .taxCode(taxCode)
                .build();
    }
}
