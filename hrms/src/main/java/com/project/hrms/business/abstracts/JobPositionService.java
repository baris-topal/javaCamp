package com.project.hrms.business.abstracts;

import java.util.List;

import com.project.hrms.core.utilities.results.*;
import com.project.hrms.entities.concretes.JobPosition;


public interface JobPositionService {

	DataResult<List<JobPosition>> getAll();
    Result add(JobPosition jobPosition);

}
