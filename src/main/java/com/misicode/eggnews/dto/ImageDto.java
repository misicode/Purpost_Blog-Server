package com.misicode.eggnews.dto;

public class ImageDto {
    private String name;
    private String url;

    public ImageDto(String name, String url) {
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
