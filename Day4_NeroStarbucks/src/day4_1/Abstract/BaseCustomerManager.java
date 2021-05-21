package day4_1.Abstract;

import day4_1.Entities.Customer;

public abstract class BaseCustomerManager implements CustomerService {

	public void save(Customer customer) throws Exception {

		System.out.println("Saved to DB: " + customer.firstName + " " + customer.lastName);

	}

}
