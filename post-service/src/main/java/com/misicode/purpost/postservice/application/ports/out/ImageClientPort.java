package com.misicode.purpost.postservice.application.ports.out;

import com.misicode.purpost.postservice.domain.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageClientPort {
    Image findById(String id);

    Image save(MultipartFile image);

    Image update(String id, MultipartFile image);
}
