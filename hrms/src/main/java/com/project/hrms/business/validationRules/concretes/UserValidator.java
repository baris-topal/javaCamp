package com.project.hrms.business.validationRules.concretes;

import org.springframework.stereotype.Component;

import com.project.hrms.business.adapters.concretes.FakeEmailCheckServiceAdapter;
import com.project.hrms.business.constants.Messages;
import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.entities.concretes.User;

@Component
public class UserValidator {
	
	private FakeEmailCheckServiceAdapter fakeEmailCheckServiceAdapter;

	public UserValidator(FakeEmailCheckServiceAdapter fakeEmailCheckServiceAdapter) {
		super();
		this.fakeEmailCheckServiceAdapter = fakeEmailCheckServiceAdapter;
	}
	
	public Result  BlankField(User user) {
		if (user.getEmail().isBlank() || user.getPassword().isBlank() || user.getConfirmedPassword().isBlank()) {
			return new ErrorResult(Messages.ERROR_FIELD_IS_BLANK);
		}
		return new SuccessResult();
	}
	public Result MatchPassword(User user) {
		if (!user.getPassword().equals(user.getConfirmedPassword())) {
			return new ErrorResult(Messages.USER_ERROR_MATCH_PASSWORD);
		}
		return new SuccessResult();
	}
	public Result CheckEmail(User user)  {
		if (!fakeEmailCheckServiceAdapter.sendMail()) {
			return new ErrorResult();
		}
		user.setEmailVerified(true);
		return new SuccessResult();
	}
}
