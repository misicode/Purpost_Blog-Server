package com.misicode.purpost.imageservice.infrastructure.adapters.out.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "images")
public class ImageEntity {
    @Id
    private String idImage;

    private String name;

    private String url;

    public ImageEntity(String idImage, String name, String url) {
        this.idImage = idImage;
        this.name = name;
        this.url = url;
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
}
