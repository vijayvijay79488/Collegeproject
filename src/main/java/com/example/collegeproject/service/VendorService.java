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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

	static String encodeBase64Image(byte[] base64Dat) {
		String base64= Base64.getEncoder().encodeToString(base64Dat);
		return "data:image/png;base64,"+base64;
	}
	static byte[] decodeBase64Image(String base64Data) {
	  
	        String[] parts = base64Data.split(",");
	        return Base64.getDecoder().decode(parts[1]);
	        
	    
	}



	public List<VendorRegister> getallvendor() {
		// TODO Auto-generated method stub
		 List<Vendor> vendors = vendorRepository.findAll();

		    return vendors.stream().map(vendor -> {
		        VendorRegister dto = new VendorRegister();
		        dto.setBusinessName(vendor.getBussinessName());
		        dto.setEmail(vendor.getEmail());
		        dto.setPhone(vendor.getPhone());
		        dto.setPassword(vendor.getPasswordHash());
		        dto.setLocation(vendor.getLocation());
		        dto.setCategory(vendor.getCategory());
		        dto.setYearsOfExperience(vendor.getYearsofexperience());
		        dto.setServiceDescription(vendor.getServicediscription());
		        dto.setTermsAndCondition(vendor.getTermsandconditon());

		        // LONGBLOB to Base64
		        if (vendor.getPortfolio() != null) {
		            dto.setPortfolioBase64(encodeBase64Image(vendor.getPortfolio()));
		        }

		        if (vendor.getCertificationimage() != null) {
		            dto.setCertificationImageBase64(encodeBase64Image(vendor.getCertificationimage()));
		        }

		        return dto;
		    }).collect(Collectors.toList());
	}



	public String updateprofile(int id) {
		
		return null;
	}
	
	
}
