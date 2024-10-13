package com.misicode.purpost.postservice.infrastructure.adapters.out.client.dtos.response;

public class ImageClientResponse {
    private String idImage;
    private String name;
    private String url;

    public ImageClientResponse(String idImage, String name, String url) {
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
