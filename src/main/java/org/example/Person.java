package org.example;

import org.example.rate.PaymentType;

public final class Person {
	private String surname; // фамилия
	
	private PaymentType paymentType;
	
	public Person(String surname, PaymentType paymentType) {
		this.surname = surname;
		this.paymentType = paymentType;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public PaymentType getPaymentType() {
		return paymentType;
	}
	
	@Override
	public String toString() {
		return surname + "     " + paymentType;
	}
	
	
	public String printLight() {
		return surname + "     " + paymentType.printLight();
	}
}
