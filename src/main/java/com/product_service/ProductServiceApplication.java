package com.product_service;

import com.product_service.service.SizeService;
import software.amazon.awssdk.services.s3.S3Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ProductServiceApplication implements CommandLineRunner {
@Autowired
private SizeService sizeService;
public static void main(String[] args) {
	SpringApplication.run(ProductServiceApplication.class, args);
}
	@Override
	public void run(String... args) {
		sizeService.printSizes();
	}
}


