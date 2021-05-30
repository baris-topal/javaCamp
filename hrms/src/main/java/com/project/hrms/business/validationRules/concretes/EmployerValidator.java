package com.project.hrms.business.validationRules.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.project.hrms.business.adapters.concretes.FakeEmailCheckServiceAdapter;
import com.project.hrms.business.adapters.concretes.FakeSystemCheckServiceAdapter;
import com.project.hrms.business.constants.Messages;
import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.dataAccess.abstracts.EmployerDao;
import com.project.hrms.entities.concretes.Employer;

@Component
public class EmployerValidator extends UserValidator {

	private EmployerDao employerDao;
	private FakeSystemCheckServiceAdapter fakeSystemCheckServiceAdapter;

	public EmployerValidator(FakeEmailCheckServiceAdapter fakeEmailCheckServiceAdapter, EmployerDao employerDao,
			FakeSystemCheckServiceAdapter fakeSystemCheckServiceAdapter) {
		super(fakeEmailCheckServiceAdapter);
		this.employerDao = employerDao;
		this.fakeSystemCheckServiceAdapter = fakeSystemCheckServiceAdapter;
	}

	public Result BlankField(Employer employer) {
		super.BlankField(employer);
		if (employer.getCompanyName().isBlank() || employer.getWebSite().isBlank()
				|| employer.getPhoneNumber().isBlank()) {
			return new ErrorResult(Messages.ERROR_FIELD_IS_BLANK);
		}
		return new SuccessResult();
	}

	public Result CheckIfEmailExist(Employer employer) {
		if (this.employerDao.existsByEmail(employer.getEmail())) {
			return new ErrorResult(Messages.ERROR_EMAIL_ALREADY_EXISTS);
		}
		return new SuccessResult();
	}

	public Result IsMatchEmailWebSite(Employer employer) {
		Pattern pattern = Pattern.compile("@" + employer.getWebSite());
		Matcher matcher = pattern.matcher(employer.getEmail());
		if (!matcher.matches()) {
			return new ErrorResult(Messages.EMPLOYER_ERROR_MATCH_EMAIL_WEB_SITE);
		}
		return new SuccessResult();
	}


	public Result CheckSystemStaff(Employer employer) {
		if(!fakeSystemCheckServiceAdapter.systemVerified()) {
			return new ErrorResult();
		}
		employer.setSystemVerified(true);
		return new SuccessResult();
	}
}
