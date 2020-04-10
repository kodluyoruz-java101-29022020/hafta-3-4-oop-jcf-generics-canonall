package soru1.accounts;

import java.util.ArrayList;
import java.util.List;

import soru1.models.User;
import soru1.models.insurances.Insurance;

public class Enterprise extends Account {

	public Enterprise(User user, List<Insurance> insuranceList) {
		super(user, insuranceList);

	}

	@Override
	public boolean addInsurance(Account account, Insurance insurance) {
		double finalPrice;
		if (account.getInsuranceList().isEmpty()) {
			List<Insurance> insuranceList = new ArrayList<Insurance>();

			finalPrice = addProfit(insurance.getInsurancePrice());
			insurance.setTotalPrice(finalPrice);

			insuranceList.add(insurance);
			account.setInsuranceList(insuranceList);
			return true;

		} else {
			if (isSameInsurance(account, insurance)) {
				return false;
			} else {
				finalPrice = addProfit(insurance.getInsurancePrice());
				insurance.setTotalPrice(finalPrice);
				account.getInsuranceList().add(insurance);
				return true;
			}

		}

	}

	@Override
	protected boolean isSameInsurance(Account account, Insurance insurance) {
		List<Insurance> previousInsurances = account.getInsuranceList();
		for (Insurance previousInsurance : previousInsurances) {
			if (previousInsurance.getInsuranceName().equals(insurance.getInsuranceName())) {
				return true;
			}
		}
		return false;

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
