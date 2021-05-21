package Day4_Game.Interfaces;

import Day4_Game.Entities.Campaign;

public interface CampaignService {
	
	void add(Campaign campaign);
	void update(Campaign campaign,String newName,int newPrice);
	void delete(Campaign campaign);
}
