package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {

    private Long customerId;
    private String name; 
    private String email; 
    private String address; 
    private String phone;
}
