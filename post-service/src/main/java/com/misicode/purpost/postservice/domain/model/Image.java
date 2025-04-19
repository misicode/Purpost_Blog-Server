package com.misicode.purpost.postservice.domain.model;

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
    private String name;
    private String url;
    private FilePart image;
}
