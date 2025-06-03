//package com.example.collegeproject.contr;

package com.example.collegeproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.collegeproject.model.Vendor;

import java.util.List;
import java.util.Optional;
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {
    Optional<Vendor> findByEmailAndPasswordHash(String email, String passwordHash);
Vendor findByEmail(String email);
List<Vendor> findByCategory(String Category);
//	Optional<Vendor> findByEmailAndPasswordHash(String email, String password);
}
