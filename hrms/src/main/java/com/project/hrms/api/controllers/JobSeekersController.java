package com.project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrms.business.abstracts.JobSeekerService;
import com.project.hrms.core.utilities.results.*;
import com.project.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {

	private JobSeekerService jobSeekerService;
	
	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;

	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker){
		
		return this.jobSeekerService.add(jobSeeker);
		
	}
	@GetMapping("/getAll")
	public DataResult<List<JobSeeker>> getAll(){
		
		return this.jobSeekerService.getAll();
		
	}
	
}
