package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrintReport {
	
	public static void reportSelection(){
		System.out.println("Какой подготовить отчет?");
		System.out.println("1. Отчет обыкновенный");
		System.out.println("2. Отчет с учетом налогов");
	}
	
	public static String selection(int number) {
		if (number == 1) {
			return new String("Ставка");
		} else if (number == 2) {
			return new String("Почасовая");
		} else {
			return new String("Сдельная");
		}
	}
	
	public static String selectionWithTax(int number) {
		if (number == 1) {
			return new String("20%");
		} else if (number == 2) {
			return new String("20%");
		} else {
			return new String("15%");
		}
	}
	
	public static void printListOfPeople(List<Person> people, int sum) {
		System.out.println("ФИО        Вид оплаты         Сумма");
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i).printLight());
		}
		System.out.println("Итого                         " + sum);
	}
	
	public static void printListOfPeopleWithTaxes(List<Person> people){
		System.out.println("ФИО        Налог,%         Сумма         К оплате");
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
	}
}

