package com.misicode.eggnews.services;

import org.springframework.web.multipart.MultipartFile;

public interface ICloudinaryService {
    String uploadFile(MultipartFile multipartFile, String folderName);
}
