package it.euris.javaacademy.centrosportivocv.entity;


import it.euris.javaacademy.centrosportivocv.dto.ContactDTO;
import it.euris.javaacademy.centrosportivocv.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

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
    private Long id;

    @Column(name = "contact_type")
    private String contactType;

    @Column(name = "deleted")
    @Builder.Default
    private Boolean deleted = false;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @Override
    public ContactDTO toDto() {
        return ContactDTO
                .builder()
                .id(String.valueOf((id)))
                .contactType(contactType)
                .deleted(deleted)
                .value(value)
                .build();
    }


}
