package com.demo.customersubscriptionmanagement.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomersNotFoundException extends RuntimeException {

    public CustomersNotFoundException() {
        super("No customers found!");
    }
}
