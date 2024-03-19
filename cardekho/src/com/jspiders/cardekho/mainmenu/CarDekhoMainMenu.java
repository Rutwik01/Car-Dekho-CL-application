package com.jspiders.cardekho.mainmenu;

import java.util.Scanner;

import com.jspiders.cardekho.operations.OperationJDBC;

public class CarDekhoMainMenu {
	static boolean loop = true;
	static OperationJDBC op = new OperationJDBC();

	public static void main(String[] args) {
		while (loop) {
			mainMenu();
		}
	}

	private static void mainMenu() {

		System.out.println("=====Main Menu=====\n" + "1.View all cars\n" + "2.Search car\n" + "3.Add car\n"
				+ "4.Remove car\n" + "5.Edit car\n" + "6.Exit");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1:
			op.viewAllCars();
			break;
		case 2:
			op.searchCar();
			System.out.println("=====Search Menu=====\n" + "1.Search by name\n" + "2.Search by company\n"
					+ "3.Search by price\n" + "4.Search by fueltype\n" + "5.Go back");
			int choice1 = scanner.nextInt();
			switch (choice1) {
			case 1:
				op.SearchByName();
				break;
			case 2:
				op.SearchByBrand();
				break;
			case 3:
				op.SearchByPrice();
				break;
			case 4:
				op.SearchByFuelType();
				break;
			case 5:
				mainMenu();
				break;
			}

			break;
		case 3:
			op.addCar();
			break;
		case 4:
			op.removeCar();
			break;

		case 5:
			op.editCar();
			break;
		case 6:
			System.out.println("Thank you");
			loop = false;
			scanner.close();
			break;
		default:
			System.out.println("Invalid Input. Please try again");
			scanner.close();
			break;

		}

	}
}
