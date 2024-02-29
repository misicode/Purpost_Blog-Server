package com.misicode.eggnews.services.cloudinary;

import org.springframework.web.multipart.MultipartFile;

public interface ICloudinaryService {
    String uploadFile(MultipartFile file, String folderName);
}
