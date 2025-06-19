package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.GroceryItem;

public interface GroceryRepository extends JpaRepository<GroceryItem, Long>{
    
}
