package com.sysmap.api.service.aws.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sysmap.api.service.aws.FileStorageService;

@Service
public class FileUpload implements FileStorageService {

    @Autowired
    private AwsService _awsService;

    public String upload(MultipartFile file, String fileName) {
        var fileUri = "";

        try {
            fileUri = _awsService.upload(file, fileName);
        } catch (Exception e) {

        }

        return fileUri;
    }
}