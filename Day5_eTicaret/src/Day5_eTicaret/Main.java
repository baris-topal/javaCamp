package Day5_eTicaret;

import Day5_eTicaret.business.concretes.UserManager;
import Day5_eTicaret.core.EmailSendValidation;
import Day5_eTicaret.core.EmailValidation;
import Day5_eTicaret.core.concretes.GoogleAuthManagerAdapter;
import Day5_eTicaret.dataAccess.concretes.HibernateUserDao;
import Day5_eTicaret.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		UserManager userManager = new UserManager(new HibernateUserDao(),new EmailValidation(),new EmailSendValidation(),new GoogleAuthManagerAdapter());
		
		User user = new User("Barýþ","Topal","abc123@gmail.com","abc123");

		userManager.register(user);
		//userManager.registerGoogle(user.getFirstName());
		//userManager.login(user);
		//userManager.delete(user);
		//userManager.login(user);

	}

}
