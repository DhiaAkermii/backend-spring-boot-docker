package com.bezkoder.spring.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.bezkoder.spring.test.repository.TrailRepository;
import com.bezkoder.spring.test.model.Trail;

@RestController
public class TrailController {
    private final TrailRepository trailRepository;
    public TrailController(TrailRepository trailRepository){
        this.trailRepository=trailRepository;
    }

    @GetMapping("/trails")
    public ResponseEntity<List<Trail>> getAllTrails(){
        return  ResponseEntity.ok(this.trailRepository.findAll());
    }

    @GetMapping("/trails/{id}")
    public Trail getTrail (@PathVariable(value = "id") Integer id) {
        return this.trailRepository.findById(id).orElse(null);
    }

    @PostMapping("/trails/create")
    public ResponseEntity<Trail> createBooking(@RequestBody Trail trail){
        return ResponseEntity.ok(this.trailRepository.save(trail));
    }

}