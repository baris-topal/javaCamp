package Day4_Game.Concrete;



import Day4_Game.Entities.Player;
import Day4_Game.Interfaces.PlayerCheckService;


public class PlayerCheckFakeManager implements PlayerCheckService{

	@Override
	public boolean checkPlayer(Player player) {
		
		return true;
		
	}

}
