package com.misicode.purpost.imageservice.infrastructure.adapters.in.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.misicode.purpost.imageservice.application.ports.in.CloudinaryServicePort;
import com.misicode.purpost.imageservice.application.exceptions.ApplicationException;
import com.misicode.purpost.imageservice.application.exceptions.errors.ErrorCatalog;
import com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.utils.CloudinaryConstants;
import com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.utils.CloudinaryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryAdapter implements CloudinaryServicePort {
    private static final Logger LOGGER = LoggerFactory.getLogger(CloudinaryAdapter.class);

    private final WebClient webClient;
    private final CloudinaryUtils cloudinaryUtils;

    @Value("${cloudinary.api_key}")
    private String apiKey;

    public CloudinaryAdapter(WebClient webClient, CloudinaryUtils cloudinaryUtils) {
        this.webClient = webClient;
        this.cloudinaryUtils = cloudinaryUtils;
    }

    @Override
    public Mono<String> uploadFile(FilePart file, String folderName) {
        return webClient
                .post()
                .uri("/image/upload")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(createMultipartData(file, folderName)))
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(response -> response.get("secure_url").asText())
                .onErrorMap(e -> {
                    LOGGER.error("Ocurrió un problema al subir el archivo, ERROR: {}", e.getMessage());
                    LOGGER.error(e.toString());
                    throw new ApplicationException(ErrorCatalog.UPLOAD_FILE_FAILED, Map.of("error", e.getMessage()));
                });
    }

    private MultiValueMap<String, HttpEntity<?>> createMultipartData(FilePart file, String folderName) {
        long timestamp = cloudinaryUtils.generateTimestamp();

        Map<String, String> paramsToSign = new HashMap<>();
        paramsToSign.put(CloudinaryConstants.FOLDER, folderName);
        paramsToSign.put(CloudinaryConstants.TIMESTAMP, String.valueOf(timestamp));
        paramsToSign.put(CloudinaryConstants.TRANSFORMATION, "q_70");

        String signature = cloudinaryUtils.generateSignature(paramsToSign);

        MultipartBodyBuilder builder = new MultipartBodyBuilder();

        builder.part(CloudinaryConstants.FILE, file);
        builder.part(CloudinaryConstants.FOLDER, folderName);
        builder.part(CloudinaryConstants.API_KEY, apiKey);
        builder.part(CloudinaryConstants.TIMESTAMP, timestamp);
        builder.part(CloudinaryConstants.SIGNATURE, signature);
        builder.part(CloudinaryConstants.TRANSFORMATION, "q_70");

        return builder.build();
    }
}
