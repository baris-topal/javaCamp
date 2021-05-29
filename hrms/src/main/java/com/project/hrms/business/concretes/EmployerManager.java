package com.project.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.EmployerService;
import com.project.hrms.business.adapters.concretes.FakeEmailCheckServiceAdapter;
import com.project.hrms.business.constants.Messages;
import com.project.hrms.core.utilities.helpers.business.BusinessRules;
import com.project.hrms.core.utilities.results.*;
import com.project.hrms.dataAccess.abstracts.EmployerDao;
import com.project.hrms.entities.concretes.Employer;

import lombok.var;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private FakeEmailCheckServiceAdapter fakeEmailCheckServiceAdapter;

	@Autowired
	public EmployerManager(EmployerDao employerDao,FakeEmailCheckServiceAdapter fakeEmailCheckServiceAdapter) {
		this.employerDao = employerDao;
		this.fakeEmailCheckServiceAdapter=fakeEmailCheckServiceAdapter;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.SUCCESS_DATA_LISTED);
	}

	@Override
	public Result add(Employer employer) {

		var result = BusinessRules.run(BlankField(employer), CheckIfEmailExist(employer),
				IsMatchEmailWebSite(employer),MatchPassword(employer),CheckSystemStaff(employer),CheckEmail(employer));
		if (result.isSuccess()) {
			this.employerDao.save(employer);
			return new SuccessResult(Messages.SUCCESS_DATA_ADDED);
		}
		return result;
	}

	private Result BlankField(Employer employer) {
		if (employer.getCompanyName().isBlank() || employer.getWebSite().isBlank()
				|| employer.getPhoneNumber().isBlank() || employer.getEmail().isBlank()
				|| employer.getPassword().isBlank()) {
			return new ErrorResult(Messages.ERROR_FIELD_IS_BLANK);
		}
		return new SuccessResult();
	}

	private Result CheckIfEmailExist(Employer employer) {
		if (this.employerDao.existsByEmail(employer.getEmail())) {
			return new ErrorResult(Messages.ERROR_EMAIL_ALREADY_EXISTS);
		}
		return new SuccessResult();

	}

	private Result IsMatchEmailWebSite(Employer employer) {
		Pattern pattern = Pattern.compile("@" + employer.getWebSite());
		Matcher matcher = pattern.matcher(employer.getEmail());
		if (!matcher.matches()) {
			return new ErrorResult(Messages.EMPLOYER_ERROR_MATCH_EMAIL_WEB_SITE);
		}
		return new SuccessResult();
	}

	private Result MatchPassword(Employer employer) {
		if (!employer.getPassword().equals(employer.getConfirmedPassword())) {
			return new ErrorResult(Messages.USER_ERROR_MATCH_PASSWORD);
		}
		return new SuccessResult();
	}

	private Result CheckSystemStaff(Employer employer) {
		employer.setSystemVerified(true);
		return new SuccessResult();
	}
	
	private Result CheckEmail(Employer employer) {
		if (!fakeEmailCheckServiceAdapter.sendMail()) {
			return new ErrorResult();
		}
		employer.setEmailVerified(true);
		return new SuccessResult();
	}
}
