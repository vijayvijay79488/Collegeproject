package com.example.collegeproject.repository;

import com.example.collegeproject.model.VendorRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VendorRatingRepository extends JpaRepository<VendorRating, Integer> {

    List<VendorRating> findByVendorId(int vendorId);
    List<VendorRating> findByuserEmail(String userEmail);
    @Query("SELECT AVG(v.rating) FROM VendorRating v WHERE v.vendorId = :vendorId")
    Double findAverageRatingByVendorId(int vendorId);
}
