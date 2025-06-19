package com.example.demo.mapper;

import com.example.demo.dto.GroceryItemDto;
import com.example.demo.entity.GroceryItem;

public class GroceryItemMapper {

    public static GroceryItem mapToGroceryItem(GroceryItemDto groceryItemDto){
        if (groceryItemDto == null){
            return null;
        }
        GroceryItem groceryItem = new GroceryItem(
            groceryItemDto.getGroceryItemId(),
            groceryItemDto.getName(),
            groceryItemDto.getCategory(),
            groceryItemDto.getPrice(),
            groceryItemDto.getQuantity()
        );

        return groceryItem;
    }
    
    public static GroceryItemDto mapToGroceryItemDto(GroceryItem groceryItem){
        if (groceryItem == null){
            return null;
        }

        GroceryItemDto groceryItemDto = new GroceryItemDto(
            groceryItem.getGroceryItemId(),
            groceryItem.getName(),
            groceryItem.getCategory(),
            groceryItem.getPrice(),
            groceryItem.getQuantity()
        );

        return groceryItemDto;
    }
}
