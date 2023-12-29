package com.misicode.eggnews.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private Integer idImage;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 200, nullable = false)
    private String url;

    @OneToOne(targetEntity = News.class, mappedBy = "image")
    private News news;

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
