package soru1.models.insurances;

import java.time.LocalDate;
import java.time.Period;

import soru1.enums.InsuranceDurations;

public class HealthInsurance extends Insurance {

	@Override
	protected double calculate(LocalDate insuranceBeginningDate, LocalDate insuranceEndingDate) {
		Period period = Period.between(insuranceBeginningDate, insuranceEndingDate);
		int insurancePeriodAsMonth = period.getMonths();
		double price = insurancePeriodAsMonth * InsuranceDurations.HEALTINSURANCE.getPriceForUnitTime();
		return price;
	}

	@Override
	protected void setInsuranceEndingDate(LocalDate insuranceBeginningDate) {
		// Healt Insurance must last for a year
		LocalDate healthInsuranceEndingDate = insuranceBeginningDate
				.plusMonths(InsuranceDurations.HEALTINSURANCE.getDuration());
		super.insuranceEndingDate = healthInsuranceEndingDate;
	}

}
