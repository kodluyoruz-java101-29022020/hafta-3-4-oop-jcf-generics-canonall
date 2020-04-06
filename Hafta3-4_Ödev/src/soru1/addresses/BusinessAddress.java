package soru1.addresses;

import java.util.List;

import soru1.interfaces.Address;

public class BusinessAddress implements Address {

	private String businessName;
	private String street;
	private int buildingNo;

	public BusinessAddress(String businessName, String street, int buildingNo) {
		super();
		this.businessName = businessName;
		this.street = street;
		this.buildingNo = buildingNo;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
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
		String addressString = this.getBusinessName();
		return addressString;
	}

}
