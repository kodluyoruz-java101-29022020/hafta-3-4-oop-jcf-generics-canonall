package soru1.models.insurances;

import java.time.LocalDate;
import java.time.Period;

import soru1.enums.InsuranceDurations;

public class ResidenceInsurance extends Insurance {

	@Override
	protected double calculate(LocalDate insuranceBeginningDate, LocalDate insuranceEndingDate) {
		Period period = Period.between(insuranceBeginningDate, insuranceEndingDate);
		int insurancePeriodAsYear = period.getYears();
		double price = insurancePeriodAsYear * InsuranceDurations.RESIDENCEINSURANCE.getPriceForUnitTime();
		return price;
	}

	@Override
	protected void setInsuranceEndingDate(LocalDate insuranceBeginningDate) {
		// Residence Insurance must last for two years
		LocalDate residenceInsuranceEndingDate = insuranceBeginningDate
				.plusYears(InsuranceDurations.RESIDENCEINSURANCE.getDuration());
		super.insuranceEndingDate = residenceInsuranceEndingDate;
	}

}
