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
		} else {
			user.getAddressList().add(address);
		}

	}

	public static void removeAddress(User user, Address address) {
		if (user.getAddressList().contains(address)) {
			user.getAddressList().remove(user.getAddressList().indexOf(address));

		}

	}
}
