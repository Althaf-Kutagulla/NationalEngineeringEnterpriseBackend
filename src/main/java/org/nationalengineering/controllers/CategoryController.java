package org.nationalengineering.controllers;

import lombok.RequiredArgsConstructor;
import org.nationalengineering.records.CategoryRequest;
import org.nationalengineering.records.CategoryResponse;
import org.nationalengineering.records.MotorRequest;
import org.nationalengineering.records.MotorResponse;
import org.nationalengineering.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<Integer> createCategory(@RequestBody CategoryRequest categoryRequest){
        return new ResponseEntity<>(categoryService.createCategory(categoryRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(),HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable("categoryId") Integer categoryId){
        return new ResponseEntity<>(categoryService.getCategoryById(categoryId),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateCategory(@RequestBody CategoryRequest categoryRequest){
        return new ResponseEntity<>(categoryService.updateCategory(categoryRequest),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("categoryId") Integer categoryId){
        return new ResponseEntity<>(categoryService.deleteCategory(categoryId),HttpStatus.OK);
    }

}
