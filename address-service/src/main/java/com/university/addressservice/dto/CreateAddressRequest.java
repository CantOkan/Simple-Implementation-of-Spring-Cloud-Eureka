package com.university.addressservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateAddressRequest {

    private String city;
    private String street;
}
