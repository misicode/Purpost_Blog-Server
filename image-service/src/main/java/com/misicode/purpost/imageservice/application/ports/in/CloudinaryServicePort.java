package com.misicode.purpost.imageservice.application.ports.in;

import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Mono;

public interface CloudinaryServicePort {
    Mono<String> uploadFile(FilePart file, String folderName);
}
