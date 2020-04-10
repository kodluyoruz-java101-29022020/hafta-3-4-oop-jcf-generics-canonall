package soru1.main;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import soru1.accounts.Account;
import soru1.addresses.BusinessAddress;
import soru1.addresses.HomeAddress;
import soru1.exceptions.InvalidAuthenticationException;
import soru1.interfaces.Address;
import soru1.managers.AccountManager;
import soru1.managers.AddressManager;
import soru1.models.insurances.CarInsurance;
import soru1.models.insurances.HealthInsurance;
import soru1.models.insurances.Insurance;
import soru1.models.insurances.ResidenceInsurance;
import soru1.models.insurances.TravelInsurance;
import soru1.util.Util;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static AccountManager accountManager = createSampleUsers();

	public static void main(String[] args) {

		Account account = null;
		account = loginLoop(account);
		callMenu(account);

	}

	private static void callMenu(Account account) {

		byte key;

		System.out.println("\n************MENU************");
		System.out.println("1-Show user's info");
		System.out.println("2-Show user's insurance");
		System.out.println("3-Add insurance");
		System.out.println("4-Add new address");
		System.out.println("5-Remove address");
		System.out.println("6-Log out");

		System.out.print("Your operation:");
		key = scanner.nextByte();
		// to solve the issue with scanner scanner.nextLine is needed
		// https://coderanch.com/t/463484/java/explanation-getter-setter-methods-difference#2074932
		scanner.nextLine();

		switch (key) {
		case 1:
			account.showUserInfo(account.getUser());
			callMenu(account);
			break;
		case 2:
			account.showInsurance(account.getInsuranceList());
			callMenu(account);
			break;
		case 3:
			addInsurance(account);
			callMenu(account);
			break;
		case 4:
			addAddress(account);
			callMenu(account);
			break;
		case 5:
			removeAddress(account);
			callMenu(account);
			break;
		case 6:
			System.out.println("\nLOGOUT SUCCESSFUL");
			account = null;
			account = loginLoop(account);
			callMenu(account);
			break;
		default:
			System.out.println("Please select a valid operation number!\n");
			callMenu(account);
		}
	}

	private static void removeAddress(Account account) {
		byte key;

		System.out.println();
		account.showUserAddress(account.getUser());

		if (!account.getUser().getAddressList().isEmpty()) {
			System.out.print("\nPlease select the address number to remove from your account:");
			key = scanner.nextByte();

			if (key > account.getUser().getAddressList().size()) {
				System.out.println("\nPlease select a valid address");
			} else {
				AddressManager.removeAddress(account.getUser().getAddressList(), key - 1);
				System.out.println("\nAddress removed");
			}
		}
	}

	private static Account loginLoop(Account account) {
		account = login(accountManager, account);

		while (account == null) {
			System.out.println();
			account = login(accountManager, account);
		}
		System.out.println("\nLOGIN SUCCESSFUL");
		return account;
	}

	private static Account login(AccountManager accountManager, Account account) {
		String eMail, password;

		System.out.print("\nPlease enter your e-mail:");
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

	private static void addInsurance(Account account) {
		// double productPrice;

		Insurance insurance = getInsuranceType();
		while (insurance == null) {
			insurance = getInsuranceType();
		}

		if (account.addInsurance(account, insurance)) {
			getPayment(insurance, account);
		} else {
			System.out.println("\nYou already have " + insurance.getInsuranceName() + " in your account!");
		}
	}

	private static void getPayment(Insurance insurance, Account account) {
		StringBuilder builder = new StringBuilder();
		builder.append("\n************PAYMENT************");
		builder.append("\nPayment for ");
		builder.append(account.getUser().getFirstName());
		builder.append(" ");
		builder.append(account.getUser().getLastName());
		builder.append("'s ");
		builder.append(insurance.getInsuranceName());
		builder.append("\nPrice:");
		builder.append(insurance.getTotalPrice());
		builder.append(" TL");
		builder.append("\nInsurance added to your account");
		System.out.println(builder);

	}

	private static Insurance getInsuranceType() {
		byte key;
		System.out.println("\n*********ADD INSURANCE*********");
		System.out.println("1-Health Insurance");
		System.out.println("2-Residence Insurance");
		System.out.println("3-Car Insurance");
		System.out.println("4-Travel Insurance");
		System.out.print("Please select an insurance in order to add your account:");

		key = scanner.nextByte();
		scanner.nextLine();
		switch (key) {
		case 1:
			return new HealthInsurance("Health Insurance", Util.getCurrentDate());
		case 2:
			return new ResidenceInsurance("Residence Insurance", Util.getCurrentDate());
		case 3:
			return new CarInsurance("Car Insurance", Util.getCurrentDate());
		case 4:
			return new TravelInsurance("Travel Insurance", Util.getCurrentDate());
		default:
			System.out.println("\nPlease selecet a valid insurance");
			return null;
		}
	}

	private static void addAddress(Account account) {

		byte key;

		System.out.println("\n************NEW ADDRESS************");
		System.out.println("1-New home address");
		System.out.println("2-New business address");
		System.out.print("Please select your address type:");
		key = scanner.nextByte();

		scanner.nextLine();

		switch (key) {
		case 1:
			Address newHomeAddress = getHomeAddressInfo();
			AddressManager.addAddress(account.getUser(), newHomeAddress);
			break;
		case 2:
			Address newBusinessAddress = getBusinessAddressInfo();
			AddressManager.addAddress(account.getUser(), newBusinessAddress);
			break;
		default:
			System.out.println("Please select a valid operation number!\n");
			addAddress(account);
			break;
		}

	}

	private static Address getHomeAddressInfo() {
		String addressName, streetName;
		int buildingNo;

		System.out.print("\nAdress name:");
		addressName = scanner.nextLine();

		System.out.print("Street name:");
		streetName = scanner.nextLine();

		System.out.print("Building no:");
		buildingNo = scanner.nextInt();
		scanner.nextLine();

		Address homeAddress = new HomeAddress(addressName, streetName, buildingNo);
		return homeAddress;
	}

	private static Address getBusinessAddressInfo() {
		String streetName, businessName;
		int buildingNo;

		System.out.print("\nBusiness name:");
		businessName = scanner.nextLine();

		System.out.print("Street name:");
		streetName = scanner.nextLine();

		System.out.print("Building no:");
		buildingNo = scanner.nextInt();
		scanner.nextLine();

		Address businessAddress = new BusinessAddress(businessName, streetName, buildingNo);
		return businessAddress;
	}

	private static AccountManager createSampleUsers() {
		// create sample users for project
		Set<Account> accountSet = new TreeSet<Account>();
		AccountManager accountManager = new AccountManager(accountSet);
		accountManager.createSampleUsers();
		return accountManager;
	}

}
