package org.nationalengineering.controllers;

import lombok.RequiredArgsConstructor;
import org.nationalengineering.records.MotorRequest;
import org.nationalengineering.records.MotorResponse;
import org.nationalengineering.service.MotorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/motors")
public class MotorController {

    private final MotorService motorService;
    @PostMapping("/create")
    public ResponseEntity<Integer> createMotor(@RequestBody MotorRequest motorRequest){
        return new ResponseEntity<>(motorService.createMotor(motorRequest), HttpStatus.CREATED);
    }

    @GetMapping("{motorId}")
    public ResponseEntity<MotorResponse> getWorkerById(@PathVariable("motorId") Integer motorId){
        return new ResponseEntity<>(motorService.getMotorById(motorId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MotorResponse>> getAllMotors(){
        return new ResponseEntity<>(motorService.getAllMotors(),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateMotor(@RequestBody MotorRequest motorRequest){
        return new ResponseEntity<>(motorService.updateMotor(motorRequest),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{motorId}")
    public ResponseEntity<Boolean> deleteWorker(@PathVariable("motorId") Integer motorId){
        return new ResponseEntity<>(motorService.deleteMotor(motorId),HttpStatus.OK);
    }

}
