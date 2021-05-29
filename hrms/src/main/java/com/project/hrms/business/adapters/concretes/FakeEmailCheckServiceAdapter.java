package com.project.hrms.business.adapters.concretes;


import org.springframework.stereotype.Service;

@Service
public class FakeEmailCheckServiceAdapter {

	public boolean sendMail() {
		return true;
	}
	
}
