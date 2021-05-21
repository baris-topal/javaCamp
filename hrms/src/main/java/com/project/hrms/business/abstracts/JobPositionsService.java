package com.project.hrms.business.abstracts;

import java.util.List;

import com.project.hrms.entities.concretes.JobPositions;


public interface JobPositionsService {

	List<JobPositions> getAll();

}
