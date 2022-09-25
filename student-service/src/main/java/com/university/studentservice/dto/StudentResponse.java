package com.university.studentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressResponse addressResponse;
}
