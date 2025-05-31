package com.example.collegeproject.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false)
    private String bussinessName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String passwordHash;

    private String location;
    private String category;
    private Integer yearsofexperience;

    @Lob
    private String servicediscription;

    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getBussinessName() {
		return bussinessName;
	}

	public void setBussinessName(String bussinessName) {
		this.bussinessName = bussinessName;
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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
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

	public Integer getYearsofexperience() {
		return yearsofexperience;
	}

	public void setYearsofexperience(Integer yearsofexperience) {
		this.yearsofexperience = yearsofexperience;
	}

	public String getServicediscription() {
		return servicediscription;
	}

	public void setServicediscription(String servicediscription) {
		this.servicediscription = servicediscription;
	}

	public byte[] getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(byte[] portfolio) {
		this.portfolio = portfolio;
	}

	public byte[] getCertificationimage() {
		return certificationimage;
	}

	public void setCertificationimage(byte[] certificationimage) {
		this.certificationimage = certificationimage;
	}

	public String getTermsandconditon() {
		return termsandconditon;
	}

	public void setTermsandconditon(String termsandconditon) {
		this.termsandconditon = termsandconditon;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Lob
    private byte[] portfolio;

    @Lob
    private byte[] certificationimage;

    @Lob
    private String termsandconditon;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
}
