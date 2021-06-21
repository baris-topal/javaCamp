package com.project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.hrms.business.abstracts.JobAdvertisementService;
import com.project.hrms.core.utilities.results.*;
import com.project.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.project.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {

		this.jobAdvertisementService.add(jobAdvertisement);
		return new SuccessResult();
	}
	
	@PostMapping("/changeActive")
	public Result changeActive(@RequestBody JobAdvertisement jobAdvertisement) {

		this.jobAdvertisementService.changeActive(jobAdvertisement.getId());
		return new SuccessResult();
	}
	
	
	@GetMapping("/getAllActive")
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvert(){
		return jobAdvertisementService.getAllActive();
	}
	
	@GetMapping("/getByIsActiveTrueOrderByReleaseDateDesc")
	public DataResult<List<JobAdvertisement>> getAllByCreationDateAsc(){
		return jobAdvertisementService.getByIsActiveTrueOrderByReleaseDateDesc();
	}

	@PostMapping("/getAllActiveJobAdvertisementByCompanyName")
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertByCompanyName(
			@RequestParam("companyName") String companyName) {
		return jobAdvertisementService.getAllActiveJobAdvertisementByCompanyName(companyName);
	}

}
