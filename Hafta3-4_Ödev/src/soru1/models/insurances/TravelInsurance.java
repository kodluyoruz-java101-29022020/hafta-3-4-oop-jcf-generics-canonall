package soru1.models.insurances;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import soru1.enums.InsuranceType;

public class TravelInsurance extends Insurance {

	public TravelInsurance(String insuranceName, LocalDate insuranceBeginningDate) {
		super(insuranceName, insuranceBeginningDate);
	}

	@Override
	protected double calculate(LocalDate insuranceBeginningDate, LocalDate insuranceEndingDate) {
		int insurancePeriodAsDay = (int) ChronoUnit.DAYS.between(insuranceBeginningDate, insuranceEndingDate);
		double price = insurancePeriodAsDay * InsuranceType.TRAVELINSURANCE.getPriceForUnitTime();
		return price;
	}

	@Override
	protected LocalDate setInsuranceEndingDate(LocalDate insuranceBeginningDate) {
		// Healt Insurance must last for a year
		LocalDate travelInsuranceEndingDate = insuranceBeginningDate
				.plusDays(InsuranceType.TRAVELINSURANCE.getDuration());
		super.insuranceEndingDate = travelInsuranceEndingDate;
		return travelInsuranceEndingDate;
	}

}
