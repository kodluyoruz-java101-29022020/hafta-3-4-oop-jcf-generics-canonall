package soru1.models.insurances;

import java.util.Date;

public abstract class Insurance {

	protected String insuranceName;
	protected double insurancePrice;
	protected Date insuranceBeginningDate;
	protected Date insuranceEndingDate;

	protected abstract double calculate();
}
