package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.GroceryItemDto;

public interface GroceryItemService {
    
    GroceryItemDto createGroceryItem(GroceryItemDto groceryItem);

    GroceryItemDto getGroceryItemById(Long groceryItemId);

    GroceryItemDto updateGroceryItemQuantity(Long groceryItemId, Long quantity);

    List<GroceryItemDto> getAllGroceryItems();

    void deleteGroceryItem(Long groceryItemId);
}
