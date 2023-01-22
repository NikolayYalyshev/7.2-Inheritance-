package org.example.rate;

public class HourlyPayment extends PaymentType { // почасовая оплата
	
	private int hourlyRate;
	
	private int workingHours;
	
	private final int taxHourlyPayment = 20; // налог
	
	public HourlyPayment(int hourlyRate, int workingHours) {
		super(Type.HOURLY);
		this.hourlyRate = hourlyRate;
		this.workingHours = workingHours;
	}
	
	@Override
	public int getMonthIncome() {
		return hourlyRate * workingHours;
	}
	
	@Override
	public int tax() {
		return 20;
	}
	
}
