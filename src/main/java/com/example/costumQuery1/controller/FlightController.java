package com.example.costumQuery1.controller;

import com.example.costumQuery1.entity.Flight;
import com.example.costumQuery1.entity.FlightStatus;
import com.example.costumQuery1.repository.FlightRepository;
import com.example.costumQuery1.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/generate")
    public ResponseEntity genereteFlight(){
        flightService.genereteFlight();
        return ResponseEntity.ok("created 50 flights");
    }

    @GetMapping("/get-flights")
    public ResponseEntity getAllFlight(){
        return ResponseEntity.ok(flightService.getAllFlights());
    }











}
