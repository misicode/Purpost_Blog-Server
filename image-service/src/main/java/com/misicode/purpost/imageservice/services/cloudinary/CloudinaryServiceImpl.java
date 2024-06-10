package com.misicode.purpost.imageservice.services.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.misicode.purpost.imageservice.exception.ApplicationException;
import com.misicode.purpost.imageservice.exception.error.ErrorResponseEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements ICloudinaryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CloudinaryServiceImpl.class);

    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadFile(MultipartFile file, String folderName) {
        try {
            Map<?,?> uploadedFile = cloudinary.uploader().upload(file.getBytes(),
                    Map.of("folder", folderName, "transformation", new Transformation<>().quality(70)));

            String publicId = (String) uploadedFile.get("public_id");

            return cloudinary.url().secure(true).generate(publicId);
        } catch(IOException e) {
            LOGGER.error("Ocurrió un problema al subir el archivo, ERROR: {}", e.getMessage());
            throw new ApplicationException(ErrorResponseEnum.UPLOAD_FILE_FAILED, Map.of("error", e.getMessage()));
        }
    }
}
