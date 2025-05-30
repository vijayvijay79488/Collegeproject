package com.example.collegeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.collegeproject.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {
	}