package com.demo.customersubscriptionmanagement.demo.controllers;

import com.demo.customersubscriptionmanagement.demo.exceptions.CustomerNotFoundException;
import com.demo.customersubscriptionmanagement.demo.exceptions.CustomersNotFoundException;
import com.demo.customersubscriptionmanagement.demo.models.dtos.CustomerDTO;
import com.demo.customersubscriptionmanagement.demo.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        return customerService.findAllCustomers();
    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO one(@PathVariable Long id) throws CustomerNotFoundException {

        return customerService.findCustomer(id);
    }
}
