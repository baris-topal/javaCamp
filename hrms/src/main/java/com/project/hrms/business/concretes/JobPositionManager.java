package com.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.JobPositionService;
import com.project.hrms.business.constants.Messages;
import com.project.hrms.core.utilities.helpers.business.BusinessRules;
import com.project.hrms.core.utilities.results.*;
import com.project.hrms.dataAccess.abstracts.JobPositionDao;
import com.project.hrms.entities.concretes.JobPosition;

import lombok.var;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),Messages.SUCCESS_DATA_LISTED);
	}

	@Override
	public Result add(JobPosition jobPosition) {

		var result = BusinessRules.run(ExistName(jobPosition), BlankField(jobPosition));
		if (result.isSuccess()) {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult(Messages.SUCCESS_DATA_ADDED);
		}
		return result;
	}

	private Result BlankField(JobPosition jobPosition) {
		if (jobPosition.getName().isBlank()) {
			return new ErrorResult(Messages.ERROR_FIELD_IS_BLANK);
		}
		return new SuccessResult();
	}

	private Result ExistName(JobPosition jobPosition) {
		if (this.jobPositionDao.existsByName(jobPosition.getName())) {
			return new ErrorResult(Messages.JOB_POSITION_ERROR_ALREADY_EXISTS);
		}
		return new SuccessResult();
	}
}
