package com.project.hrms.business.validationRules.concretes;

import org.springframework.stereotype.Component;

import com.project.hrms.business.adapters.concretes.*;
import com.project.hrms.business.constants.Messages;
import com.project.hrms.core.utilities.results.*;
import com.project.hrms.dataAccess.abstracts.JobSeekerDao;
import com.project.hrms.entities.concretes.*;


@Component
public class JobSeekerValidator extends UserValidator {

	private JobSeekerDao jobSeekerDao;
	private FakeCheckServiceAdapter fakeCheckServiceAdapter;

	public JobSeekerValidator(JobSeekerDao jobSeekerDao, FakeCheckServiceAdapter fakeCheckServiceAdapter,
			FakeEmailCheckServiceAdapter fakeEmailCheckServiceAdapter) {
		super(fakeEmailCheckServiceAdapter);
		this.jobSeekerDao = jobSeekerDao;
		this.fakeCheckServiceAdapter = fakeCheckServiceAdapter;
	}

	public Result BlankField(JobSeeker jobSeeker) {
		super.BlankField(jobSeeker);
		if (jobSeeker.getDateOfBirth() == null || jobSeeker.getFirstName().isBlank()
				|| jobSeeker.getLastName().isBlank() || jobSeeker.getLastName().isBlank()) {
			return new ErrorResult(Messages.USER_ERROR_MATCH_PASSWORD);
		}
		return new SuccessResult();
	}

	public Result ExistEmail(JobSeeker jobSeeker) {
		if (this.jobSeekerDao.existsByEmail(jobSeeker.getEmail())) {
			return new ErrorResult(Messages.ERROR_EMAIL_ALREADY_EXISTS);
		}
		return new SuccessResult();

	}

	public Result ExistIdentityNumber(JobSeeker jobSeeker) {
		if (this.jobSeekerDao.existsByIdentityNumber(jobSeeker.getIdentityNumber())) {
			return new ErrorResult(Messages.JOB_SEEKER_ERROR_IDENTITY_NUMBER_ALREADY_EXISTS);
		}
		return new SuccessResult();
	}

	public Result LengthIdentityNumber(JobSeeker jobSeeker) {
		if (jobSeeker.getIdentityNumber().length() != 11) {
			return new ErrorResult(Messages.JOB_SEEKER_ERROR_LENGTH_IDENTITY_NUMBER);
		}
		return new SuccessResult();
	}

	public Result CheckMernis(JobSeeker jobSeeker) {
		if (!this.fakeCheckServiceAdapter.checkIfRealPerson(jobSeeker.getIdentityNumber(), jobSeeker.getFirstName(),
				jobSeeker.getLastName(), jobSeeker.getDateOfBirth())) {
			return new ErrorResult();
		}
		jobSeeker.setMernisVerified(true);
		return new SuccessResult();
	}
}
