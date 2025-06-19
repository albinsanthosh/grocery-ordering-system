package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GroceryItemDto {
    
    private Long groceryItemId;
    private String name; 
    private String category; 
    private Double price;
    private Long quantity;
}
