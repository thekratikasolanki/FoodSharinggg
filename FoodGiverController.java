package com.example.foodSharingg.controller;


import com.example.foodSharingg.model.FoodGiver;
import com.example.foodSharingg.repository.FoodGiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food-givers")
public class FoodGiverController {

    @Autowired
    private FoodGiverRepository foodGiverRepository;

    @PostMapping
    public ResponseEntity<?> submitFood(@RequestBody FoodGiver foodGiver) {
        FoodGiver savedFoodGiver = foodGiverRepository.save(foodGiver);
        return ResponseEntity.ok(savedFoodGiver);
    }
}
