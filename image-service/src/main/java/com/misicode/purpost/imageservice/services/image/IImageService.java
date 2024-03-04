package com.misicode.purpost.imageservice.services.image;

import com.misicode.purpost.imageservice.domain.Image;
import org.springframework.web.multipart.MultipartFile;

public interface IImageService {
    Image saveImage(MultipartFile file);
}
