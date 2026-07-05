package com.product_service.service;

import com.product_service.entity.Size;
import com.product_service.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {
    @Autowired
    private SizeRepository sizeRepository;

    public void printSizes() {
        List<Size> sizes = sizeRepository.findAll();

        sizes.forEach(size -> {
            System.out.println("ID: " + size.getId());
            System.out.println("Size: " + size.getSize());
            System.out.println("Quantity: " + size.getQuantity());
            System.out.println("----------------");
        });
    }
}

