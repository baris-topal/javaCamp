package Day4_Game.Entities;

public class Campaign {

	private int id;
	private String campaignName;
	private int discount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		if (discount > 0) {
			this.discount = discount;
		}
		else {
			this.discount = -discount;
		}
	}

}
