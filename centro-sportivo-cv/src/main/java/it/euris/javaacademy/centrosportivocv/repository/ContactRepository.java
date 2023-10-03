package it.euris.javaacademy.centrosportivocv.repository;

import it.euris.javaacademy.centrosportivocv.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
