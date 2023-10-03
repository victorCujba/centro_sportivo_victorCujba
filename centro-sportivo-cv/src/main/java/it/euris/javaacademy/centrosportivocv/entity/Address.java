package it.euris.javaacademy.centrosportivocv.entity;


import it.euris.javaacademy.centrosportivocv.dto.AddressDTO;
import it.euris.javaacademy.centrosportivocv.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import static it.euris.javaacademy.centrosportivocv.utility.DataConversionUtils.bigIntToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "deleted")
    @Builder.Default
    private Boolean deleted = false;

    @Column(name = "nation")
    private String nation;

    @Column(name = "postal_code")
    private Integer postalCode;

    @Column(name = "province")
    private String province;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @Override
    public AddressDTO toDto() {
        return AddressDTO
                .builder()
                .id(bigIntToString(id))
                .address(address)
                .city(city)
                .deleted(deleted)
                .nation(nation)
                .postalCode(String.valueOf(postalCode))
                .province(province)
                .build();
    }


}
