package com.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.JobPositionService;
import com.project.hrms.business.constants.Messages;
import com.project.hrms.business.validationRules.concretes.JobPositionValidator;
import com.project.hrms.core.utilities.helpers.business.BusinessRules;
import com.project.hrms.core.utilities.results.*;
import com.project.hrms.dataAccess.abstracts.JobPositionDao;
import com.project.hrms.entities.concretes.JobPosition;

import lombok.var;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	private JobPositionValidator jobPositionValidator;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao, JobPositionValidator jobPositionValidator) {
		super();
		this.jobPositionDao = jobPositionDao;
		this.jobPositionValidator = jobPositionValidator;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), Messages.SUCCESS_DATA_LISTED);
	}

	@Override
	public Result add(JobPosition jobPosition) {

		var result = BusinessRules.run(jobPositionValidator.ExistName(jobPosition),
				jobPositionValidator.BlankField(jobPosition));
		if (result.isSuccess()) {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult(Messages.SUCCESS_DATA_ADDED);
		}
		return result;
	}
}
