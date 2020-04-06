package soru1.main;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import soru1.accounts.Account;
import soru1.exceptions.InvalidAuthenticationException;
import soru1.managers.AccountManager;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Account account = null;
		AccountManager accountManager = createSampleUsers();
		account = login(accountManager, account);

		while (account == null) {
			System.out.println();
			account = login(accountManager, account);
		}

		scanner.close();
		account.showUserInfo(account.getUser());

	}

	private static Account login(AccountManager accountManager, Account account) {

		String eMail, password;

		System.out.print("Please enter your e-mail:");
		eMail = scanner.nextLine();

		System.out.print("Please enter your password:");
		password = scanner.nextLine();

		try {
			account = accountManager.login(eMail, password);
		} catch (InvalidAuthenticationException e) {
			System.out.println(e.getMessage());
		}

		return account;
	}

	private static AccountManager createSampleUsers() {
		// create sample users
		Set<Account> accountSet = new TreeSet<Account>();
		AccountManager accountManager = new AccountManager(accountSet);
		accountManager.createSampleUsers();
		return accountManager;
	}

}
