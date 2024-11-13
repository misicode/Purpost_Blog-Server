package com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CloudinaryUtils {
    @Value("${cloudinary.api_secret}")
    private String apiSecret;

    public String generateSignature(Map<String, String> params) {
        String paramsStr = params.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));

        String signature = paramsStr + apiSecret;

        return DigestUtils.sha1Hex(signature.getBytes(StandardCharsets.UTF_8));
    }

    public long generateTimestamp() {
        return System.currentTimeMillis() / 1000L;
    }
}
