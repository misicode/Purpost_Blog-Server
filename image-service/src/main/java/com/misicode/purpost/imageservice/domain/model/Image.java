package com.misicode.purpost.imageservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.codec.multipart.FilePart;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Image {
    private String idImage;
    private FilePart image;
    private String name;
    private String url;
}
