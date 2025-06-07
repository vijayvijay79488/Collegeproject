package com.example.collegeproject.service;

import com.example.collegeproject.DTO.ratingdto;
import com.example.collegeproject.controller.VendorController;
import com.example.collegeproject.model.Vendor;
import com.example.collegeproject.model.VendorRating;
import com.example.collegeproject.repository.VendorRatingRepository;
import com.example.collegeproject.repository.VendorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class VendorRatingService {

    @Autowired
    private VendorRatingRepository ratingRepo;
    @Autowired
    private VendorRepository repo;

    public String addRating(ratingdto rating) {
        VendorRating r = new VendorRating();
        List<VendorRating> checking = ratingRepo.findByuserEmail(rating.getUsermail());
        
//        boolean alreadyRated = checking.stream()
//        	    .anyMatch(ra -> r.getVendor().getUserId().equals(rating.getRating()));
//        if(checking!=null ) {
//        	return "already you added reivew";
//        }
        
        Vendor v = repo.findByEmail(rating.getVendormail());
        if(v==null) {
        	return "no vendorfound";
        }
        boolean alreadyRated = checking.stream()
        	    .anyMatch(ra -> ra.getVendorId() == v.getUserId());
        System.out.println(alreadyRated);
        if(alreadyRated) {
        	return "your already reivewsd";
        }
        r.setVendorId(v.getUserId());
        
        r.setRating(rating.getRating());
        r.setReview(rating.getReview());
        r.setUserEmail(rating.getUsermail());
        ratingRepo.save(r);
        r.setCreatedAt(null);
        return "add";
        
      
       
    }

    public List<VendorRating> getRatingsByVendor(int vendorId) {
        return ratingRepo.findByVendorId(vendorId);
    }

    public double getAverageRatingByVendor(int vendorId) {
        Double avg = ratingRepo.findAverageRatingByVendorId(vendorId);
        return avg != null ? avg : 0.0;
    }
}
