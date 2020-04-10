package soru1.models.insurances;

import java.time.LocalDate;

public abstract class Insurance {

	protected String insuranceName;
	protected double insurancePrice;
	protected LocalDate insuranceBeginningDate;
	protected LocalDate insuranceEndingDate;
	protected double totalPrice;

	public Insurance(String insuranceName, LocalDate insuranceBeginningDate) {
		this.insuranceName = insuranceName;
		this.insuranceBeginningDate = insuranceBeginningDate;
		this.insuranceEndingDate = setInsuranceEndingDate(insuranceBeginningDate);
		this.insurancePrice = calculate(this.insuranceBeginningDate, this.insuranceEndingDate);
	}

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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	protected abstract LocalDate setInsuranceEndingDate(LocalDate insuranceBeginningDate);

	protected abstract double calculate(LocalDate insuranceBeginningDate, LocalDate insuranceEndingDate);
}
