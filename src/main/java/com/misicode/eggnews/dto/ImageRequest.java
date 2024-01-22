package com.misicode.eggnews.dto;

public class ImageRequest {
    private String base64Image;

    public ImageRequest(String base64Image) {
        this.base64Image = base64Image;
    }

    public String getBase64Image() {
        return base64Image;
    }
}
