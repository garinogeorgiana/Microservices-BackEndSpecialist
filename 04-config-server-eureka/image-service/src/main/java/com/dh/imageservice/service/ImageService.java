package com.dh.imageservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Value("${image}")
    private String image;

    public String getImageFromConfigServer(String imageName) {
        return "The image " + imageName + " is: " + image;
    }
}
