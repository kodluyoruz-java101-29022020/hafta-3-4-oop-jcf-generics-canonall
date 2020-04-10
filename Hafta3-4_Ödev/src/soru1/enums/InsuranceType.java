package soru1.enums;

public enum InsuranceType {
	// HEALTINSURANCE is 50 TL per month
	// RESIDENCEINSURANCE is 2500 TL per year
	// CARINSURANCE is 1250 TL per year
	// TRAVELINSURANCE is 3.50 TL per day
	HEALTINSURANCE((byte) 12, 50), RESIDENCEINSURANCE((byte) 5, 2500), CARINSURANCE((byte) 2, 1250),
	TRAVELINSURANCE((byte) 30, 3.5);

	private final byte duration;
	private final double priceForUnitTime;

	private InsuranceType(byte duration, double priceForUnitTime) {
		this.duration = duration;
		this.priceForUnitTime = priceForUnitTime;
	}

	public byte getDuration() {
		return duration;
	}

	public double getPriceForUnitTime() {
		return priceForUnitTime;
	}

}
