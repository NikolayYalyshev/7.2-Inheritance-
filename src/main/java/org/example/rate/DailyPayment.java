package org.example.rate;

public class DailyPayment extends PaymentType {
	
	private int moneyInDay;
	private int workingDays;
	
	public DailyPayment(int moneyInDay, int workingDays) {
		super(Type.DAILY);
		this.moneyInDay = moneyInDay;
		this.workingDays = workingDays;
	}
	
	@Override
	public int getMonthIncome() {
		return moneyInDay * workingDays;
	}
	
	@Override
	public int tax() {
		return 20;
	}
}
