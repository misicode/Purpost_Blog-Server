package com.misicode.eggnews.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements ICloudinaryService {
    private Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadFile(MultipartFile multipartFile, String folderName) {
        try {
            Map uploadedFile = cloudinary.uploader().upload(multipartFile.getBytes(),
                    Map.of("folder", folderName, "transformation", new Transformation<>().quality(70)));

            String publicId = (String) uploadedFile.get("public_id");

            return cloudinary.url().secure(true).generate(publicId);
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
