package soru1.managers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import soru1.accounts.Account;
import soru1.accounts.Enterprise;
import soru1.accounts.Individual;
import soru1.addresses.BusinessAddress;
import soru1.addresses.HomeAddress;
import soru1.enums.AuthenticationStatus;
import soru1.exceptions.InvalidAuthenticationException;
import soru1.interfaces.Address;
import soru1.models.User;
import soru1.models.insurances.Insurance;

public class AccountManager {

	public Set<Account> accountSet;

	public AccountManager(Set<Account> accountSet) {
		this.accountSet = accountSet;
	}

	public Account login(String eMail, String password) throws InvalidAuthenticationException {

		Iterator<Account> iterator = accountSet.iterator();

		while (iterator.hasNext()) {
			Account account = iterator.next();
			if (account.login(account, eMail, password)) {
				return account;
			}
		}
		throw new InvalidAuthenticationException(AuthenticationStatus.FAIL.getMessage());
	}

	public void createSampleUsers() {
		List<Address> user1Addresses = new ArrayList<Address>();
		User user1 = new User("Can", "Önal", "onalcan20@gmail.com", "unemployed", "201196", 24, user1Addresses);
		AddressManager.addAddress(user1, new HomeAddress("Barbaros Hayrettin Sokak", 22));
		AddressManager.addAddress(user1, new HomeAddress("Ataköy sokak", 12));
		Account account1 = new Individual(user1, new ArrayList<Insurance>());
		this.accountSet.add(account1);

		List<Address> user2Addresses = new ArrayList<Address>();
		User user2 = new User("Vicky", "Shapkina", "vicky@gmail.com", "student", "123456", 25, user2Addresses);
		AddressManager.addAddress(user2, new HomeAddress("Russian Street", 8));
		Account account2 = new Individual(user2, new ArrayList<Insurance>());
		this.accountSet.add(account2);

		List<Address> user3Addresses = new ArrayList<Address>();
		User user3 = new User("LeBron", "James", "lbj@gmail.com", "player", "2016", 35, user3Addresses);
		AddressManager.addAddress(user3, new BusinessAddress("LA Lakers", "California", 23));
		Account account3 = new Enterprise(user3, new ArrayList<Insurance>());
		this.accountSet.add(account3);

	}

}
