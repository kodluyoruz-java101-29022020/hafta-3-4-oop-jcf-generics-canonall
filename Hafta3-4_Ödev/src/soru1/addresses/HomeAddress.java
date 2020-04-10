package soru1.addresses;

import soru1.interfaces.Address;

public class HomeAddress implements Address {

	private String addressName;
	private String street;
	private int buildingNo;

	public HomeAddress(String addressName, String street, int buildingNo) {
		super();
		this.addressName = addressName;
		this.street = street;
		this.buildingNo = buildingNo;
	}

	@Override
	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	@Override
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public int getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}

	@Override
	public String toString() {
		String addressString = this.getStreet();
		return addressString;
	}

}
