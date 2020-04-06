package soru1.models.insurances;

import java.time.LocalDate;

public abstract class Insurance {

	protected String insuranceName;
	protected double insurancePrice;
	protected LocalDate insuranceBeginningDate;
	protected LocalDate insuranceEndingDate;

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public double getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public LocalDate getInsuranceBeginningDate() {
		return insuranceBeginningDate;
	}

	public void setInsuranceBeginningDate(LocalDate insuranceBeginningDate) {
		this.insuranceBeginningDate = insuranceBeginningDate;
	}

	public LocalDate getInsuranceEndingDate() {
		return insuranceEndingDate;
	}

	protected abstract void setInsuranceEndingDate(LocalDate insuranceBeginningDate);

	protected abstract double calculate(LocalDate insuranceBeginningDate, LocalDate insuranceEndingDate);
}
