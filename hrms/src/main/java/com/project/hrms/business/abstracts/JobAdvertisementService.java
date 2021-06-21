package com.project.hrms.business.abstracts;

import java.util.List;

import com.project.hrms.core.utilities.results.*;
import com.project.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService   {

	Result add(JobAdvertisement jobAdvertisement);

	Result changeActive(int id);

	DataResult<List<JobAdvertisement>> getAllActive();

	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByReleaseDateDesc();
	
	DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByCompanyName(String companyName);

}
