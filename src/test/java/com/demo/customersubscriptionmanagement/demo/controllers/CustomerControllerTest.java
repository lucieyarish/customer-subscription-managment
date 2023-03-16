package com.demo.customersubscriptionmanagement.demo.controllers;

import com.demo.customersubscriptionmanagement.demo.models.dtos.CustomerDTO;
import com.demo.customersubscriptionmanagement.demo.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void getAllShouldReturnListOfCustomers() throws Exception {
        List<CustomerDTO> customerList = customerService.findAllCustomers();

        Mockito.when(customerService.findAllCustomers()).thenReturn(customerList);
        this.mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andReturn();
    }
}
