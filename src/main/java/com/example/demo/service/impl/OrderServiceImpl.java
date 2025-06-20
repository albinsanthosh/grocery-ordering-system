package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Order;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.Customer;
import com.example.demo.entity.GroceryItem;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.GroceryItemMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.GroceryItemService;
import com.example.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    private CustomerService customerService;

    private GroceryItemService groceryItemService;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerService customerService, GroceryItemService groceryItemService){
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.groceryItemService = groceryItemService;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {  
        Customer customer = CustomerMapper.mapToCustomer(customerService.getCustomerById(orderDto.getCustomerId()));
        List<GroceryItem> groceryItems = orderDto.getItemsIds().stream().map((itemId)-> GroceryItemMapper.mapToGroceryItem(groceryItemService.getGroceryItemById(itemId))).collect(Collectors.toList());
        
        Order order = OrderMapper.mapToOrder(orderDto, customer, groceryItems);
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository
            .findById(orderId)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));

        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public OrderDto updateOrderItem(Long orderId, List<Long> itemsIds) {
        Order order = orderRepository
            .findById(orderId)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
        
        List<GroceryItem> groceryItems = itemsIds.stream().map((itemId) -> GroceryItemMapper.mapToGroceryItem(groceryItemService.getGroceryItemById(itemId))).collect(Collectors.toList());
        order.setItems(groceryItems);
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderDto> orderDtos = orderRepository.findAll().stream().map((order) -> OrderMapper.mapToOrderDto(order)).collect(Collectors.toList());
        return orderDtos;
    }

    @Override
    public void deleteOrder(Long orderId) {
        Order order = orderRepository
            .findById(orderId)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
        
        orderRepository.delete(order);
    }
 
    
}
