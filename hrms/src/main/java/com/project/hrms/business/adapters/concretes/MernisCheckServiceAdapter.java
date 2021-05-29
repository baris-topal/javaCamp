package com.project.hrms.business.adapters.concretes;


import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.stereotype.Service;

import com.project.hrms.business.adapters.abstracts.UserCheckService;

@Service
public class MernisCheckServiceAdapter implements UserCheckService {

	@Override
	public boolean checkIfRealPerson(String identityNumber, String firstName, String lastName, Date dateOfBirth) {
		// TODO Auto-generated method stub
		MernisService.KPSPublicSoapProxy client = new MernisService.KPSPublicSoapProxy();
		boolean result = false;
		ZoneId timeZone = ZoneId.systemDefault();
        LocalDate getLocalDate = dateOfBirth.toInstant().atZone(timeZone).toLocalDate();
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(null), firstName.toUpperCase(), lastName.toLowerCase(),
					getLocalDate.getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


		
	
}
