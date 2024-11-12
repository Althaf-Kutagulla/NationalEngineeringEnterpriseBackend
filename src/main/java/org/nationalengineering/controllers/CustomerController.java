package org.nationalengineering.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.nationalengineering.records.CustomerRequest;
import org.nationalengineering.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.nationalengineering.records.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Integer> createCustomer(@RequestBody @Valid CustomerRequest request){
        return new ResponseEntity<>(customerService.createCustomer(request), HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("customerId") Integer customerId){
        return new ResponseEntity<>(customerService.getCustomer(customerId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateCustomer(@RequestBody CustomerRequest request){
        return new ResponseEntity<>(customerService.updateCustomer(request),HttpStatus.OK);
    }



    @DeleteMapping("/{customerId}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable("customerId") Integer customerId){
        return new ResponseEntity<>(customerService.deleteCustomer(customerId),HttpStatus.OK);
    }
}
