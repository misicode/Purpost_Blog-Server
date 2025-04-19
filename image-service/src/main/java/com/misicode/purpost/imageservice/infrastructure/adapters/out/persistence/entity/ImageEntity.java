package com.misicode.purpost.imageservice.infrastructure.adapters.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "images")
public class ImageEntity {
    @Id
    private String idImage;

    private String name;

    private String url;
}
