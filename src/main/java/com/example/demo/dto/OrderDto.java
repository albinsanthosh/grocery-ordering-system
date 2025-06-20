package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {
    
    private Long orderId;
    private Long customerId;
    private List<Long> itemsIds;
    private String orderDate;
    private Double totalPrice;
}
