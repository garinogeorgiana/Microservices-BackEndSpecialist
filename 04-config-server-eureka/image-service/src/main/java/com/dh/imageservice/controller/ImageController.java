package com.dh.imageservice.controller;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dh.imageservice.service.ImageService;

@RestController
@RequestMapping("/images")
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public ResponseEntity<String> findImageFromConfigServer(@PathParam("imageName") String imageName) {
        String response = imageService.getImageFromConfigServer(imageName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
