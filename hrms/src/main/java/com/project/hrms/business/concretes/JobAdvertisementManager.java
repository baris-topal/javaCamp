package com.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.JobAdvertisementService;
import com.project.hrms.core.utilities.results.*;
import com.project.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.project.hrms.entities.concretes.JobAdvertisement;

import lombok.var;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Added.");
	}

	@Override
	public Result changeActive(int id) {

		var jobId = this.jobAdvertisementDao.getById(id);
		if (jobId == null) {
			return new ErrorResult();
		}
		JobAdvertisement update = jobId;
		update.setActive(!update.isActive());
		this.jobAdvertisementDao.save(update);
		return new SuccessResult();

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActive() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByReleaseDateDesc() {

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByIsActiveTrueOrderByReleaseDateDesc());

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByCompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(jobAdvertisementDao.getAllActiveJobAdvertisementByEmployer_CompanyName(companyName));
	}

}
