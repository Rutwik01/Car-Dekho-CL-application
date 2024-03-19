package com.jspiders.cardekho.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.jspiders.cardekho.entity.Car;

public class Operations {
	private List<Car> cars= new ArrayList<>();
	Scanner scanner=new Scanner(System.in);
	
	public void SearchByName(Scanner scanner) {
		boolean flag=false;
		System.out.println("Enter the car name");
		String name=scanner.next();
		for (Car car : cars) {
			if (car.getName().equalsIgnoreCase(name)) {
				System.out.println(car);
				flag=true;
				break;
			}
		}
		if (!flag) {
			System.out.println("The car not found with "+name+" name");
		}
	}
	public void SearchByCompany(Scanner scanner) {
		boolean flag=false;
		System.out.println("Enter the car brand");
		String company=scanner.next();
		for (Car car : cars) {
			if (car.getBrand().equalsIgnoreCase(company)) {
				System.out.println(car);
				flag=true;
				break;
			}
		}
		if (!flag) {
			System.out.println("The car not found with "+company+" name");
		}
	}
	
	public void SearchByPrice(Scanner scanner, Scanner scanner1) {
		boolean flag=false;
		System.out.println("Enter the car minimum price");
		int minPrice=scanner.nextInt();
		System.out.println("Enter the car maximum price");
		int maxPrice=scanner.nextInt();
		for (Car car : cars) {
			if (car.getPrice()>=minPrice && car.getPrice()<=maxPrice) {
				System.out.println(car);
				flag=true;
				break;
			}
		}
		if (!flag) {
			System.out.println("The car not found within "+minPrice+" and "+ maxPrice);
		}
	}
	
	public void SearchByFuelType(Scanner scanner) {
		boolean flag=false;
		System.out.println("Enter the car fuel type");
		String fuelType=scanner.next();
		for (Car car : cars) {
			if (car.getFuelType().equalsIgnoreCase(fuelType)) {
				System.out.println(car);
				flag=true;
				break;
			}
		}
		if (!flag) {
			System.out.println("The car not found with fuel type as "+fuelType);
		}
	}
	
	public void viewAllCars() {
//		System.out.println(cars);
//		System.out.println("view all cars");
		for(Car car:cars) {
			System.out.println(car);
		}
		
	}
	public void searchCar() {
		System.out.println("search car");
	}
	public void addCar() {
		System.out.println("How many cars do you want to add");
		Scanner scanner=new Scanner(System.in);
		int choice=scanner.nextInt();
		for(int i=1;i<=choice;i++)
		{
			Car car=new Car();
			System.out.println("Enter id: ");
			car.setId(scanner.nextInt());
			System.out.println("Enter name: ");
			car.setName(scanner.next());
			System.out.println("Enter brand: ");
			car.setBrand(scanner.next());
			System.out.println("Enter model: ");
			car.setModel(scanner.next());
			System.out.println("Enter Fuel type: ");
			car.setFuelType(scanner.next());
			System.out.println("Enter price: ");
			car.setPrice(scanner.nextInt());
			System.out.println("Enter colour: ");
			car.setColour(scanner.next());
			cars.add(car);
		}
		scanner.close();
	}
	public void removeCar(Scanner scanner) {
		boolean flag=false;
		System.out.println("Enter the car id ");
		int id=scanner.nextInt();
		for (Car car : cars) {
			if (car.getId()==id) {
				cars.remove(car);
				flag=true;
				break;
			}
		}
		if (!flag) {
			System.out.println("The car not found with car id : "+id);
		}
	}
	public void editCar(Scanner scanner) {
		@SuppressWarnings("unused")
		boolean flag=false;
		System.out.println("Enter the car id");
		int id=scanner.nextInt();
		for (Car car : cars) {
			if (car.getId()==id) {
				System.out.println("Current details about the car: ");
				System.out.println(car);
				System.out.println("Enter new name: ");
				String newName=scanner.next();
				System.out.println("Enter new brand: ");
				String newBrand=scanner.next();
				System.out.println("Enter new model: ");
				String newModel=scanner.next();
				System.out.println("Enter new Fuel type: ");
				String newFuelType=scanner.next();
				System.out.println("Enter new price: ");
				Double newPrice=scanner.nextDouble();
				System.out.println("Enter new colour: ");
				String newColor=scanner.next();
				car.setName(newName);
				car.setBrand(newBrand);
				car.setModel(newModel);
				car.setFuelType(newFuelType);
				car.setPrice(newPrice);
				car.setColour(newColor);
				System.out.println("car details updated succesfully.");
				flag=true;
				break;
			}
		}
	}
	
}