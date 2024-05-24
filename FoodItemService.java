package com.example.foodSharingg.service;


import com.example.foodSharingg.model.FoodItem;
import com.example.foodSharingg.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

 @Autowired
 private FoodItemRepository foodItemRepository;

 public FoodItem saveFoodItem(FoodItem foodItem) {
     return foodItemRepository.save(foodItem);
 }

 public List<FoodItem> getAllFoodItems() {
     return foodItemRepository.findAll();
 }

 public Optional<FoodItem> getFoodItemById(Long id) {
     return foodItemRepository.findById(id);
 }

 public FoodItem updateFoodItem(Long id, FoodItem foodItemDetails) {
     FoodItem foodItem = foodItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Food item not found"));
     foodItem.setEventType(foodItemDetails.getEventType());
     foodItem.setLocation(foodItemDetails.getLocation());
     foodItem.setDate(foodItemDetails.getDate());
     foodItem.setEstimatedAttendees(foodItemDetails.getEstimatedAttendees());
     foodItem.setFoodType(foodItemDetails.getFoodType());
     foodItem.setNumberOfFoodItems(foodItemDetails.getNumberOfFoodItems());
     foodItem.setNumberOfPersonsServed(foodItemDetails.getNumberOfPersonsServed());
     return foodItemRepository.save(foodItem);
 }

 public void deleteFoodItem(Long id) {
     foodItemRepository.deleteById(id);
 }
}

