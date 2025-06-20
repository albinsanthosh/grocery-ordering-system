package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.GroceryItemDto;
import com.example.demo.entity.GroceryItem;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.GroceryItemMapper;
import com.example.demo.repository.GroceryRepository;
import com.example.demo.service.GroceryItemService;

@Service
public class GroceryItemServiceImpl implements GroceryItemService{

    private GroceryRepository groceryRepository;

    public GroceryItemServiceImpl(GroceryRepository groceryRepository){
        this.groceryRepository = groceryRepository;
    }

    @Override
    public GroceryItemDto createGroceryItem(GroceryItemDto groceryItemDto) {
        GroceryItem groceryItem = GroceryItemMapper.mapToGroceryItem(groceryItemDto);
        GroceryItem savedGroceryItem = groceryRepository.save(groceryItem);
        return GroceryItemMapper.mapToGroceryItemDto(savedGroceryItem);
    }

    @Override
    public GroceryItemDto getGroceryItemById(Long groceryItemId) {
        GroceryItem groceryItem = groceryRepository
        .findById(groceryItemId)
        .orElseThrow(() -> 
            new ResourceNotFoundException("Grocery item not found with id: " + groceryItemId));

        return GroceryItemMapper.mapToGroceryItemDto(groceryItem);
    }

    @Override
    public GroceryItemDto updateGroceryItemQuantity(Long groceryItemId, Long quantity) {
        GroceryItem groceryItem = groceryRepository
        .findById(groceryItemId)
        .orElseThrow(() -> 
            new ResourceNotFoundException("Grocery item not found with id: " + groceryItemId));

        groceryItem.setQuantity(quantity);
        GroceryItem savedGroceryItem = groceryRepository.save(groceryItem);
        return GroceryItemMapper.mapToGroceryItemDto(savedGroceryItem);
    }

    @Override
    public List<GroceryItemDto> getAllGroceryItems() {
        List<GroceryItem> groceryItems = groceryRepository.findAll();
        return groceryItems.stream().map((groceryItem) -> GroceryItemMapper.mapToGroceryItemDto(groceryItem)).collect(Collectors.toList());
    }

    @Override
    public void deleteGroceryItem(Long groceryItemId) {
        GroceryItem groceryItem = groceryRepository
        .findById(groceryItemId)
        .orElseThrow(() -> 
            new ResourceNotFoundException("Grocery item not found with id: " + groceryItemId));

        groceryRepository.delete(groceryItem);
    }
    
}
