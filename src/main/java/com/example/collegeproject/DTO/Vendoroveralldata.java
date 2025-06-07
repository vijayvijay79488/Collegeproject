package com.example.collegeproject.DTO;

import java.util.List;

public class Vendoroveralldata {

    private String businessName;
    private String email;
    private String phone;
    
    private String location;
    private String category;
    private Integer yearsOfExperience;
    private String serviceDescription;
    private String portfolioBase64;
    private String certificationImageBase64;
    public String getCertificationImageBase64() {
		return certificationImageBase64;
	}

	public void setCertificationImageBase64(String certificationImageBase64) {
		this.certificationImageBase64 = certificationImageBase64;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public String getPortfolioBase64() {
		return portfolioBase64;
	}

	public void setPortfolioBase64(String portfolioBase64) {
		this.portfolioBase64 = portfolioBase64;
	}

	public String getTermsAndCondition() {
		return termsAndCondition;
	}

	public void setTermsAndCondition(String termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}

	private String termsAndCondition;

    private List<String> workPhotosBase64; // List of Base64 images
    private List<RatingDTO> ratings;       // List of rating details

    // Getters, Setters, Constructors

    // Nested DTO for rating
    public static class RatingDTO {
        private double ratingValue;
        private String review;
        private String userEmail;

        public RatingDTO() {}

        public RatingDTO(double ratingValue, String review, String userEmail) {
            this.ratingValue = ratingValue;
            this.review = review;
            this.userEmail = userEmail;
        }

        public double getRatingValue() { return ratingValue; }
        public void setRatingValue(double ratingValue) { this.ratingValue = ratingValue; }

        public String getReview() { return review; }
        public void setReview(String review) { this.review = review; }

        public String getUserEmail() { return userEmail; }
        public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    }

    // All Getters and Setters (same as before + for new fields)

    public List<String> getWorkPhotosBase64() {
        return workPhotosBase64;
    }

    public void setWorkPhotosBase64(List<String> workPhotosBase64) {
        this.workPhotosBase64 = workPhotosBase64;
    }

    public List<RatingDTO> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDTO> ratings) {
        this.ratings = ratings;
    }private Double averageRating;

public Double getAverageRating() {
    return averageRating;
}

public void setAverageRating(Double averageRating) {
    this.averageRating = averageRating;
}

    // (Other existing getters/setters not repeated here for brevity)
}
