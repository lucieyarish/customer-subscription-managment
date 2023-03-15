package com.demo.customersubscriptionmanagement.demo.models.dtos;

import com.demo.customersubscriptionmanagement.demo.models.entities.Customer;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "First name is required.")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Last name is required.")
    private String lastName;

    @NotBlank(message = "Email is required.")
    private String email;

    @NotBlank(message = "Phone number is required.")
    private String phoneNumber;

    private Date birthDate;

    public Customer toCustomer() {
        return new Customer()
                .setFirstName(firstName)
                .setMiddleName(middleName == null ? null : middleName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(birthDate);
    }
}
