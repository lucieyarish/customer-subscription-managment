package com.demo.customersubscriptionmanagement.demo.exceptions;

public class CustomersNotFoundException extends RuntimeException {

    public CustomersNotFoundException() {
        super("No customers found!");
    }
}
