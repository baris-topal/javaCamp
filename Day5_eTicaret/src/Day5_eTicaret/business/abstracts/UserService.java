package Day5_eTicaret.business.abstracts;

import Day5_eTicaret.entities.concretes.User;

public interface UserService {
 
	void register(User user);
	void registerGoogle(String name);
	void update(User user);
	void delete(User user);
	boolean login(User user);
}
