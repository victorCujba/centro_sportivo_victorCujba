package it.euris.javaacademy.centrosportivocv.entity;


import it.euris.javaacademy.centrosportivocv.dto.CustomerDTO;
import it.euris.javaacademy.centrosportivocv.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import static it.euris.javaacademy.centrosportivocv.utility.DataConversionUtils.localDateTimeToString;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")

public class Customer implements Model {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "deleted")
    @Builder.Default
    private Boolean deleted = false;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "tax_code")
    private String taxCode;


    @Override
    public CustomerDTO toDto() {
        return CustomerDTO
                .builder()
                .id(String.valueOf((id)))
                .birthDate(localDateTimeToString(birthDate))
                .deleted(deleted)
                .name(name)
                .surname(surname)
                .taxCode(taxCode)
                .build();


    }

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    List<Address> customerAddresses;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    List<Contact> customerContacts;



}
