package com.misicode.purpost.imageservice.infrastructure.adapters.in.rest;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.misicode.purpost.imageservice.application.ports.in.CloudinaryServicePort;
import com.misicode.purpost.imageservice.domain.exceptions.ApplicationException;
import com.misicode.purpost.imageservice.domain.exceptions.error.ErrorResponseEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryAdapter implements CloudinaryServicePort {
    private static final Logger LOGGER = LoggerFactory.getLogger(CloudinaryAdapter.class);

    private final Cloudinary cloudinary;

    public CloudinaryAdapter(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadFile(MultipartFile file, String folderName) {
        try {
            Map<?,?> uploadedFile = cloudinary.uploader().upload(file.getBytes(),
                    Map.of("folder", folderName, "transformation", new Transformation<>().quality(70))
            );

            String publicId = (String) uploadedFile.get("public_id");

            return cloudinary.url().secure(true).generate(publicId);
        } catch(IOException e) {
            LOGGER.error("Ocurrió un problema al subir el archivo, ERROR: {}", e.getMessage());
            throw new ApplicationException(ErrorResponseEnum.UPLOAD_FILE_FAILED, Map.of("error", e.getMessage()));
        }
    }
}
