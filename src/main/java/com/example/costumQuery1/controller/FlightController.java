package com.example.costumQuery1.controller;

import com.example.costumQuery1.entity.Flight;
import com.example.costumQuery1.entity.FlightStatus;
import com.example.costumQuery1.repository.FlightRepository;
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
    private FlightRepository flightRepository;

    public String generetedString(){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    @PostMapping("/generate")
    public ResponseEntity genereteFlight(){
        for(int i = 0; i < 50; i++){
            Flight flight = new Flight();
            flight.setDescription(generetedString());
            flight.setFromAirport(generetedString());
            flight.setToAirport(generetedString());
            flight.setStatus(FlightStatus.ON_TIME);
            flightRepository.save(flight);
        }
        return ResponseEntity.ok("created 50 flights");
    }








}
