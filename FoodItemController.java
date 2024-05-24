package com.example.foodSharingg.controller;


import com.example.foodSharingg.model.FoodItem;
import com.example.foodSharingg.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/food-items")
public class FoodItemController {

 @Autowired
 private FoodItemService foodItemService;

 @PostMapping
 public FoodItem createFoodItem(@RequestBody FoodItem foodItem) {
     return foodItemService.saveFoodItem(foodItem);
 }

 @GetMapping
 public List<FoodItem> getAllFoodItems() {
     return foodItemService.getAllFoodItems();
 }

 @GetMapping("/{id}")
 public Optional<FoodItem> getFoodItemById(@PathVariable Long id) {
     return foodItemService.getFoodItemById(id);
 }

 @PutMapping("/{id}")
 public FoodItem updateFoodItem(@PathVariable Long id, @RequestBody FoodItem foodItemDetails) {
     return foodItemService.updateFoodItem(id, foodItemDetails);
 }

 @DeleteMapping("/{id}")
 public void deleteFoodItem(@PathVariable Long id) {
     foodItemService.deleteFoodItem(id);
 }
}
