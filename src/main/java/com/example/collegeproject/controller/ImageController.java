package com.example.collegeproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.collegeproject.DTO.ImageRequest;
import com.example.collegeproject.model.Image;

import com.example.collegeproject.service.ImageService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Enable CORS for frontend
public class ImageController {
@Autowired
    private  ImageService imageService;


    @PostMapping("/upload-image")
    public String uploadImage(@RequestBody ImageRequest request) {
       String anser= imageService.saveImage(request);
        return anser;
    }
    @GetMapping("/get-image/{id}")
    public ImageRequest getImage(@PathVariable int id) {
        return imageService.getImageById(id);
    }
}
