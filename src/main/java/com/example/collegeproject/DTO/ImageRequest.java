package com.example.collegeproject.DTO;

public class ImageRequest {
    private String name;
    private String image; // base64 image string

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}