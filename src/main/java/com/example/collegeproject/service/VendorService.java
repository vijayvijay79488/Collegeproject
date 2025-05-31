package com.example.collegeproject.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collegeproject.DTO.ImageRequest;
import com.example.collegeproject.DTO.VendorRegister;
import com.example.collegeproject.model.Image;
import com.example.collegeproject.model.Vendor;
import com.example.collegeproject.repository.VendorRepository;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;
class manual extends Exception{
	public manual(String msg) {
		super(msg);
	}
}
@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

  

    public Optional<Vendor> getVendorByEmailAndPassword(String email, String password) {
        return vendorRepository.findByEmailAndPasswordHash(email, password);
    }



	public String saveVendor(VendorRegister vendor) throws manual{
		// TODO Auto-generated method stub
		Vendor newone = new Vendor();
		
		Vendor alreadyexists = vendorRepository.findByEmail(vendor.getEmail());
		if(alreadyexists!=null) {
			throw new manual("already user exists");
		}
       byte[] certBytes = decodeBase64Image(vendor.getCertificationImageBase64());
       newone.setCertificationimage(certBytes);
       byte[] portfolioBytes = decodeBase64Image(vendor.getPortfolioBase64());
       newone.setPortfolio(portfolioBytes);
    newone.setBussinessName(vendor.getBusinessName());
		newone.setCategory(vendor.getCategory());
//		newone.setCertificationimage(null);
		newone.setCreatedAt(LocalDateTime.now());
		newone.setEmail(vendor.getEmail());
		newone.setLocation(vendor.getLocation());
		newone.setPasswordHash(vendor.getPassword());
		newone.setPhone(vendor.getPhone());
//		newone.setPortfolio(vendor);
		newone.setServicediscription(vendor.getServiceDescription());
		newone.setTermsandconditon(vendor.getTermsAndCondition());
		newone.setYearsofexperience(vendor.getYearsOfExperience());
		newone.setUserId(null);
		vendorRepository.save(newone);
		return "succfuly";
		
	}
//	public String saveImage(ImageRequest request) {
//    	Image imageEntity = new Image();
//        imageEntity.setName(request.getName());
//
//        String base64Data = request.getImage();
//        String[] parts = base64Data.split(",");
//
//        if (parts.length > 1) {
//            byte[] imageBytes = Base64.getDecoder().decode(parts[1]);
//            imageEntity.setImage(imageBytes);
//        } else {
//            throw new IllegalArgumentException("Invalid base64 image data");
//        }
//
//        // ✅ This line was missing!
//        imageRepository.save(imageEntity);
//
//        return "success";
//    }
	
	static byte[] decodeBase64Image(String base64Data) {
	  
	        String[] parts = base64Data.split(",");
	        return Base64.getDecoder().decode(parts[1]);
	        
	    
	}
}
