package Day5_eTicaret.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import Day5_eTicaret.dataAccess.abstracts.UserDao;
import Day5_eTicaret.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	List<User> users = new ArrayList<User>();

	@Override
	public void register(User user) {

		System.out.println("Kullan�c� kay�t oldu: " + user.getFirstName() + " " + user.getLastName());
		users.add(user);
	}

	@Override
	public void update(User user) {

		if (users.contains(user)) {

			System.out.println("Kullan�c� g�ncellendi.");
		} else {
			System.out.println("Kullan�c� bulunamad�.");
		}

	}

	@Override
	public void delete(User user) {

		if (users.contains(user)) {

			System.out.println("Kullan�c� silindi.");
			users.remove(user);
		} else {
			System.out.println("Kullan�c� bulunamad�.");
		}

	}

	@Override
	public boolean login(User user) {
		
		for (User _user : users) {
			if(user.getEmail()==_user.getEmail() && user.getPassword()==_user.getPassword()) {
				System.out.println("Giri� yap�ld�.");
				return true;
			}
		}
		System.out.println("Kullan�c� kay�tl� de�il.");
		return false;	

	}

	@Override
	public boolean emailExist(String email) {
		
		for (User user : users) {
			
			if(user.getEmail()==email) {
				return true;
			}
		}
		return false;
	}

}
