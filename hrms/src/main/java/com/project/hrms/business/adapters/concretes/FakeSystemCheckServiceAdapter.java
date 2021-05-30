package com.project.hrms.business.adapters.concretes;

import org.springframework.stereotype.Service;

@Service
public class FakeSystemCheckServiceAdapter {
	
	public boolean systemVerified() {
		return true;
	}
}
