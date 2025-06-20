package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OrderDto;

public interface OrderService {
    
    OrderDto createOrder(OrderDto orderDto);

    OrderDto getOrderById(Long orderId);

    OrderDto updateOrderItem(Long orderId, List<Long> itemsIds);

    List<OrderDto> getAllOrders();

    void deleteOrder(Long orderId);
}
