package com.bezkoder.spring.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.bezkoder.spring.test.repository.HikerRepository;
import com.bezkoder.spring.test.model.Hiker;


@RestController
public class HikerController {
    private final HikerRepository hikerRepository;

    public HikerController(HikerRepository hikerRepository){
        this.hikerRepository = hikerRepository;
    }


    @GetMapping("/hikers")
    public ResponseEntity<List<Hiker>> getAllTrails(){
        return  ResponseEntity.ok(this.hikerRepository.findAll());
    }

    @PostMapping("/hikers/create")
    public ResponseEntity<Hiker> createBooking(@RequestBody Hiker hiker){
        return ResponseEntity.ok(this.hikerRepository.save(hiker));
    }
}