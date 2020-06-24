package de.telekom.mayo.bonus.service;

import org.springframework.stereotype.Service;

@Service
public class AvailableCoinsService {
	
	
	public int calculateAvailableCoins (Long co2All, int spentCoins) {
		Long factor = co2All/1000;
		int sumCoins = factor.intValue();
		int availableCoins = sumCoins - spentCoins;
		return availableCoins;
	}

}
