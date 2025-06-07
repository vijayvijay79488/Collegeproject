package com.example.collegeproject.repository;

import com.example.collegeproject.model.WorkImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkImageRepository extends JpaRepository<WorkImage, Integer> {
    List<WorkImage> findByVendor_UserId(Integer vendorId);

//	void save(WorkImage img);
}
