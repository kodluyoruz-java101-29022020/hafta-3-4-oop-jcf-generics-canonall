package soru1.managers;

import java.util.ArrayList;
import java.util.List;

import soru1.interfaces.Address;
import soru1.models.User;

public class AddressManager {

	public static void addAddress(User user, Address address) {

		if (user.getAddressList() == null) {

			List<Address> addressList = new ArrayList<Address>();
			addressList.add(address);

			user.setAddressList(addressList);

			System.out.println("Address added to your account");
		} else {

			if (isSameAddress(user, address)) {
				StringBuilder builder = new StringBuilder();
				builder.append(address.getStreet());
				builder.append(" No:");
				builder.append(address.getBuildingNo());
				builder.append(" is already defined in your address info");
				System.out.println(builder);
			} else {
				user.getAddressList().add(address);
				System.out.println("Address added to your account");
			}

		}

	}

	private static boolean isSameAddress(User user, Address address) {
		List<Address> previousAddresses = user.getAddressList();
		for (Address previousAddress : previousAddresses) {
			if (previousAddress.getStreet().equals(address.getStreet())
					&& previousAddress.getBuildingNo() == address.getBuildingNo()) {
				return true;
			}
		}
		return false;
	}

	public static void removeAddress(List<Address> adressList, int index) {
		adressList.remove(index);
	}
}
