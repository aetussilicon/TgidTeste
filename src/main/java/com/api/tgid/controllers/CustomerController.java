package com.api.tgid.controllers;

import com.api.tgid.model.dto.customer.CustomerDto;
import com.api.tgid.model.dto.customer.CustomerSighUpDto;
import com.api.tgid.model.dto.customer.UpdateCustomerDto;
import com.api.tgid.model.entities.Customer;
import com.api.tgid.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping("signup")
    public ResponseEntity<Customer> signUpCustomer(@RequestBody @Valid CustomerSighUpDto customerSighUpDto) {
        return new ResponseEntity<>(service.signUpCustomer(customerSighUpDto), HttpStatus.CREATED);
    }

    @PatchMapping("update/{username}")
    public ResponseEntity<Customer> patchCustomer(@PathVariable String username, @RequestBody @Valid UpdateCustomerDto updateCustomerDto) {
        return new ResponseEntity<>(service.updateCustomer(username, updateCustomerDto), HttpStatus.ACCEPTED);
    }

    @GetMapping("list/{username}")
    public ResponseEntity<CustomerDto> listCustomer(@PathVariable String username) {
        return new ResponseEntity<>(service.listCustomer(username), HttpStatus.OK);
    }

}
