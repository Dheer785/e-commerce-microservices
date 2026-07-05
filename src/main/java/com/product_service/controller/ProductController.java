package com.product_service.controller;

import com.product_service.dto.APIResponse;
import com.product_service.dto.CategoryDto;
import com.product_service.dto.ProductDto;
import com.product_service.entity.Product;
import com.product_service.service.S3Service;
import org.springframework.web.multipart.MultipartFile;
import com.product_service.service.CategoryService;
import com.product_service.service.ProductService;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    private final CategoryService categoryService;
    private final ProductService productService;
    private S3Service s3Service;

    public ProductController(CategoryService categoryService, ProductService productService, S3Service s3Service) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.s3Service = s3Service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("/list/categories")
    public ResponseEntity<APIResponse<List<CategoryDto>>> getCategories() {
        List<CategoryDto> categoryDto = categoryService.findAll();
        System.out.println("DTO Count = " + categoryDto.size());
        System.out.println(categoryDto);
        APIResponse<List<CategoryDto>> response = new APIResponse<>();
        if (!categoryDto.isEmpty()) {
            response.setMessage("All categories data fetched");
            response.setStatus(200);
            response.setData(categoryDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.setMessage("No categories data found");
        response.setStatus(404);
        response.setData(Collections.emptyList());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> searchProducts(
            @RequestParam String keyword) {


        return ResponseEntity.ok(
                productService.searchProducts(keyword)
        );
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file) {

        String result = s3Service.uploadFile(file);
        return ResponseEntity.ok(result);
    }
}