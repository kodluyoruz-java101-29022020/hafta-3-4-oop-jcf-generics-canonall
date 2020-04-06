package soru1.models.insurances;

import java.time.LocalDate;
import java.time.Period;

import soru1.enums.InsuranceDurations;

public class TravelInsurance extends Insurance {

	@Override
	protected double calculate(LocalDate insuranceBeginningDate, LocalDate insuranceEndingDate) {
		Period period = Period.between(insuranceBeginningDate, insuranceEndingDate);
		int insurancePeriodAsDay = period.getDays();
		double price = insurancePeriodAsDay * InsuranceDurations.TRAVELINSURANCE.getPriceForUnitTime();
		return price;
	}

	@Override
	protected void setInsuranceEndingDate(LocalDate insuranceBeginningDate) {
		// Healt Insurance must last for a year
		LocalDate travelInsuranceEndingDate = insuranceBeginningDate
				.plusDays(InsuranceDurations.TRAVELINSURANCE.getDuration());
		super.insuranceEndingDate = travelInsuranceEndingDate;
	}

}
