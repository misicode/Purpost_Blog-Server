package com.misicode.eggnews.services.cloudinary;

public interface ICloudinaryService {
    String uploadFile(String base64Image, String folderName);
}
