package soru1.models.insurances;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import soru1.enums.InsuranceType;

public class HealthInsurance extends Insurance {

	public HealthInsurance(String insuranceName, LocalDate insuranceBeginningDate) {
		super(insuranceName, insuranceBeginningDate);
	}

	@Override
	protected double calculate(LocalDate insuranceBeginningDate, LocalDate insuranceEndingDate) {
		// Period period = Period.between(insuranceBeginningDate, insuranceEndingDate);
		int insurancePeriodAsMonth = (int) ChronoUnit.MONTHS.between(insuranceBeginningDate, insuranceEndingDate);
		double price = insurancePeriodAsMonth * InsuranceType.HEALTINSURANCE.getPriceForUnitTime();
		return price;
	}

	@Override
	protected LocalDate setInsuranceEndingDate(LocalDate insuranceBeginningDate) {
		// Healt Insurance must last for a year
		LocalDate healthInsuranceEndingDate = insuranceBeginningDate
				.plusMonths(InsuranceType.HEALTINSURANCE.getDuration());
		super.insuranceEndingDate = healthInsuranceEndingDate;
		return healthInsuranceEndingDate;
	}

}
