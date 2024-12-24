package org.nationalengineering.service;

import org.nationalengineering.records.CategoryRequest;
import org.nationalengineering.records.CategoryResponse;

import java.util.List;

public interface CategoryService {
    Integer createCategory(CategoryRequest categoryRequest);

    List<CategoryResponse> getAllCategories();

    CategoryResponse getCategoryById(Integer categoryId);

    Boolean updateCategory(CategoryRequest categoryRequest);

    Boolean deleteCategory(Integer categoryId);
}
