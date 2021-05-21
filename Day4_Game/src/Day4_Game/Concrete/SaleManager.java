package Day4_Game.Concrete;

import Day4_Game.Entities.Campaign;
import Day4_Game.Entities.Game;
import Day4_Game.Entities.Player;
import Day4_Game.Interfaces.SaleService;

public class SaleManager implements SaleService{

	@Override
	public void sale(Player player, Game game) {
		
		System.out.println(game.getGameName() +" oyunu "+ player.getFirstName()+" tarafýndan "+ game.getPrice() +" fiyata alýndý.");
		
	}

	@Override
	public void sale(Player player, Game game, Campaign campaign) {
		
		double newPrice = game.getPrice()-(game.getPrice()*((double)campaign.getDiscount()/100));
		System.out.println(game.getGameName() +" oyunu "+ player.getFirstName()+" tarafýndan "+ newPrice +" fiyata alýndý.");

		
		
	}

}
