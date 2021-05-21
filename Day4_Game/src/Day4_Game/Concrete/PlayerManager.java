package Day4_Game.Concrete;

import java.util.ArrayList;
import java.util.List;

import Day4_Game.Entities.Player;
import Day4_Game.Interfaces.PlayerCheckService;
import Day4_Game.Interfaces.PlayerService;

public class PlayerManager implements PlayerService {

	private PlayerCheckService playerCheckService;

	List<Player> players = new ArrayList<Player>();



	public PlayerManager(PlayerCheckService playerCheckService) {
		this.playerCheckService = playerCheckService;
	}

	@Override
	public void add(Player player) {

		if (this.playerCheckService.checkPlayer(player)) {
			players.add(player);
			System.out.println("Oyuncu eklendi: " + player.getFirstName() + " " + player.getLastName());
		} else {

			System.out.println("Oyuncu doðrulanamadý.");
		}

	}

	@Override
	public void delete(Player player) {

		if (players.contains(player)) {

			players.remove(player);
			System.out.println("Oyuncu silindi: "+ player.getFirstName() + " " + player.getLastName());

		}

	}

}
