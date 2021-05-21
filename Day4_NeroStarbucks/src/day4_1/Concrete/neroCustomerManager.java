package day4_1.Concrete;

import day4_1.Abstract.BaseCustomerManager;
import day4_1.Abstract.CustomerCheckService;
import day4_1.Entities.Customer;

public class neroCustomerManager extends BaseCustomerManager {

	/*CustomerCheckService customerCheckService;

	public neroCustomerManager(CustomerCheckService customerCheckService) {

		this.customerCheckService = customerCheckService;

	}

	@Override
	public void save(Customer customer) throws Exception {

		if (this.customerCheckService.checkIfRealPerson(customer)) {
			super.save(customer);
		} else {
			throw new Exception("Not a valid person");
		}
	}*/
	
}
