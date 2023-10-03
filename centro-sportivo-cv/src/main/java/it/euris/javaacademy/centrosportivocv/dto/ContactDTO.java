package it.euris.javaacademy.centrosportivocv.dto;

import it.euris.javaacademy.centrosportivocv.dto.archetype.Dto;
import it.euris.javaacademy.centrosportivocv.entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDTO implements Dto {

    private String id;
    private String contactType;
    private Boolean deleted;
    private String value;

    @Override
    public Contact toModel() {
        return Contact
                .builder()
                .id(Long.valueOf((id)))
                .contactType(contactType)
                .deleted(deleted)
                .value(value)
                .build();
    }
}
