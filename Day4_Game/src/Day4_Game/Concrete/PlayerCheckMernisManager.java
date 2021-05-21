package Day4_Game.Concrete;

import java.rmi.RemoteException;

import Day4_Game.Entities.Player;
import Day4_Game.Interfaces.PlayerCheckService;
import Mernis.KPSPublicSoapProxy;

public class PlayerCheckMernisManager implements PlayerCheckService {

	@Override
	public boolean checkPlayer(Player player) {

		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		try {
			return client.TCKimlikNoDogrula(Long.parseLong(player.getNationalityId()),
					player.getFirstName().toUpperCase(), player.getLastName().toUpperCase(),
					player.getDateOfBirth().getYear());
		} catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
