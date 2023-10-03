package it.euris.javaacademy.centrosportivocv.controller;


import io.swagger.v3.oas.annotations.Operation;
import it.euris.javaacademy.centrosportivocv.dto.AddressDTO;
import it.euris.javaacademy.centrosportivocv.entity.Address;
import it.euris.javaacademy.centrosportivocv.exception.IdMustBeNullException;
import it.euris.javaacademy.centrosportivocv.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController {

    AddressService addressService;

    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all the addresses from the data base.
            """)
    public List<AddressDTO> getAllAddresses() {
        return addressService.findAll().stream().map(Address::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save a new address to a data base.
            """)
    public AddressDTO saveAddress(@RequestBody AddressDTO addressDTO) {
        try {
            Address address = addressDTO.toModel();
            return addressService.insert(address).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update address data .
            """)
    public AddressDTO updateAddress(@RequestBody AddressDTO addressDTO) {
        try {
            Address address = addressDTO.toModel();
            return addressService.update(address).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    @Operation(description = """
            This method is used to delete address from data base using as parameter customer ID
            """)
    public Boolean deleteAddress(@PathVariable("id") Long addressId) {
        return addressService.deleteById(addressId);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
            This method is used to retrieve an address using as parameter addressID.
            """)
    public AddressDTO getCustomerById(@PathVariable("id") Long addressId) {
        return addressService.findById(addressId).toDto();
    }


}
