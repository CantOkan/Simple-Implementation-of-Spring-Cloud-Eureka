package com.university.studentservice.feignclients;

import com.university.studentservice.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "address-service",path = "/api/address")
public interface AddressFeignClient {

    // address-service is name of the registered service in eureka server
    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable Integer id);
}
