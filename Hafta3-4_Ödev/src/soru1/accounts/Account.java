package soru1.accounts;

import java.util.List;

import soru1.enums.AuthenticationStatus;
import soru1.exceptions.InvalidAuthenticationException;
import soru1.models.User;
import soru1.models.insurances.Insurance;

public abstract class Account implements Comparable<Account> {

	protected User user;
	protected List<Insurance> insuranceList;
	protected AuthenticationStatus authenticationStatus;

	public final void showUserInfo(User user) {

		if (user != null) {

			StringBuilder builder = new StringBuilder();
			builder.append(user.getFirstName());
			builder.append(" ");
			builder.append(user.getLastName());
			builder.append(" ");
			builder.append(user.geteMail());
			builder.append(" ");
			builder.append(user.getLastLoginDate());
			System.out.println(builder);

		} else {
			System.out.println("null user");
		}

	}

	public boolean login(String eMail, String password) throws InvalidAuthenticationException {

		if (eMail.equals(user.geteMail()) && password.equals(user.getPassword())) {
			authenticationStatus = AuthenticationStatus.SUCCESS;
			return authenticationStatus.getCode();
		} else {
			authenticationStatus = AuthenticationStatus.FAIL;
			throw new InvalidAuthenticationException(authenticationStatus.getMessage());
		}
	}
}
