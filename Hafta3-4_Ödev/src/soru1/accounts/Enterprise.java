package soru1.accounts;

import java.util.List;

import soru1.models.User;
import soru1.models.insurances.Insurance;

public class Enterprise extends Account {

	public Enterprise(User user, List<Insurance> insuranceList) {
		super(user, insuranceList);

	}

	@Override
	protected double addProfit(double insurancePrice) {
		// %25 profit for individual insurance policies
		double totalPrice;
		totalPrice = insurancePrice + (insurancePrice * 0.25);
		return totalPrice;
	}

	@Override
	public int compareTo(Account o) {
		return this.getUser().getLastName().compareTo(o.getUser().getLastName());
	}

}
