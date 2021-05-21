package day4_1;

import java.time.LocalDate;

import day4_1.Abstract.BaseCustomerManager;
import day4_1.Adapters.MernisServiceAdapter;
import day4_1.Concrete.neroCustomerManager;
import day4_1.Concrete.starbucksCustomerManager;
import day4_1.Entities.Customer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BaseCustomerManager customerManager = new starbucksCustomerManager(new MernisServiceAdapter());
		Customer customer = new Customer();
		customer.id=1;
		customer.firstName="AD";
		customer.lastName="SOYAD";
		customer.dateOfBirth=LocalDate.of(2021, 5, 3);
		customer.nationalityId="11111111111";
		customerManager.save(customer);
		
		BaseCustomerManager customerManager1 = new neroCustomerManager();
		customerManager1.save(customer);

	}

}
