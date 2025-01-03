package org.nationalengineering.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.nationalengineering.entity.ProductUsage;
import org.nationalengineering.records.ProductUsageRequest;
import org.nationalengineering.records.ProductUsageResponse;
import org.nationalengineering.service.ProductUsageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product-usages")
public class ProductUsageController {

    private final ProductUsageService productUsageService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductUsageResponse> getProductUsage(@PathVariable Integer id) {
        return new ResponseEntity<>(productUsageService.getProductUsage(id), HttpStatus.OK);
    }

    @GetMapping("/all-product-usages")
    public ResponseEntity<List<ProductUsageResponse>> getAllProductUsages() {
        return new ResponseEntity<>(productUsageService.getAllProductUsages(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> createProductUsage(@RequestBody ProductUsageRequest productUsageRequest) {
        return new ResponseEntity<>(productUsageService.createProductUsage(productUsageRequest),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Boolean> updateProductUsage(@RequestBody @Valid ProductUsageRequest productUsageRequest) {
        return new ResponseEntity<>(productUsageService.updateProductUsage(productUsageRequest),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProductUsage(@PathVariable Integer id) {
        return new ResponseEntity<>(productUsageService.delete(id),HttpStatus.OK);
    }
}
