package com.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.JobSeekerService;
import com.project.hrms.business.adapters.concretes.FakeCheckServiceAdapter;
import com.project.hrms.business.adapters.concretes.FakeEmailCheckServiceAdapter;
import com.project.hrms.business.constants.Messages;
import com.project.hrms.core.utilities.helpers.business.BusinessRules;
import com.project.hrms.core.utilities.results.*;
import com.project.hrms.dataAccess.abstracts.JobSeekerDao;
import com.project.hrms.entities.concretes.JobSeeker;

import lombok.var;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private FakeCheckServiceAdapter fakeCheckServiceAdapter;
	private FakeEmailCheckServiceAdapter fakeEmailCheckServiceAdapter;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, FakeCheckServiceAdapter fakeCheckServiceAdapter,
			FakeEmailCheckServiceAdapter fakeEmailCheckServiceAdapter) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.fakeCheckServiceAdapter = fakeCheckServiceAdapter;
		this.fakeEmailCheckServiceAdapter = fakeEmailCheckServiceAdapter;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {

		var result = BusinessRules.run(BlankField(jobSeeker), ExistEmail(jobSeeker), ExistIdentityNumber(jobSeeker),
				MatchPassword(jobSeeker), CheckMernis(jobSeeker), CheckEmail(jobSeeker),LengthIdentityNumber(jobSeeker));

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

	private Result BlankField(JobSeeker jobSeeker) {
		if (jobSeeker.getDateOfBirth() == null || jobSeeker.getFirstName().isBlank()
				|| jobSeeker.getLastName().isBlank() || jobSeeker.getEmail().isBlank()
				|| jobSeeker.getPassword().isBlank() || jobSeeker.getLastName().isBlank()) {
			return new ErrorResult(Messages.ERROR_FIELD_IS_BLANK);
		}
		return new SuccessResult();
	}

	private Result MatchPassword(JobSeeker jobSeeker) {
		if (!jobSeeker.getPassword().equals(jobSeeker.getConfirmedPassword())) {
			return new ErrorResult(Messages.USER_ERROR_MATCH_PASSWORD);
		}
		return new SuccessResult();
	}

	private Result ExistEmail(JobSeeker jobSeeker) {
		if (this.jobSeekerDao.existsByEmail(jobSeeker.getEmail())) {
			return new ErrorResult(Messages.ERROR_EMAIL_ALREADY_EXISTS);
		}
		return new SuccessResult();

	}

	private Result ExistIdentityNumber(JobSeeker jobSeeker) {
		if (this.jobSeekerDao.existsByIdentityNumber(jobSeeker.getIdentityNumber())) {
			return new ErrorResult(Messages.JOB_SEEKER_ERROR_IDENTITY_NUMBER_ALREADY_EXISTS);
		}
		return new SuccessResult();
	}

	private Result LengthIdentityNumber(JobSeeker jobSeeker) {
		if(jobSeeker.getIdentityNumber().length()!=11) {
			return new ErrorResult(Messages.JOB_SEEKER_ERROR_LENGTH_IDENTITY_NUMBER);
		}
		return new SuccessResult();
	}
	
	private Result CheckMernis(JobSeeker jobSeeker) {
		if (!this.fakeCheckServiceAdapter.checkIfRealPerson(jobSeeker.getIdentityNumber(), jobSeeker.getFirstName(),
				jobSeeker.getLastName(), jobSeeker.getDateOfBirth())) {
			return new ErrorResult();
		}
		jobSeeker.setMernisVerified(true);
		return new SuccessResult();
	}

	private Result CheckEmail(JobSeeker jobSeeker) {
		if (!fakeEmailCheckServiceAdapter.sendMail()) {
			return new ErrorResult();
		}
		jobSeeker.setEmailVerified(true);
		return new SuccessResult();
	}

}
