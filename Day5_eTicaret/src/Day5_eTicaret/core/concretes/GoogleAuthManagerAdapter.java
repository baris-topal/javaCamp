package Day5_eTicaret.core.concretes;

import Day5_eTicaret.GoogleAuth.GoogleAuthManager;
import Day5_eTicaret.core.abstracts.AuthService;

public class GoogleAuthManagerAdapter implements AuthService{

	GoogleAuthManager googleAuthManager = new GoogleAuthManager();

	@Override
	public void register(String message) {
		googleAuthManager.register(message);	
		
	}

	@Override
	public void login(String message) {
		googleAuthManager.login(message);		
		
	}

}
