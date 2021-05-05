package Day4_Game.Concrete;


import java.rmi.RemoteException;

import Day4_Game.Entities.Player;
import Day4_Game.Interfaces.PlayerCheckService;
import Mernis.KPSPublicSoapProxy;


public class PlayerCheckFakeManager implements PlayerCheckService{

	@Override
	public boolean checkPlayer(Player player) {
		
		return true;
		
	}

}
