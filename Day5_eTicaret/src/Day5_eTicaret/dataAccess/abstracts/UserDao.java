package Day5_eTicaret.dataAccess.abstracts;

import Day5_eTicaret.entities.concretes.User;

public interface UserDao {

	void register(User user);
	void update(User user);
	void delete(User user);
	boolean login(User user);
	boolean emailExist(String email);

}
