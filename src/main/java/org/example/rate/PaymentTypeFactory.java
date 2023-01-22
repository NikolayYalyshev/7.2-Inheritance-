package org.example.rate;

import java.util.Scanner;

public class PaymentTypeFactory {
	
	private Scanner scanner = new Scanner(System.in);
	
	public PaymentType scanPaymentType() {
		// 1 считать тип оплаты: 1-3
		// 2 внутри switch создать три разных объекта
		PaymentType.Type type = scanTypeFromIn();
		
		switch (type) {
			case DAILY:
				return createDailyRate();
			case HOURLY:
				return createHourlyRate();
			case PIECEWORK:
				return createPieceworkRate();
			default:
				throw new IllegalStateException("Unknown type: " + type);
		}
	}
	
	private PaymentType.Type scanTypeFromIn() {
		int choice = -1;
		while (choice < 1 || choice > 3) {
			System.out.println("Выберете способ оплаты труда: ");
			System.out.println("1. Ставка");
			System.out.println("2. Почасовая");
			System.out.println("3. Сдельная");
			choice = scanner.nextInt();
		}
		switch (choice) {
			case 1:
				return PaymentType.Type.DAILY;
			case 2:
				return PaymentType.Type.HOURLY;
			case 3:
				return PaymentType.Type.PIECEWORK;
			default:
				throw new IllegalStateException(
						"Неподдерживаемый " + "type: " + choice);
		}
	}
	
	private DailyPayment createDailyRate() {
		System.out.println("Какая ежедневная ставка сотрудника: ");
		int income = scanner.nextInt();
		
		System.out.println("Сколько дней отработал сотрудник: ");
		int dayInWork = scanner.nextInt();
		
		return new DailyPayment(income, dayInWork);
	}
	
	
	private HourlyPayment createHourlyRate() {
		System.out.println("Укажите, сколько сотрудник зарабатывает за час: ");
		int hourlyRate = scanner.nextInt();
		System.out.println("Сколько часов за месяц отработал сотрудник: ");
		int workingHours = scanner.nextInt();
		
		return new HourlyPayment(hourlyRate, workingHours);
	}
	
	private PieceworkPayment createPieceworkRate() {
		
		System.out.println("Сколько заработал сотрудник за чистку посуды?");
		int washFloor = scanner.nextInt();
		
		System.out.println("Сколько заработал сотрудник за чистку картошки?");
		int peelPotatoes = scanner.nextInt();
		
		System.out.println(
				"Сколько заработал сотрудник за приготовление " + "отчета");
		int submitReport = scanner.nextInt();
		
		return new PieceworkPayment(washFloor, peelPotatoes, submitReport);
	}
}
