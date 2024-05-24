package com.example.foodSharingg.controller;


import com.example.foodSharingg.model.FoodGiver;
import com.example.foodSharingg.model.FoodTaker;
import com.example.foodSharingg.repository.FoodGiverRepository;
import com.example.foodSharingg.repository.FoodTakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/find-match")
public class MatchController {

    @Autowired
    private FoodGiverRepository foodGiverRepository;

    @Autowired
    private FoodTakerRepository foodTakerRepository;

    @GetMapping
    public List<FoodGiver> findMatch() {
        List<FoodGiver> foodGivers = foodGiverRepository.findAll();
        List<FoodTaker> foodTakers = foodTakerRepository.findAll();

        // Basic matching algorithm (for demonstration purposes)
        // This can be improved based on specific matching criteria

        return foodGivers.stream().filter(foodGiver -> {
            for (FoodTaker foodTaker : foodTakers) {
                if (foodGiver.getFoodType().equals(foodTaker.getDietaryPreference()) &&
                        foodGiver.getLocation().equals(foodTaker.getPlace())) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());
    }
}

