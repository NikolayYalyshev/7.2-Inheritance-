package org.example.rate;

public class PieceworkPayment extends PaymentType {  // сдельная оплата
	
	private int washFloor;
	
	private int peelPotatoes;
	
	
	
	private int submitReport;
	
	private final int taxPieceworkPayment = 15; // налог
	
	public PieceworkPayment(int washFloor, int peelPotatoes,
							int submitReport) {
		super(Type.PIECEWORK);
		this.washFloor = washFloor;
		this.peelPotatoes = peelPotatoes;
		this.submitReport = submitReport;
	}
	
	@Override
	public int getMonthIncome() {
		return washFloor + peelPotatoes + submitReport;
	}
	
	@Override
	public int tax() {
		return 15;
	}
}
