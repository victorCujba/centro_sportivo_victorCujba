package it.euris.javaacademy.centrosportivocv.service.impl;

import it.euris.javaacademy.centrosportivocv.entity.Contact;
import it.euris.javaacademy.centrosportivocv.repository.ContactRepository;
import it.euris.javaacademy.centrosportivocv.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact insert(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Boolean deleteById(Long contactId) {
        contactRepository.deleteById(contactId);
        return contactRepository.findById(contactId).isEmpty();
    }

    @Override
    public Contact findById(Long contactId) {
        return contactRepository.findById(contactId).orElse(Contact.builder().build());
    }
}
