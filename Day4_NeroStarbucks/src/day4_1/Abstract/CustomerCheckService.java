package day4_1.Abstract;

import day4_1.Entities.Customer;

public interface CustomerCheckService {

	boolean checkIfRealPerson(Customer customer);
}
