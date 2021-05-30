package com.project.hrms.business.validationRules.concretes;

import org.springframework.stereotype.Component;

import com.project.hrms.business.constants.Messages;
import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.dataAccess.abstracts.JobPositionDao;
import com.project.hrms.entities.concretes.JobPosition;

@Component
public class JobPositionValidator {
	
	private JobPositionDao jobPositionDao;
	
	public JobPositionValidator(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	public Result BlankField(JobPosition jobPosition) {
		if (jobPosition.getName().isBlank()) {
			return new ErrorResult(Messages.ERROR_FIELD_IS_BLANK);
		}
		return new SuccessResult();
	}

	public Result ExistName(JobPosition jobPosition) {
		if (this.jobPositionDao.existsByName(jobPosition.getName())) {
			return new ErrorResult(Messages.JOB_POSITION_ERROR_ALREADY_EXISTS);
		}
		return new SuccessResult();
	}
	
}
