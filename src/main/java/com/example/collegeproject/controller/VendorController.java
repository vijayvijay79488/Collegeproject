package com.example.collegeproject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.collegeproject.DTO.VendorRegister;
import com.example.collegeproject.model.Vendor;
import com.example.collegeproject.service.VendorService;

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

    @GetMapping("/login")
    public Optional<Vendor> loginVendor(@RequestParam String email, @RequestParam String password) {
        return vendorService.getVendorByEmailAndPassword(email, password);
    }
    @GetMapping("/getvendorlist")
    	public List<VendorRegister> getallvendor(){
    		List<VendorRegister> res = vendorService.getallvendor();
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
}
