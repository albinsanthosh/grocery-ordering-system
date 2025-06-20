package com.example.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Order;
import com.example.demo.entity.Customer;
import com.example.demo.entity.GroceryItem;

public class OrderMapper {
    
    public static Order mapToOrder(OrderDto orderDto, Customer customer, List<GroceryItem> groceryItems){
        if (orderDto == null){
            return null;
        }

        Order order = new Order(
            orderDto.getOrderId(),
            customer,
            groceryItems,
            orderDto.getOrderDate(),
            orderDto.getTotalPrice()
        );

        return order;
    }

    public static OrderDto mapToOrderDto(Order order){
        if (order == null){
            return null;
        }

        OrderDto orderDto = new OrderDto(
            order.getOrderId(),
            order.getCustomer().getCustomerId(),
            order.getItems().stream().map((groceryItem)-> groceryItem.getGroceryItemId()).collect(Collectors.toList()),
            order.getOrderDate(),
            order.getTotalPrice()
        );

        return orderDto;
    }
}
