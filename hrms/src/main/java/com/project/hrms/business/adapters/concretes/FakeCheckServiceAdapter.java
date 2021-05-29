package com.project.hrms.business.adapters.concretes;


import java.sql.Date;
import org.springframework.stereotype.Service;
import com.project.hrms.business.adapters.abstracts.UserCheckService;

@Service
public class FakeCheckServiceAdapter implements UserCheckService{
	
	@Override
	public boolean checkIfRealPerson(String identityNumber, String firstName, String lastName, Date dateOfBirth) {
		return true;
	}

}
