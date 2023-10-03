package it.euris.javaacademy.centrosportivocv.entity;


import it.euris.javaacademy.centrosportivocv.dto.ContactDTO;
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
@Table(name = "contact")
public class Contact implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "contact_type")
    private String contactType;

    @Column(name = "deleted")
    @Builder.Default
    private Boolean deleted = false;

    @Column(name = "value")
    private String value;

    @Column(name = "customer_id")
    private BigInteger customerId;


    @Override
    public ContactDTO toDto() {
        return ContactDTO
                .builder()
                .id(bigIntToString(id))
                .contactType(contactType)
                .deleted(deleted)
                .value(value)
                .customer_id(bigIntToString(customerId))
                .build();
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
