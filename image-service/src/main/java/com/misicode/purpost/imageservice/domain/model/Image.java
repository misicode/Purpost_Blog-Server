package com.misicode.purpost.imageservice.domain.model;

import org.springframework.http.codec.multipart.FilePart;

public class Image {
    private String idImage;
    private FilePart image;
    private String name;
    private String url;

    public Image(String idImage, FilePart image, String name, String url) {
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

    public FilePart getImage() {
        return image;
    }

    public void setImage(FilePart image) {
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
