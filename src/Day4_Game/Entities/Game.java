package Day4_Game.Entities;

public class Game {

	private int id;
	private String gameName;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price < 0) {
			this.price = -price;
		}
		else {
			this.price = price;
		}
	}

}
