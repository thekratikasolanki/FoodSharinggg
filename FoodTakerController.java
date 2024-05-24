package com.example.foodSharingg.controller;


import com.example.foodSharingg.model.FoodTaker;
import com.example.foodSharingg.repository.FoodTakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food-takers")
public class FoodTakerController {

    @Autowired
    private FoodTakerRepository foodTakerRepository;

    @PostMapping
    public ResponseEntity<?> submitRequest(@RequestBody FoodTaker foodTaker) {
        FoodTaker savedFoodTaker = foodTakerRepository.save(foodTaker);
        return ResponseEntity.ok(savedFoodTaker);
    }
}

