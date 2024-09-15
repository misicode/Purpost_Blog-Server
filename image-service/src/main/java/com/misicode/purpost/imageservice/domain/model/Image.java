package com.misicode.purpost.imageservice.domain.model;

import org.springframework.web.multipart.MultipartFile;

public class Image {
    private String idImage;
    private MultipartFile image;
    private String name;
    private String url;

    public Image(String idImage, MultipartFile image, String name, String url) {
        this.idImage = idImage;
        this.image = image;
        this.name = name;
        this.url = url;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
