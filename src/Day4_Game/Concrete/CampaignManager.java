package Day4_Game.Concrete;

import Day4_Game.Interfaces.CampaignService;
import Day4_Game.Entities.*;
import java.util.ArrayList;
import java.util.List;

public class CampaignManager implements CampaignService {

	List<Campaign> campaigns = new ArrayList<Campaign>();

	@Override
	public void add(Campaign campaign) {
		campaigns.add(campaign);

		System.out.println("Kampanya eklendi: " + campaign.getCampaignName() + " " + campaign.getDiscount());

	}

	@Override
	public void update(Campaign campaign, String newName, int newPrice) {
		if (campaigns.contains(campaign)) {
			campaign.setCampaignName(newName);
			campaign.setDiscount(newPrice);
			System.out.println("Kampanya güncellendi: " + campaign.getCampaignName() + " " + campaign.getDiscount());

		} else {
			System.out.println("Kampanya mevcut deðil.");
		}

	}

	@Override
	public void delete(Campaign campaign) {
		if (campaigns.contains(campaign)) {
			campaigns.remove(campaign);
			System.out.println("Kampanya silindi: " + campaign.getCampaignName() + " " + campaign.getDiscount());

		} else {
			System.out.println("Kampanya mevcut deðil.");
		}
	}

}
