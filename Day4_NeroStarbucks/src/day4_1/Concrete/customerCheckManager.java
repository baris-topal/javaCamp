package day4_1.Concrete;

import day4_1.Abstract.CustomerCheckService;
import day4_1.Entities.Customer;

public class customerCheckManager implements CustomerCheckService {

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		
		return true;
		
	}

	
}
