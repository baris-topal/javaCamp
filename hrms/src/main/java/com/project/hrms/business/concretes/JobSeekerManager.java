package com.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.JobSeekerService;
import com.project.hrms.business.constants.Messages;
import com.project.hrms.business.validationRules.concretes.JobSeekerValidator;
import com.project.hrms.core.utilities.helpers.business.BusinessRules;
import com.project.hrms.core.utilities.results.*;
import com.project.hrms.dataAccess.abstracts.JobSeekerDao;
import com.project.hrms.entities.concretes.JobSeeker;

import lombok.var;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private JobSeekerValidator jobSeekerValidator;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, JobSeekerValidator jobSeekerValidator) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.jobSeekerValidator = jobSeekerValidator;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {

		var result = BusinessRules.run(jobSeekerValidator.BlankField(jobSeeker),
				jobSeekerValidator.ExistEmail(jobSeeker), jobSeekerValidator.ExistIdentityNumber(jobSeeker),
				jobSeekerValidator.MatchPassword(jobSeeker), jobSeekerValidator.CheckMernis(jobSeeker),
				jobSeekerValidator.CheckEmail(jobSeeker), jobSeekerValidator.LengthIdentityNumber(jobSeeker));

		if (result.isSuccess()) {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult(Messages.SUCCESS_DATA_ADDED);
		}
		return result;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {

		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), Messages.SUCCESS_DATA_LISTED);
	}
}
