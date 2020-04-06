package soru1.addresses;

import java.util.List;

import soru1.interfaces.Address;

public class HomeAddress implements Address {

	private String street;
	private int buildingNo;

	public HomeAddress(String street, int buildingNo) {
		super();
		this.street = street;
		this.buildingNo = buildingNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}

	@Override
	public void showAddress(List<Address> addressList) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		String addressString = this.getStreet();
		return addressString;
	}

}
