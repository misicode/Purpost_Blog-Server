package com.misicode.eggnews.services.image;

import com.misicode.eggnews.domain.Image;

public interface IImageService {
    Image saveImage(String base64File);
}
