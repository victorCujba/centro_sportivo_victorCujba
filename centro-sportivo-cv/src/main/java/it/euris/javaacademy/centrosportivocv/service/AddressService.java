package it.euris.javaacademy.centrosportivocv.service;

import it.euris.javaacademy.centrosportivocv.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAll();

    Address insert(Address address);

    Address update(Address address);

    Boolean deleteById(Long addressId);

    Address findById(Long addressId);
}
