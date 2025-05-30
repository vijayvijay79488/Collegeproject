package com.example.collegeproject.service;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collegeproject.repository.ImageRepository;
import com.example.collegeproject.DTO.ImageRequest;
import com.example.collegeproject.model.Image;

@Service
public class ImageService {
@Autowired
    private  ImageRepository imageRepository;

  
    public String saveImage(ImageRequest request) {
    	Image imageEntity = new Image();
        imageEntity.setName(request.getName());

        String base64Data = request.getImage();
        String[] parts = base64Data.split(",");

        if (parts.length > 1) {
            byte[] imageBytes = Base64.getDecoder().decode(parts[1]);
            imageEntity.setImage(imageBytes);
        } else {
            throw new IllegalArgumentException("Invalid base64 image data");
        }

        // ✅ This line was missing!
        imageRepository.save(imageEntity);

        return "success";
    }
    public ImageRequest getImageById(int id) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            ImageRequest response = new ImageRequest();

            response.setName(image.getName());
            // Encode byte[] as base64 string and prepend data URI
            String base64 = Base64.getEncoder().encodeToString(image.getImage());
            response.setImage("data:image/png;base64," + base64);

            return response;
        } else {
            throw new RuntimeException("Image not found with ID: " + id);
        }
    }


//	public String saveImage(Image request) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
