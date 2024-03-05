package com.misicode.purpost.imageservice.dto;

public class ImageResponse {
    private String name;
    private String url;

    public ImageResponse(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}

