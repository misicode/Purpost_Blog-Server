package com.misicode.purpost.imageservice.dto;

public class ImageResponse {
    private String idImage;
    private String name;
    private String url;

    public ImageResponse(String idImage, String name, String url) {
        this.idImage = idImage;
        this.name = name;
        this.url = url;
    }

    public String getIdImage() {
        return idImage;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}

