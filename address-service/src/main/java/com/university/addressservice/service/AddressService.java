package com.university.addressservice.service;


import com.university.addressservice.dto.AddressResponse;
import com.university.addressservice.dto.CreateAddressRequest;
import com.university.addressservice.entity.Address;
import com.university.addressservice.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ModelMapper modelMapper;

    Logger logger= LoggerFactory.getLogger(AddressService.class);

    public AddressResponse createAddress(CreateAddressRequest addressRequest){
        Address address=new Address();
        address.setCity(addressRequest.getCity());
        address.setStreet(addressRequest.getStreet());
        addressRepository.save(address);

        return modelMapper.map(address,AddressResponse.class);
    }


    public AddressResponse getById(Integer id){
        Address address=addressRepository.findById(id).get();
        return modelMapper.map(address,AddressResponse.class);
    }

}
