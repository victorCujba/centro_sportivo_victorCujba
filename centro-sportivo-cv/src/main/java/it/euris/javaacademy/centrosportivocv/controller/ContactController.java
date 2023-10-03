package it.euris.javaacademy.centrosportivocv.controller;


import io.swagger.v3.oas.annotations.Operation;
import it.euris.javaacademy.centrosportivocv.dto.ContactDTO;
import it.euris.javaacademy.centrosportivocv.entity.Contact;
import it.euris.javaacademy.centrosportivocv.exception.IdMustBeNullException;
import it.euris.javaacademy.centrosportivocv.exception.IdMustNotBeNullException;
import it.euris.javaacademy.centrosportivocv.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/contacts")
public class ContactController {

    ContactService contactService;

    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all the contacts from data base
            """)
    public List<ContactDTO> getAllContacts() {
        return contactService.findAll().stream().map(Contact::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save a new contact to data base.
            """)
    public ContactDTO saveContact(@RequestBody ContactDTO contactDTO) {
        try {
            Contact contact = contactDTO.toModel();
            return contactService.insert(contact).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update contact data.
            """)
    public ContactDTO updateContact(@RequestBody ContactDTO contactDTO) {
        try {
            Contact contact = contactDTO.toModel();
            return contactService.update(contact).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    @Operation(description = """
            This method is used to delete contact from data base using as parameter contactId
            """)
    public Boolean deleteContact(@PathVariable("id") Long contactId) {
        return contactService.deleteById(contactId);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
            This method is used to retrieve an contact using as parameter contactId.
            """)
    public ContactDTO getContactById(@PathVariable("id") Long contactId) {
        return contactService.findById(contactId).toDto();
    }
}
