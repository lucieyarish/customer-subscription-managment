package com.demo.customersubscriptionmanagement.demo.controllers;

import com.demo.customersubscriptionmanagement.demo.exceptions.CustomerNotFoundException;
import com.demo.customersubscriptionmanagement.demo.exceptions.CustomersNotFoundException;
import com.demo.customersubscriptionmanagement.demo.models.dtos.CustomerDTO;
import com.demo.customersubscriptionmanagement.demo.services.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> all() throws CustomersNotFoundException {
        try {
            return customerService.findAllCustomers();
        } catch (CustomersNotFoundException e){
            throw new CustomersNotFoundException();
        }
    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO one(@PathVariable Long id) throws CustomerNotFoundException {
        try {
            return customerService.findCustomer(id);
        } catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundException(id);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity newCustomer(@RequestBody @Valid CustomerDTO customer) {
        customerService.save(customer.toCustomer());
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer was successfully created!");
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity updateCustomer(@RequestBody @Valid CustomerDTO customer, @PathVariable Long id) {
        customerService.update(customer, id);
        return ResponseEntity.status(HttpStatus.OK).body("Customer was successfully updated!");
    }
}
