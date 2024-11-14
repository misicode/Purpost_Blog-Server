package com.misicode.purpost.postservice.infrastructure.adapters.out.webclient.dtos.response;

public class ImageWebClientResponse {
    private String idImage;
    private String name;
    private String url;

    public ImageWebClientResponse(String idImage, String name, String url) {
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
