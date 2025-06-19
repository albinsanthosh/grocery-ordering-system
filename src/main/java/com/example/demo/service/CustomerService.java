package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CustomerDto;

public interface CustomerService {
    
    CustomerDto createCustomer(CustomerDto customer);

    CustomerDto getCustomerById(Long customerId);

    CustomerDto updateCustomerPhone(Long customerId, String phone);

    List<CustomerDto> getAllCustomers();

    void deleteCustomer(Long id);
}
