package org.nationalengineering.controllers;

import lombok.RequiredArgsConstructor;
import org.nationalengineering.records.MotorTicketRequest;
import org.nationalengineering.records.MotorTicketResponse;
import org.nationalengineering.service.MotorTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/motor-tickets")
public class MotorTicketController {

    private final MotorTicketService motorTicketService;

    @GetMapping("{id}")
    public ResponseEntity<MotorTicketResponse> getMotorTicketById(@PathVariable("id") Integer motorTicketId){
        return new ResponseEntity<>(motorTicketService.getMotorTicketById(motorTicketId),HttpStatus.OK);
    }

    @GetMapping("/all-motor-tickets")
    public ResponseEntity<List<MotorTicketResponse>> getAllMotorTickets(){
        return new ResponseEntity<>(motorTicketService.getAllMotorTickets(),HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<Integer> createMotorTicket(@RequestBody MotorTicketRequest motorTicketRequest){
        return new ResponseEntity<>(motorTicketService.createMotorTicket(motorTicketRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateMotorTicket(@RequestBody MotorTicketRequest motorTicketRequest){
        return new ResponseEntity<>(motorTicketService.updateMotorTicket(motorTicketRequest),HttpStatus.OK);
    }


    @DeleteMapping("/delete/{motor-ticket-id}")
    public ResponseEntity<Boolean> deleteMotorTicket(@PathVariable("motor-ticket-id") Integer motorTicketId){
        return new ResponseEntity<>(motorTicketService.deleteMotorTicket(motorTicketId),HttpStatus.OK);
    }




}
