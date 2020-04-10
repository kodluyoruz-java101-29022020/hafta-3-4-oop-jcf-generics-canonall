package soru1.accounts;

import java.util.List;

import soru1.models.User;
import soru1.models.insurances.Insurance;

public class Individual extends Account {

	public Individual(User user, List<Insurance> insuranceList) {
		super(user, insuranceList);

	}

	@Override
	protected double addProfit(double insurancePrice) {
		// %10 profit for individual insurance policies
		double totalPrice;
		totalPrice = insurancePrice + (insurancePrice * 0.1);
		return totalPrice;
	}

	@Override
	public int compareTo(Account o) {
		return this.getUser().getLastName().compareTo(o.getUser().getLastName());
	}

}
