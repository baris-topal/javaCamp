package com.project.hrms.business.adapters.abstracts;

import java.sql.Date;

public interface UserCheckService {

	boolean checkIfRealPerson(String identityNumber, String firstName, String lastName, Date dateOfBirth);
	
}
