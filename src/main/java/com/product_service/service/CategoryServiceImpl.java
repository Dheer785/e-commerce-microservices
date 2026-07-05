package com.product_service.service;

import com.product_service.dto.CategoryDto;
import com.product_service.entity.Category;
import com.product_service.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {


        private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> findAll() {

        System.out.println("Inside CategoryServiceImpl.findAll()");

        List<Category> categories = categoryRepository.findAll();

        System.out.println("Categories found = " + categories.size());

        List<CategoryDto> dtoList = new ArrayList<>();

        for (Category category : categories) {
            System.out.println(category.getId() + " " + category.getName());

            CategoryDto dto = new CategoryDto();
            dto.setId(category.getId());
            dto.setName(category.getName());

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public CategoryDto findByCategoryId(long id) {
        return null;
    }

    @Override
    public CategoryDto findByCategoryname(String name) {
        return null;
    }
}