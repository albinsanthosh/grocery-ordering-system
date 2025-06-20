package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GroceryItemDto;
import com.example.demo.service.GroceryItemService;

@RestController
@RequestMapping("/api/groceryItems")
public class GroceryItemController {
    
    private GroceryItemService groceryItemService;

    public GroceryItemController(GroceryItemService groceryItemService){
        this.groceryItemService = groceryItemService;
    }

    // Add GroceryItem REST API
    @PostMapping
    public ResponseEntity<GroceryItemDto> addGroceryItem(@RequestBody GroceryItemDto groceryItemDto){
        return new ResponseEntity<>(groceryItemService.createGroceryItem(groceryItemDto), HttpStatus.CREATED);
    }

    // Get Grocery Item by Id REST API
    @GetMapping("/{groceryItemId}")
    public ResponseEntity<GroceryItemDto> getGroceryItemById(@PathVariable Long groceryItemId){
        GroceryItemDto groceryItemDto = groceryItemService.getGroceryItemById(groceryItemId);
        return ResponseEntity.ok(groceryItemDto);
    }

    // Update Grocery Item Quantity REST API
    @PutMapping("/{groceryItemId}/updateQuantity")
    public ResponseEntity<GroceryItemDto> updateGroceryItemQuantity(@PathVariable Long groceryItemId, 
        @RequestBody Map<String, Long> request){
        Long quantity = request.get("quantity");
        GroceryItemDto groceryItemDto = groceryItemService.updateGroceryItemQuantity(groceryItemId, quantity);
        return ResponseEntity.ok(groceryItemDto);
    }

    // Get All Customers REST API
    @GetMapping
    public ResponseEntity<List<GroceryItemDto>> getAllGroceryItems(){
        List<GroceryItemDto> groceryItemDtos = groceryItemService.getAllGroceryItems();
        return ResponseEntity.ok(groceryItemDtos);
    }

    // Delete Grocery Item REST API
    @DeleteMapping("/{groceryItemId}")
    public ResponseEntity<String> deleteGroceryItem(@PathVariable Long groceryItemId){
        groceryItemService.deleteGroceryItem(groceryItemId);
        return ResponseEntity.ok("Grocery Item is deleted successfully!");
    }
}
