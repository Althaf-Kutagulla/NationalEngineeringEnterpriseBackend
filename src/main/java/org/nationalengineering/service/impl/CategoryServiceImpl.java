package org.nationalengineering.service.impl;

import lombok.RequiredArgsConstructor;
import org.nationalengineering.entity.Category;
import org.nationalengineering.exception.CategoryNotFoundException;
import org.nationalengineering.mappers.CategoryMapper;
import org.nationalengineering.mappers.ProductMapper;
import org.nationalengineering.records.CategoryRequest;
import org.nationalengineering.records.CategoryResponse;
import org.nationalengineering.records.ProductResponse;
import org.nationalengineering.repository.CategoryRepository;
import org.nationalengineering.service.CategoryService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final ProductMapper productMapper;
    @Override
    public Integer createCategory(CategoryRequest categoryRequest) {
       return categoryRepository.save(categoryMapper.toCategory(categoryRequest)).getCategoryId();
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return  categoryList.stream()
                .map((category) -> {
                    List<ProductResponse> productResponses = productMapper.toProductResponseList(category.getProductList());
                    return new CategoryResponse(
                            category.getCategoryId(),
                            category.getName(),
                            productResponses
                    );
                }).collect(Collectors.toList());

    }

    @Override
    public CategoryResponse getCategoryById(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(
                        ()-> new CategoryNotFoundException(String.format("Category not found with Id:%d",categoryId))
                );
        return categoryMapper.toCategoryReponse(category);
    }

    @Override
    public Boolean updateCategory(CategoryRequest categoryRequest) {
        Category category = categoryRepository.findById(categoryRequest.categoryId())
                .orElseThrow(()->new CategoryNotFoundException(String.format("Category not found with id:%d",categoryRequest.categoryId())));
        mergeCategory(categoryRequest,category);
        categoryRepository.save(category);
        return true;
    }

    private void mergeCategory(CategoryRequest categoryRequest,Category category){
        if(categoryRequest.name() != null){
            category.setName(categoryRequest.name());
        }
    }

    @Override
    public Boolean deleteCategory(Integer categoryid) {
        Category category = categoryRepository.findById(categoryid)
                .orElseThrow(()->new CategoryNotFoundException(String.format("Category not found with id:%d",categoryid)));
        categoryRepository.delete(category);
        return true;
    }
}
