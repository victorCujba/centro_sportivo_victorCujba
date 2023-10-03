package it.euris.javaacademy.centrosportivocv.service;

import it.euris.javaacademy.centrosportivocv.entity.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();

    Contact insert(Contact contact);

    Contact update(Contact contact);

    Boolean deleteById(Long contactId);

    Contact findById(Long contactId);
}
