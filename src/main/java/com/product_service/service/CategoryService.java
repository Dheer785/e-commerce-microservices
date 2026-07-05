package com.product_service.service;

import com.product_service.dto.CategoryDto;
import com.product_service.entity.Brand;

import java.util.List;

public interface CategoryService {
    public List<CategoryDto>findAll();
     public CategoryDto findByCategoryId(long id);
     public CategoryDto findByCategoryname(String name);
    }

