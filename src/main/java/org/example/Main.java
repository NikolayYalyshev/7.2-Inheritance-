package org.example;

import org.example.rate.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println(
				"Добро пожаловать в программу \"Топ " + "бухгалтер\"");
		Scanner scanner = new Scanner(System.in);
		
		int num = 0;     // счетчик доходов всех сотрудников с налогами
		List<Person> personList = new ArrayList<>();
		
		final PaymentTypeFactory paymentTypeFactory = new PaymentTypeFactory();
		
		while (true) {
			
			System.out.println("Добавить сотрудника в отчет? (Да/Нет/random)" +
					" ");
			String choice = scanner.nextLine();
			String yes = "Да";
			String no = "Нет";
			String random = "random";
			if (choice.equalsIgnoreCase(random)) {
				personList = generateRandomPersons();
				break;
			} else if (choice.equals(yes)) {
				
				System.out.println("Фамилия сотрудника: ");
				String surname = scanner.nextLine();
				
				PaymentType paymentType = paymentTypeFactory.scanPaymentType();
				Person person = new Person(surname, paymentType);
				
				
				personList.add(person);
				
				
				
			} else if (choice.equals(no)) {
				break;
			}
		}
		
		PrintReport.reportSelection();
		int list = scanner.nextInt();
		
		int sum = 0;
		switch (list) {
			case 1:
				
				for (int i = 0; i < personList.size(); i++) {
					sum = sum + personList.get(i).getPaymentType().getMonthIncome();
				}
				PrintReport.printListOfPeople(personList, sum);
				break;
			case 2:
				PrintReport.printListOfPeopleWithTaxes(personList);
				break;
		}
		
	}
	
	private static List<Person> generateRandomPersons() {
		ArrayList<Person> personList = new ArrayList<>();
		Person p1 = new Person("Иванов", new DailyPayment(20, 20));
		Person p2 = new Person("Сидоров", new HourlyPayment(200, 50));
		Person p3 = new Person("Пупкин", new PieceworkPayment(1000, 200,
				5000));
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		return personList;
	}
}