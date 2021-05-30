package com.project.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.EmployerService;
import com.project.hrms.business.constants.Messages;
import com.project.hrms.business.validationRules.concretes.EmployerValidator;
import com.project.hrms.core.utilities.helpers.business.BusinessRules;
import com.project.hrms.core.utilities.results.*;
import com.project.hrms.dataAccess.abstracts.EmployerDao;
import com.project.hrms.entities.concretes.Employer;

import lombok.var;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmployerValidator employerValidator;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerValidator employerValidator) {
		this.employerDao = employerDao;
		this.employerValidator = employerValidator;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.SUCCESS_DATA_LISTED);
	}

	@Override
	public Result add(Employer employer) {

		var result = BusinessRules.run(employerValidator.BlankField(employer),
				employerValidator.CheckIfEmailExist(employer), employerValidator.IsMatchEmailWebSite(employer),
				employerValidator.MatchPassword(employer), employerValidator.CheckSystemStaff(employer),
				employerValidator.CheckEmail(employer));
		if (result.isSuccess()) {
			this.employerDao.save(employer);
			return new SuccessResult(Messages.SUCCESS_DATA_ADDED);
		}
		return result;
	}
}
