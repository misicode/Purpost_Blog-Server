package com.misicode.purpost.postservice.domain.model;

import org.springframework.http.codec.multipart.FilePart;

public class Image {
    private String idImage;
    private String name;
    private String url;
    private FilePart image;

    public Image(String idImage, String name, String url, FilePart image) {
        this.idImage = idImage;
        this.name = name;
        this.url = url;
        this.image = image;
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

    public FilePart getImage() {
        return image;
    }

    public void setImageFile(FilePart image) {
        this.image = image;
    }
}
