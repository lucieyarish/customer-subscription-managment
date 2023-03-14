package com.demo.customersubscriptionmanagement.demo.repositories;

import com.demo.customersubscriptionmanagement.demo.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
