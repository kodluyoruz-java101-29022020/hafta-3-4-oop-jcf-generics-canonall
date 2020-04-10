package soru1.accounts;

import java.util.List;

import soru1.enums.AuthenticationStatus;
import soru1.models.User;
import soru1.models.insurances.Insurance;
import soru1.util.Util;

public abstract class Account implements Comparable<Account> {

	public Account(User user, List<Insurance> insuranceList) {
		super();
		this.user = user;
		this.insuranceList = insuranceList;
	}

	protected User user;
	protected List<Insurance> insuranceList;
	protected AuthenticationStatus authenticationStatus;

	public AuthenticationStatus getAuthenticationStatus() {
		return authenticationStatus;
	}

	public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
		this.authenticationStatus = authenticationStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Insurance> getInsuranceList() {
		return insuranceList;
	}

	public void setInsuranceList(List<Insurance> insuranceList) {
		this.insuranceList = insuranceList;
	}

	public final void showUserInfo(User user) {

		if (user != null) {

			StringBuilder builder = new StringBuilder();
			builder.append("\n*********USER INFO*********");
			builder.append("\n");
			builder.append("Name: ");
			builder.append(user.getFirstName());
			builder.append(" ");
			builder.append(user.getLastName());
			builder.append("\n");
			builder.append("Mail: ");
			builder.append(user.geteMail());
			builder.append("\n");
			builder.append("Age : ");
			builder.append(user.getAge());
			builder.append("\n");
			builder.append("Last login date:");
			builder.append(Util.dateFormatter(user.getLastLoginDate()));
			System.out.println(builder);

		} else {
			System.out.println("null user");
		}

	}

	public final void showInsurance(List<Insurance> insuranceList) {

		if (!insuranceList.isEmpty()) {
			for (Insurance insurance : insuranceList) {
				StringBuilder builder = new StringBuilder();
				builder.append("\n*********INSURANCE INFO*********");
				builder.append("\n");
				builder.append(insurance.getInsuranceName());
				builder.append("\nPrice:");
				builder.append(insurance.getTotalPrice());
				builder.append("\nBegins:");
				builder.append(Util.dateFormatter(insurance.getInsuranceBeginningDate()));
				builder.append("\nEnds:");
				builder.append(Util.dateFormatter(insurance.getInsuranceEndingDate()));
				System.out.println(builder);
			}
		} else {
			System.out.println("\n*********INSURANCE INFO*********");
			System.out.println("\nThere is no item to show");
		}

	}

	public boolean login(Account account, String eMail, String password) {

		if (eMail.equals(account.getUser().geteMail()) && password.equals(account.getUser().getPassword())) {
			authenticationStatus = AuthenticationStatus.SUCCESS;
			account.getUser().setLastLoginDate(Util.getCurrentDate());
		} else {
			authenticationStatus = AuthenticationStatus.FAIL;
		}
		return authenticationStatus.getCode();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authenticationStatus == null) ? 0 : authenticationStatus.hashCode());
		result = prime * result + ((insuranceList == null) ? 0 : insuranceList.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Account other = (Account) obj;
		if (authenticationStatus != other.authenticationStatus) {
			return false;
		}
		if (insuranceList == null) {
			if (other.insuranceList != null) {
				return false;
			}
		} else if (!insuranceList.equals(other.insuranceList)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

	public abstract boolean addInsurance(Account account, Insurance insurance);

	protected abstract double addProfit(double insurancePrice);

	protected abstract boolean isSameInsurance(Account account, Insurance insurance);

}
