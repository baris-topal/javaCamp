package Day4_Game;


import java.time.LocalDate;

import Day4_Game.Concrete.*;
import Day4_Game.Entities.*;

public class Main {

	public static void main(String[] args) {
		
		Player player = new Player();
		player.setId(1);
		player.setFirstName("Ad");
		player.setLastName("Soyad");
		player.setNationalityId("11111111111");
		LocalDate dateOfBirth=LocalDate.of(2021, 5, 3);
		player.setDateOfBirth(dateOfBirth);
		
		PlayerManager playerManager = new PlayerManager(new PlayerCheckFakeManager());
		playerManager.add(player);
		
		Game game = new Game();
		game.setId(1);
		game.setGameName("FIFA");
		game.setPrice(400.00);
		
		GameManager gameManager = new GameManager();
		gameManager.add(game);
		
		Campaign campaign = new Campaign();
		campaign.setId(1);
		campaign.setCampaignName("Pazar Ýndirimi");
		campaign.setDiscount(20);
		
		CampaignManager campaignManager = new CampaignManager(); 
		campaignManager.add(campaign);
		campaignManager.update(campaign, "Yýlsonu Ýndirimi", 50);
		
		SaleManager saleManager = new SaleManager();
		saleManager.sale(player, game);
		saleManager.sale(player, game, campaign);
		
		playerManager.delete(player);
		gameManager.delete(game);
		campaignManager.delete(campaign);
		

		
	}

}
