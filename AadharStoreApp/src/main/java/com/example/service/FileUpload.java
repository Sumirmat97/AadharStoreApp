package com.example.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUpload implements IFileUpload{

	Path fileStorageLocation;
    private final Logger logger = LoggerFactory.getLogger(FileUpload.class);
    
	FileUpload(){
		this.fileStorageLocation = Paths.get("M:\\JobApplications\\15_03_2021 Softonic Solutions\\Upload").toAbsolutePath().normalize();
		
		try {
			Files.createDirectories(this.fileStorageLocation);
		}catch(Exception ex) {
			logger.error(ex.getMessage());
		}
	}
	
    @Override
    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path targetLocation = this.fileStorageLocation.resolve(fileName);
        try{
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        }catch(IOException ex)
        {
        	logger.error(ex.getMessage());
        }
        return targetLocation.toString();
    }
}
