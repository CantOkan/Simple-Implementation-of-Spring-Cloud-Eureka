package com.university.addressservice.controller;


import com.university.addressservice.dto.AddressResponse;
import com.university.addressservice.dto.CreateAddressRequest;
import com.university.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody CreateAddressRequest request){
        return  addressService.createAddress(request);
    }

    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable Integer id){
        return addressService.getById(id);
    }

}
