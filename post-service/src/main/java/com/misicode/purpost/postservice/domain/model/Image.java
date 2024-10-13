package com.misicode.purpost.postservice.domain.model;

import org.springframework.web.multipart.MultipartFile;

public class Image {
    private String idImage;
    private String name;
    private String url;
    private MultipartFile imageFile;

    public Image(String idImage, String name, String url, MultipartFile imageFile) {
        this.idImage = idImage;
        this.name = name;
        this.url = url;
        this.imageFile = imageFile;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
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

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}
