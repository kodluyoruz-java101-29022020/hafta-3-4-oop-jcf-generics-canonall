package soru1.accounts;

import soru1.models.User;

public class Individual extends Account {

	public Individual(User user) {
		super(user);

	}

	@Override
	protected void addInsurance() {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(Account o) {
		return this.getUser().getLastName().compareTo(o.getUser().getLastName());
	}

}
