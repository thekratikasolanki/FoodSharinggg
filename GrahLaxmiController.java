package com.example.foodSharingg.controller;


import com.example.foodSharingg.model.GrahLaxmi;
import com.example.foodSharingg.repository.GrahLaxmiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grahlaxmi")
public class GrahLaxmiController {

    @Autowired
    private GrahLaxmiRepository grahLaxmiRepository;

    @PostMapping
    public ResponseEntity<?> registerGrahLaxmi(@RequestBody GrahLaxmi grahLaxmi) {
        GrahLaxmi savedGrahLaxmi = grahLaxmiRepository.save(grahLaxmi);
        return ResponseEntity.ok(savedGrahLaxmi);
    }
}

