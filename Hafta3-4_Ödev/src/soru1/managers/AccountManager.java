package soru1.managers;

import java.util.Iterator;
import java.util.Set;

import soru1.accounts.Account;
import soru1.accounts.Enterprise;
import soru1.accounts.Individual;
import soru1.addresses.BusinessAddress;
import soru1.addresses.HomeAddress;
import soru1.enums.AuthenticationStatus;
import soru1.exceptions.InvalidAuthenticationException;
import soru1.models.User;

public class AccountManager {

	public Set<Account> accountSet;

	public AccountManager(Set<Account> accountSet) {
		this.accountSet = accountSet;
	}

	public Account login(String eMail, String password) throws InvalidAuthenticationException {

		Iterator<Account> iterator = accountSet.iterator();

		// try {
		while (iterator.hasNext()) {
			Account account = iterator.next();
			if (account.login(account, eMail, password)) {
				return account;
			}
		}
		// } catch (InvalidAuthenticationException e) {
		// System.out.println(e.getMessage());
		// }
		throw new InvalidAuthenticationException(AuthenticationStatus.FAIL.getMessage());
	}

	public void createSampleUsers() {

		User user1 = new User("Can", "Önal", "onalcan20@gmail.com", "unemployed", "201196", 24);
		AddressManager.addAddress(user1, new HomeAddress("Barbaros Hayrettin Sokak", 22));
		AddressManager.addAddress(user1, new HomeAddress("Ataköy sokak", 12));
		Account account1 = new Individual(user1);
		this.accountSet.add(account1);

		User user2 = new User("Vicky", "Shapkina", "vicky@gmail.com", "student", "123456", 25);
		AddressManager.addAddress(user2, new HomeAddress("Russian Street", 8));
		Account account2 = new Individual(user2);
		this.accountSet.add(account2);

		User user3 = new User("LeBron", "James", "lbj@gmail.com", "player", "2016", 35);
		AddressManager.addAddress(user3, new BusinessAddress("LA Lakers", "California", 23));
		Account account3 = new Enterprise(user3);
		this.accountSet.add(account3);

	}

}
