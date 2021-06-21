package com.project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	

	JobAdvertisement getById(int id);
	
	List<JobAdvertisement> getByIsActiveTrueOrderByReleaseDateDesc();
	
	List<JobAdvertisement> getByIsActiveTrue();
	
	@Query("From JobAdvertisement where isActive = true and employer.companyName=:companyName")
	List<JobAdvertisement> getAllActiveJobAdvertisementByEmployer_CompanyName(String companyName);

}
