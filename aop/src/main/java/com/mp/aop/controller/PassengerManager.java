package com.mp.aop.controller;

import com.mp.aop.aspect.custom.Log;
import com.mp.aop.model.Passenger;
import com.mp.aop.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passenger")
public class PassengerManager {

    @Autowired
    PassengerService passengerService;

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassenger(@PathVariable String id){
        if(id.equals("john-doe")){
            throw new RuntimeException("Invalid ID");
        }
        Passenger passenger = passengerService.getPassenger(id);
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }

    @Log
    @GetMapping
    public ResponseEntity<Passenger> getRandom(){
        Passenger passenger = passengerService.getPassenger("EMP101");
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }
}
