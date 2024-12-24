package org.nationalengineering.controllers;

import lombok.RequiredArgsConstructor;
import org.nationalengineering.records.MotorRequest;
import org.nationalengineering.records.MotorResponse;
import org.nationalengineering.records.ProductRequest;
import org.nationalengineering.records.ProductResponse;
import org.nationalengineering.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Integer> createMotor(@RequestBody ProductRequest productRequest){
        return new ResponseEntity<>(productService.createProduct(productRequest), HttpStatus.CREATED);
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("productId") Integer productId){
        return new ResponseEntity<>(productService.getProductById(productId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateMotor(@RequestBody ProductRequest productRequest){
        return new ResponseEntity<>(productService.updateProduct(productRequest),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Boolean> deleteWorker(@PathVariable("productId") Integer productId){
        return new ResponseEntity<>(productService.deleteProduct(productId),HttpStatus.OK);
    }
}
