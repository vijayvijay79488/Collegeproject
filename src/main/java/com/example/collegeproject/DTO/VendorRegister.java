package com.example.collegeproject.DTO;

public class VendorRegister {
	private String businessName;
    private String email;
    private String phone;
    private String password;
    private String location;
    private String category;
    private Integer yearsOfExperience;
    private String serviceDescription;
    private String portfolioBase64;
    // Base64-encoded image
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getCertificationImageBase64() {
		return certificationImageBase64;
	}
	public void setCertificationImageBase64(String certificationImageBase64) {
		this.certificationImageBase64 = certificationImageBase64;
	}
	public String getTermsAndCondition() {
		return termsAndCondition;
	}
	public void setTermsAndCondition(String termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}
	private String certificationImageBase64;  // Base64-encoded image
    private String termsAndCondition;
}
