package com.example.demo.mapper;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;

public class CustomerMapper {
    
    public static Customer mapToCustomer(CustomerDto customerDto) {
        if (customerDto == null) {
            return null;
        }
        
        Customer customer = new Customer(
            customerDto.getCustomerId(),
            customerDto.getName(),
            customerDto.getEmail(),
            customerDto.getAddress(),
            customerDto.getPhone()
        );
        
        return customer;
    }

    public static CustomerDto mapToCustomerDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        
        CustomerDto customerDto = new CustomerDto(
            customer.getCustomerId(),
            customer.getName(),
            customer.getEmail(),
            customer.getAddress(),
            customer.getPhone()
        );
        
        return customerDto;
    }
}
