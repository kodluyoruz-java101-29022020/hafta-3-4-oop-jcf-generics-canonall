package soru1.models.insurances;

import java.time.LocalDate;
import java.time.Period;

import soru1.enums.InsuranceType;

public class ResidenceInsurance extends Insurance {

	public ResidenceInsurance(String insuranceName, LocalDate insuranceBeginningDate) {
		super(insuranceName, insuranceBeginningDate);
	}

	@Override
	protected double calculate(LocalDate insuranceBeginningDate, LocalDate insuranceEndingDate) {
		Period period = Period.between(insuranceBeginningDate, insuranceEndingDate);
		int insurancePeriodAsYear = period.getYears();
		double price = insurancePeriodAsYear * InsuranceType.RESIDENCEINSURANCE.getPriceForUnitTime();
		return price;
	}

	@Override
	protected LocalDate setInsuranceEndingDate(LocalDate insuranceBeginningDate) {
		// Residence Insurance must last for two years
		LocalDate residenceInsuranceEndingDate = insuranceBeginningDate
				.plusYears(InsuranceType.RESIDENCEINSURANCE.getDuration());
		super.insuranceEndingDate = residenceInsuranceEndingDate;
		return residenceInsuranceEndingDate;
	}

}
