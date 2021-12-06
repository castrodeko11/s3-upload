package com.aco.uploadfile.service;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;


import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;


import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;


@Service
public class FilesStorageServiceImpl implements FilesStorageService {
    private final AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withRegion(Regions.SA_EAST_1)
            .withCredentials(new ProfileCredentialsProvider())
            .build();
    private final String bucket_name = "primeiro-bucket-aco";

    @Override
    public void save(MultipartFile file) {
        try {
            InputStream is = file.getInputStream();
            String keyName = file.getOriginalFilename();
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());

            s3Client.putObject(new PutObjectRequest(
                    bucket_name, "preparando/"+keyName, is, metadata));

        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

}
