package Day5_eTicaret.business.concretes;

import Day5_eTicaret.business.abstracts.UserService;
import Day5_eTicaret.core.EmailSendValidation;
import Day5_eTicaret.core.EmailValidation;
import Day5_eTicaret.core.concretes.GoogleAuthManagerAdapter;
import Day5_eTicaret.dataAccess.abstracts.UserDao;
import Day5_eTicaret.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;
	private GoogleAuthManagerAdapter googleAuthManagerAdapter;
	private EmailValidation emailValidation;
	private EmailSendValidation emailSendValidation;
	
	public UserManager(UserDao userDao,EmailValidation emailValidation,EmailSendValidation emailSendValidation, GoogleAuthManagerAdapter googleAuthManagerAdapter) {
		super();
		this.userDao = userDao;
		this.emailValidation=emailValidation;
		this.emailSendValidation=emailSendValidation;
		this.googleAuthManagerAdapter= googleAuthManagerAdapter;
	}

	@Override
	public void register(User user) {
		if(userDao.emailExist(user.getEmail())){
			System.out.println("Email sistemde kayýtlý.");
			return;
		}
		if(user.getFirstName().length()<2 && user.getLastName().length()<2) {
			System.out.println("Ad ve Soyad en az 2 karakter olmalýdýr.");
			return;
		}
		if(user.getPassword().length()<6) {
			System.out.println("Parola en az 6 karakter olmalýdýr.");
			return;
		}
		if(!emailValidation.checkEmail(user.getEmail())) {
			System.out.println("Geçersizs bir mail adresi giriniz.");
			return;
		}
		if(!emailSendValidation.emailValid(user)) {
			System.out.println("Mail doðrulanamadý.");
			return;
		}
		userDao.register(user);
	}
	
	@Override
	public void registerGoogle(String name) {
		googleAuthManagerAdapter.register(name +" isimli kullanýcý Google ile kayýt oldu.");
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public boolean login(User user) {
		return userDao.login(user);
	}


}
