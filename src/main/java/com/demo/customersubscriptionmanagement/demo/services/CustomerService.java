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
            log.error("No customers found.");
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

    @Transactional
    public void save(Customer newCustomer) {

        customerRepository.save(newCustomer);
        log.info("New customer with ID: {} was successfully saved!", newCustomer.getId());
    }

    @Transactional
    public void update(CustomerDTO customerDTO, Long id) {
        try {
            Optional<Customer> optCustomer = customerRepository.findById(id);

            if (optCustomer.isPresent()) {
                Customer customer = optCustomer.get();
                customer.setFirstName(customerDTO.getFirstName());
                customer.setMiddleName(customerDTO.getMiddleName() == null ? null : customer.getMiddleName());
                customer.setLastName(customerDTO.getLastName());
                customer.setEmail(customer.getEmail());
                customer.setPhoneNumber(customer.getPhoneNumber());
                customer.setBirthDate(customer.getBirthDate());

                customerRepository.save(customer);

                log.info("New details of customer with ID: {} were successfully saved!", customer.getId());
            }
        } catch (CustomerNotFoundException e) {
            log.error("Customer with ID: {} not found.", id);
            throw new CustomerNotFoundException(id);
        }
    }

    @Transactional
    public void deleteById(Long id) {
        try {
            Optional<Customer> optCustomer = customerRepository.findById(id);

            if (optCustomer.isPresent()) {
                customerRepository.deleteById(id);
                log.info("Deleted customer with ID: {}.", id);
            }
        } catch (CustomerNotFoundException e) {
            log.error("Customer with ID: {} not found.", id);
            throw new CustomerNotFoundException(id);
        }
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
