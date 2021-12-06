package com.aco.uploadfile;

import com.aco.uploadfile.service.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class UploadFileApplication  {

	public static void main(String[] args) {
		SpringApplication.run(UploadFileApplication.class, args);
	}

}
