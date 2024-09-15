package com.misicode.purpost.imageservice.application.ports.in;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryServicePort {
    String uploadFile(MultipartFile file, String folderName);
}
