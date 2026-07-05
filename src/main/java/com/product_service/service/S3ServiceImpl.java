package com.product_service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;

@Service
public class S3ServiceImpl implements S3Service {
    @Autowired
    private S3Client s3Client;
    @Value("${aws.bucket-name}")
    private String bucketName;

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            String fileName =
                    UUID.randomUUID() + "_" + file.getOriginalFilename();

            PutObjectRequest request =
                    PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(fileName)
                            .contentType(file.getContentType())
                            .build();

            s3Client.putObject(
                    request,
                    RequestBody.fromBytes(file.getBytes())
            );

            return "Uploaded Successfully : " + fileName;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
