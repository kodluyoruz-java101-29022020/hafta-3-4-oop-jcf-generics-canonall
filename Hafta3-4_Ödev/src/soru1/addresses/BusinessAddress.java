package soru1.addresses;

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

	@Override
	public String getAddressName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
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

}
