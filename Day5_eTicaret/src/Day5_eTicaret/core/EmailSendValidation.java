package Day5_eTicaret.core;

import Day5_eTicaret.entities.concretes.User;

public  class EmailSendValidation {
	
	public boolean emailValid(User user) {
		
		System.out.println(user.getEmail() + " adresine do�rulama maili g�nderildi.");
		return true;
	}
}
