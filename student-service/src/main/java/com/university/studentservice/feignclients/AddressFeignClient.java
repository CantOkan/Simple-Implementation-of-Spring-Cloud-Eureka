package com.university.studentservice.feignclients;

import com.university.studentservice.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "api-gateway")
public interface AddressFeignClient {
//it will request to api-gateway first then api-gateway will route the request

    // address-service is name of the registered service in eureka server
    @GetMapping("/address-service/api/address/getById/{id}")
    public AddressResponse getById(@PathVariable Integer id);
}
