package com.sysmap.api.service.aws;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    String upload(MultipartFile file, String fileName);
}
