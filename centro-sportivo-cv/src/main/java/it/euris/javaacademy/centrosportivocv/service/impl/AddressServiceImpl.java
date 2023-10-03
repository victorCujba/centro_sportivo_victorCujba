package it.euris.javaacademy.centrosportivocv.service.impl;

import it.euris.javaacademy.centrosportivocv.entity.Address;
import it.euris.javaacademy.centrosportivocv.repository.AddressRepository;
import it.euris.javaacademy.centrosportivocv.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class AddressServiceImpl implements AddressService {

    AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address insert(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Boolean deleteById(Long addressId) {
        addressRepository.deleteById(addressId);
        return addressRepository.findById(addressId).isEmpty();
    }

    @Override
    public Address findById(Long addressId) {
        return addressRepository.findById(addressId).orElse(Address.builder().build());
    }
}
