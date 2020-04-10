package soru1.models.insurances;

import java.time.LocalDate;
import java.time.Period;

import soru1.enums.InsuranceType;

public class CarInsurance extends Insurance {

	public CarInsurance(String insuranceName, LocalDate insuranceBeginningDate) {
		super(insuranceName, insuranceBeginningDate);
	}

	@Override
	protected double calculate(LocalDate insuranceBeginningDate, LocalDate insuranceEndingDate) {
		Period period = Period.between(insuranceBeginningDate, insuranceEndingDate);
		int insurancePeriodAsYear = period.getYears();
		double price = insurancePeriodAsYear * InsuranceType.CARINSURANCE.getPriceForUnitTime();
		return price;
	}

	@Override
	protected LocalDate setInsuranceEndingDate(LocalDate insuranceBeginningDate) {
		// Car Insurance must last for two years
		LocalDate carInsuranceEndingDate = insuranceBeginningDate.plusYears(InsuranceType.CARINSURANCE.getDuration());
		super.insuranceEndingDate = carInsuranceEndingDate;
		return carInsuranceEndingDate;
	}

}
