package soru1.models.insurances;

import java.time.LocalDate;
import java.time.Period;

import soru1.enums.InsuranceDurations;

public class CarInsurance extends Insurance {

	@Override
	protected double calculate(LocalDate insuranceBeginningDate, LocalDate insuranceEndingDate) {
		Period period = Period.between(insuranceBeginningDate, insuranceEndingDate);
		int insurancePeriodAsYear = period.getYears();
		double price = insurancePeriodAsYear * InsuranceDurations.CARINSURANCE.getPriceForUnitTime();
		return price;
	}

	@Override
	protected void setInsuranceEndingDate(LocalDate insuranceBeginningDate) {
		// Car Insurance must last for two years
		LocalDate carInsuranceEndingDate = insuranceBeginningDate
				.plusYears(InsuranceDurations.CARINSURANCE.getDuration());
		super.insuranceEndingDate = carInsuranceEndingDate;
	}

}
