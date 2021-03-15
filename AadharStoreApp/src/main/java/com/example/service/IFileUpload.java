package com.example.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileUpload {

    String storeFile(MultipartFile file);
}
