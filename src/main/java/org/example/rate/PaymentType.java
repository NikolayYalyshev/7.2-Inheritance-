package org.example.rate;

public abstract class PaymentType { // ставка
	
	private Type type;
	
	public abstract int getMonthIncome();
	
	public abstract int tax();
	
	public PaymentType(Type type) {
		this.type = type;
	}
	
	public float getIncomeMinusTax() {
		return getMonthIncome() * (1 - ((float)tax() / 100));
	}
	
	enum Type {
		DAILY("ставка"), HOURLY("почасовая"), PIECEWORK("сдельная");
		private final String text;
		
		Type(String text) {
			this.text = text;
		}
	}
	
	@Override
	public String toString() {
		return tax() + "     " + getMonthIncome() + "     " + getIncomeMinusTax();
	}
	
	public String printLight(){
		return type.text + "     " + getMonthIncome();
	}
}
