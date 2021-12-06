package com.aco.uploadfile.service;


import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {

    public void save(MultipartFile file);

}
