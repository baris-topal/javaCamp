package Day4_Game.Concrete;

import java.util.ArrayList;
import java.util.List;

import Day4_Game.Entities.Game;
import Day4_Game.Interfaces.GameService;

public class GameManager implements GameService {

	List<Game> games = new ArrayList<Game>();

	@Override
	public void add(Game game) {

		games.add(game);
		System.out.println("Oyun eklendi: " + game.getGameName());

	}

	@Override
	public void delete(Game game) {

		if (games.contains(game)) {

			games.remove(game);
			System.out.println("Oyun silindi: " + game.getGameName());

		}

	}

}
