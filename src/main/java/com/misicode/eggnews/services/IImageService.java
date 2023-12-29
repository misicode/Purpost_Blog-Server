package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.Image;
import org.springframework.web.multipart.MultipartFile;

public interface IImageService {
    Image saveImage(MultipartFile file);
}
