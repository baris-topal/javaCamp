package day4_1.Adapters;
import MernisService.KPSPublicSoapProxy;
import day4_1.Abstract.CustomerCheckService;
import day4_1.Entities.Customer;
import java.rmi.RemoteException;


public class MernisServiceAdapter implements CustomerCheckService{

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		try {
			return client.TCKimlikNoDogrula(Long.parseLong(customer.nationalityId), customer.firstName.toUpperCase(), customer.lastName.toUpperCase(), customer.dateOfBirth.getYear());
		} catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}
