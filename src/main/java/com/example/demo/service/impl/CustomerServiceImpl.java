package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) {
        Customer customer = customerRepository
        .findById(customerId)
        .orElseThrow(() -> 
            new RuntimeException("Customer not found with id: " + customerId));
            
        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    public CustomerDto updateCustomerPhone(Long customerId, String phone) {
        Customer customer = customerRepository
        .findById(customerId)
        .orElseThrow(() -> 
            new RuntimeException("Customer not found with id: " + customerId));
        
        customer.setPhone(phone);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map((customer) -> CustomerMapper.mapToCustomerDto(customer)).collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Customer customer = customerRepository
        .findById(customerId)
        .orElseThrow(() -> 
            new RuntimeException("Customer not found with id: " + customerId));
        
        customerRepository.delete(customer);
    }
}

