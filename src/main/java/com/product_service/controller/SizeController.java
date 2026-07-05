package com.product_service.controller;

import com.product_service.entity.Size;
import com.product_service.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/size")
public class SizeController {
    @Autowired
    private SizeRepository sizeRepository;

    @GetMapping("/all")
    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }
}
