package com.example.collegeproject.controller;

import com.example.collegeproject.DTO.Vendoroveralldata;
import com.example.collegeproject.DTO.ratingdto;
import com.example.collegeproject.model.VendorRating;
import com.example.collegeproject.service.VendorRatingService;
import com.example.collegeproject.service.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/ratings")

public class VendorRatingController {

    @Autowired
    private VendorRatingService ratingService;
@Autowired
private VendorService vendorserviece;
    @PostMapping("/add")
    public String addRating(@RequestBody ratingdto ratingnew) {
        return ratingService.addRating(ratingnew);
    }
  
    @GetMapping("/vendor/{vendorId}")
    public List<VendorRating> getVendorRatings(@PathVariable int vendorId) {
        return ratingService.getRatingsByVendor(vendorId);
    }

    @GetMapping("/vendor/{vendorId}/average")
    public double getAverageRating(@PathVariable int vendorId) {
        return ratingService.getAverageRatingByVendor(vendorId);
    }
    @GetMapping("id/{email}")
    public Vendoroveralldata ggettingalldetials(@PathVariable String email) {
        return vendorserviece.getalldetails(email);
    }
    
}
