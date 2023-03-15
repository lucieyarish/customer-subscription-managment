package com.demo.customersubscriptionmanagement.demo.services;

import com.demo.customersubscriptionmanagement.demo.exceptions.CustomerNotFoundException;
import com.demo.customersubscriptionmanagement.demo.exceptions.CustomersNotFoundException;
import com.demo.customersubscriptionmanagement.demo.models.dtos.CustomerDTO;
import com.demo.customersubscriptionmanagement.demo.models.entities.Customer;
import com.demo.customersubscriptionmanagement.demo.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public List<CustomerDTO> findAllCustomers() {
        log.info("Retrieving customers from database.");

        List<CustomerDTO> customers = customerRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(customers)) {
            throw new CustomersNotFoundException();
        } else {
            return customers;
        }
    }

    @Transactional
    public CustomerDTO findCustomer(Long id) {
        log.info("Retrieving customer with ID: {}.", id);

        Optional<Customer> optCustomer = customerRepository.findById(id);

        if (optCustomer.isPresent()) {
            return convertToDto(optCustomer.get());
        }

        log.error("Customer with ID: {} not found.", id);
        throw new CustomerNotFoundException(id);
    }

    private CustomerDTO convertToDto(Customer customer) {
        if (customer == null) {
            return null;
        }

        return CustomerDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .middleName(customer.getMiddleName() == null ? null : customer.getMiddleName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .birthDate(customer.getBirthDate())
                .build();
    }

}
