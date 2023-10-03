package it.euris.javaacademy.centrosportivocv.dto;

import it.euris.javaacademy.centrosportivocv.dto.archetype.Dto;
import it.euris.javaacademy.centrosportivocv.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO implements Dto {

    private String id;
    private String address;
    private String city;
    private Boolean deleted;
    private String nation;
    private String postalCode;
    private String province;
    private String customerId;


    @Override
    public Address toModel() {
        return Address
                .builder()
                .id(Long.valueOf((id)))
                .address(address)
                .city(city)
                .deleted(deleted)
                .nation(nation)
                .postalCode(Integer.valueOf((postalCode)))
                .province(province)
                .build();
    }
}
