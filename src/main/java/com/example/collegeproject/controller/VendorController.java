package com.example.collegeproject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.collegeproject.DTO.VendorRegister;
import com.example.collegeproject.DTO.Vendoroveralldata;
import com.example.collegeproject.DTO.loginDTO;
import com.example.collegeproject.model.User;
import com.example.collegeproject.model.Vendor;
import com.example.collegeproject.model.VendorRating;
import com.example.collegeproject.model.WorkImage;
import com.example.collegeproject.repository.VendorRatingRepository;
import com.example.collegeproject.repository.WorkImageRepository;
import com.example.collegeproject.service.VendorService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
 

@RestController
@RequestMapping("/api/vendor")
@CrossOrigin(origins = "http://localhost:4200")
// Adjust to match frontend
public class VendorController {
    @Autowired
    private VendorService vendorService;
    @Autowired
    private VendorRatingRepository ratingRepo;

    @PostMapping("/register")
    public ResponseEntity<Map<String,Object>> registerVendor(@RequestBody VendorRegister vendor) {
        Map<String,Object> res=new HashMap<String,Object>();

    	try {
    		String response  =vendorService.saveVendor(vendor);
    		res.put("status", HttpStatus.OK);
    		res.put("response", response);
    		
    		}catch (Exception e)
    	{
    			res.put("status", HttpStatus.BAD_REQUEST);
        		res.put("message", e.getMessage());
    	}
    	return new ResponseEntity<Map<String,Object>>(res, (HttpStatusCode) res.get("status"));
    	}

    @PostMapping("/Login")
	ResponseEntity<Map<String, Object>> LoginUser(@RequestBody loginDTO user) {
		Map<String, Object> res = new HashMap<String, Object>();

		try {
			String response = vendorService.LoginUser(user);
			res.put("status", HttpStatus.OK);
			res.put("response", response);
		} catch (Exception e) {
			res.put("status", HttpStatus.BAD_REQUEST);
			res.put("message", e.getMessage());
		}
		return new ResponseEntity<Map<String, Object>>(res, (HttpStatusCode) res.get("status"));

	}
    @GetMapping("/getvendorlist")
    	public List<VendorRegister> getallvendor(){
    		List<VendorRegister> res = vendorService.getallvendor();
    		return res;
    	}
    @GetMapping("/Catagory")
    public List<VendorRegister> getcategory(String category){
    	List<VendorRegister> res = vendorService.findCategory(category);
    	return res;
    }
    
    @PutMapping("/updateprofile")
    public ResponseEntity<Map<String,Object>> updateprofile(@RequestParam int id){
    Map<String,Object> res = new HashMap<String,Object>();
    try {
    	String response = vendorService.updateprofile(id);
    	res.put("status", HttpStatus.OK);
    	res.put("response", response);
    	
    }catch(Exception e) {
    	res.put("status", HttpStatus.BAD_REQUEST);
    	res.put("message", e.getMessage());

    }
    return new ResponseEntity<Map<String,Object>>(res, (HttpStatusCode) res.get("status"));
    }
    
    @Autowired
    private WorkImageRepository workImageRepository;

    @PostMapping("/{vendorId}/upload-work-photos")
    public ResponseEntity<String> uploadPhotos(
            @PathVariable Integer vendorId,
            @RequestParam("files") List<MultipartFile> files
    ) throws IOException {
        vendorService.uploadWorkPhotos(vendorId, files);
        return ResponseEntity.ok("Photos uploaded successfully.");
    }

    // Fetch work photos
    @GetMapping("/{vendorId}/work-photos")
    public ResponseEntity<List<String>> getVendorPhotos(@PathVariable Integer vendorId) {
        List<String> photos = vendorService.getBase64WorkPhotos(vendorId);
        return ResponseEntity.ok(photos);
    }
    
  

//    @PostMapping
//    public ResponseEntity<VendorRating> submitRating(@RequestBody VendorRating rating) {
//        return ResponseEntity.ok(ratingRepo.save(rating));
//    }
//
//    @GetMapping("/{vendorId}")
//    public ResponseEntity<List<VendorRating>> getRatings(@PathVariable int vendorId) {
//        return ResponseEntity.ok(ratingRepo.findByVendorId(vendorId));
//    }
//    
//    @GetMapping("/details")
//    public ResponseEntity<Vendoroveralldata> getVendorDetails(@RequestParam String email) {
//        Vendoroveralldata vendorDetails = vendorService.getVendorDetailsByEmail(email);
//        return ResponseEntity.ok(vendorDetails);
//    }
}



