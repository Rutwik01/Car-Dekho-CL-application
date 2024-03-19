package com.jspiders.cardekho.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jspiders.cardekho.entity.Car;

public class OperationJDBC {
	Scanner scanner = new Scanner(System.in);
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	private static Car car;

	private static void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3", "root", "root");

	}

	private static void closeConnection() throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}

	}

	public void viewAllCars() {
//			System.out.println(cars);
			System.out.println("====view all cars====");
		boolean flag = false;
		try {
			openConnection();
			query = "select * from cars";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				flag = true;
				System.out.print("id : "+resultSet.getInt(1) + " | ");
				System.out.print("model : "+resultSet.getString(2) + " | ");
				System.out.print("brand : "+resultSet.getString(3) + " | ");
				System.out.print("price : "+resultSet.getInt(4) + " | ");
				System.out.print("colour : "+resultSet.getString(5) + " | ");
				System.out.print("fuelType : "+resultSet.getString(6) + " | ");
				System.out.print("name : "+resultSet.getString(7) + " | ");
				System.out.println("\n====================");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!flag) {
			System.out.println("There is no car to display");
		}

	}

	public void SearchByName() {
		System.out.println("===================");
		System.out.println("Enter the car name");
		String name = scanner.nextLine();
		boolean flag = false;
		try {
			openConnection();
			query = "select * from cars where name=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				flag = true;
				System.out.println("===================");
				System.out.println("The car found is : ");
				System.out.print("id : "+resultSet.getInt(1) + " | ");
				System.out.print("model : "+resultSet.getString(2) + " | ");
				System.out.print("brand : "+resultSet.getString(3) + " | ");
				System.out.print("price : "+resultSet.getInt(4) + " | ");
				System.out.print("colour : "+resultSet.getString(5) + " | ");
				System.out.print("fuelType : "+resultSet.getString(6) + " | ");
				System.out.print("name : "+resultSet.getString(7) + " | ");
				System.out.println("\n====================");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!flag) {
			System.out.println("Car with name '" + name + "' is not found");
		}
	}

	public void SearchByBrand() {
		System.out.println("===================");
		System.out.println("Enter the company name");
		String brand = scanner.nextLine();
		boolean flag = false;
		try {
			openConnection();
			query = "select * from cars where brand=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, brand);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				flag = true;
				System.out.println("===================");
				System.out.println("The car found is : ");
				System.out.print("id : "+resultSet.getInt(1) + " | ");
				System.out.print("model : "+resultSet.getString(2) + " | ");
				System.out.print("brand : "+resultSet.getString(3) + " | ");
				System.out.print("price : "+resultSet.getInt(4) + " | ");
				System.out.print("colour : "+resultSet.getString(5) + " | ");
				System.out.print("fuelType : "+resultSet.getString(6) + " | ");
				System.out.print("name : "+resultSet.getString(7) + " | ");
				System.out.println("\n====================");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!flag) {
			System.out.println("Car with name " + brand + " is not found");
		}
	}

	public void SearchByPrice() {
		System.out.println("===================");
		boolean flag = false;
		System.out.println("Enter the car minimum price");
		int minPrice = scanner.nextInt();
		System.out.println("Enter the car maximum price");
		int maxPrice = scanner.nextInt();

		try {
			openConnection();
			query = "select * from cars where price>=? and price<=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, minPrice);
			preparedStatement.setInt(2, maxPrice);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				flag = true;
				System.out.println("===================");
				System.out.println("The car found is : ");
				System.out.print("id : "+resultSet.getInt(1) + " | ");
				System.out.print("model : "+resultSet.getString(2) + " | ");
				System.out.print("brand : "+resultSet.getString(3) + " | ");
				System.out.print("price : "+resultSet.getInt(4) + " | ");
				System.out.print("colour : "+resultSet.getString(5) + " | ");
				System.out.print("fuelType : "+resultSet.getString(6) + " | ");
				System.out.print("name : "+resultSet.getString(7) + " | ");
				System.out.println("\n====================");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (!flag) {
			System.out.println("The car not found within price range of " + minPrice + " and " + maxPrice);
		}
	}

	public void SearchByFuelType() {
		System.out.println("===================");
		boolean flag = false;
		System.out.println("Enter the car fuel type");
		String fuelType = scanner.next();
		try {
			openConnection();
			query = "select * from cars where fuelType=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, fuelType);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				flag = true;
				System.out.println("===================");
				System.out.println("The car found is : ");
				System.out.print("id : "+resultSet.getInt(1) + " | ");
				System.out.print("model : "+resultSet.getString(2) + " | ");
				System.out.print("brand : "+resultSet.getString(3) + " | ");
				System.out.print("price : "+resultSet.getInt(4) + " | ");
				System.out.print("colour : "+resultSet.getString(5) + " | ");
				System.out.print("fuelType : "+resultSet.getString(6) + " | ");
				System.out.print("name : "+resultSet.getString(7) + " | ");
				System.out.println("\n====================");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (!flag) {
			System.out.println("The car not found with fuel type as " + fuelType);
		}
	}

	public void searchCar() {
		System.out.println("===================");
		System.out.println("search car");
	}

	public void addCar() {
		System.out.println("===================");
		int choice = 0;
		while (true) {
			try {
				System.out.print("How many cars you want to add? ");
				choice = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Please enter a valid choice!");
				scanner.nextLine();
				continue;
			}
			break;
		}
		try {
			openConnection();
			query = "INSERT INTO cars VALUES(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			for (int i = 1; i <= choice; i++) {

				System.out.println("Enter id: ");
				int id = scanner.nextInt();
				scanner.nextLine();
				preparedStatement.setInt(1, id);

				System.out.println("Enter model: ");
				String model = scanner.nextLine();
				preparedStatement.setString(2, model);

				System.out.println("Enter brand: ");
				String brand = scanner.nextLine();
				preparedStatement.setString(3, brand);

				System.out.println("Enter price: ");
				double price = scanner.nextDouble();
				scanner.nextLine();
				preparedStatement.setDouble(4, price);

				System.out.println("Enter colour: ");
				String colour = scanner.nextLine();
				preparedStatement.setString(5, colour);

				System.out.println("Enter Fuel type: ");
				String fuelType = scanner.nextLine();
				preparedStatement.setString(6, fuelType);

				System.out.println("Enter name: ");
				String name = scanner.nextLine();
				preparedStatement.setString(7, name);

				preparedStatement.addBatch();
			}
			int res[] = preparedStatement.executeBatch();
			if (res.length > 0) {
				System.out.println(res.length + " car(s) has/have been added");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void removeCar() {
		System.out.println("===================");
		boolean flag = false;
		System.out.println("Enter the car id ");
		int id = scanner.nextInt();
		try {
			openConnection();
			query = "delete from cars where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int res = preparedStatement.executeUpdate();
			if (res == 1) {
				flag=true;
				System.out.println("Car removed successfully.");
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!flag) {
			System.out.println("The car not found with car id : " + id);
			
		}
	}

	public void editCar() {
		System.out.println("===================");
		int id = 0;
//		boolean flag = false;
		System.out.println("Available Cars");
		viewAllCars();
		while (true) {
			try {
				System.out.print("Which car do you want to edit?\nPlease enter id:");
				id = scanner.nextInt();
//				query="Select * from cars where id=?";
//				preparedStatement= connection.prepareStatement(query);
//				preparedStatement.setInt(1, id);
//				boolean result = preparedStatement.execute();
////				int value=resultSet.getInt(1);
//				if (result) {
//					
//				}
//				System.out.println(value);
//				if (value==0) {
//					continue;
//				}
				
			} catch (Exception e) {
				System.out.println("===================");
				System.out.println("Please enter a valid choice");
				System.out.println("===================");
				scanner.nextLine();
				continue;
			}
			break;
		}
		try {
			openConnection();
			query = "select * from cars where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				System.out.println("what do you want to edit?\n" + "1. name\n" + "2. brand\n" + "3. model\n"
						+ "4. color\n" + "5. price\n" + "6. fuelType");
				int choice = scanner.nextInt();
				scanner.nextLine();
				switch (choice) {
				case 1:
					System.out.println("Enter car name you want to edit : ");
					String name = scanner.nextLine();
					try {
						openConnection();
						query = "Update cars set name=? where id=?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, name);
						preparedStatement.setInt(2, id);
						int res = preparedStatement.executeUpdate();
						if (res == 1) {
							System.out.println("===================");
							System.out.println("Car name with id : " + id + "has been changed successfully");
						} else {
							System.out.println("Car not found with id : " + id);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					} finally {
						closeConnection();
					}
					break;
				case 2:
					System.out.println("Enter car brand you want to edit : ");
					String brand = scanner.nextLine();
					try {
						openConnection();
						query = "Update cars set brand=? where id=?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, brand);
						preparedStatement.setInt(2, id);
						int res = preparedStatement.executeUpdate();
						if (res == 1) {
							System.out.println("===================");
							System.out.println("Car brand with id : " + id + "has been changed successfully");
						} else {
							System.out.println("Car not found with id : " + id);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					} finally {
						closeConnection();
					}
					break;
				case 3:
					System.out.println("Enter car model you want to edit : ");
					String model = scanner.nextLine();
					try {
						openConnection();
						query = "Update cars set model=? where id=?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, model);
						preparedStatement.setInt(2, id);
						int res = preparedStatement.executeUpdate();
						if (res == 1) {
							System.out.println("===================");
							System.out.println("Car model with id : " + id + "has been changed successfully");
						} else {
							System.out.println("Car not found with id : " + id);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					} finally {
						closeConnection();
					}
					break;
				case 4:
					System.out.println("Enter car colour you want to edit : ");
					String colour = scanner.nextLine();
					try {
						openConnection();
						query = "Update cars set name=? where id=?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, colour);
						preparedStatement.setInt(2, id);
						int res = preparedStatement.executeUpdate();
						if (res == 1) {
							System.out.println("===================");
							System.out.println("Car colour with id : " + id + "has been changed successfully");
						} else {
							System.out.println("Car not found with id : " + id);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					} finally {
						closeConnection();
					}
					break;
				case 5:
					System.out.println("Enter car price you want to edit : ");
					double price = scanner.nextDouble();
					scanner.nextLine();
					try {
						openConnection();
						query = "Update cars set price=? where id=?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setDouble(1, price);
						preparedStatement.setInt(2, id);
						int res = preparedStatement.executeUpdate();
						if (res == 1) {
							System.out.println("===================");
							System.out.println("Car price with id : " + id + "has been changed successfully");
						} else {
							System.out.println("Car not found with id : " + id);
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						closeConnection();
					}
					break;
				case 6:
					System.out.println("Enter car fuel type you want to edit : ");
					String fuelType = scanner.nextLine();
					try {
						openConnection();
						query = "Update cars set fuelType=? where id=?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, fuelType);
						preparedStatement.setInt(2, id);
						int res = preparedStatement.executeUpdate();
						if (res == 1) {
							System.out.println("===================");
							System.out.println("Car fuel type with id : " + id + "has been changed successfully");
						} else {
							System.out.println("Car not found with id : " + id);
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						closeConnection();
					}
					break;
				default:
					System.out.println("Please enter valid input...!");
				}
//				flag = true;
			}else {
				System.out.println("car not found with specified id");
			}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			} finally {
				try {
					closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//			if (status) {
//				flag = true;
//				System.out.println("what do you want to edit?\n" + "1. name\n" + "2. brand\n" + "3. model\n"
//						+ "4. color\n" + "5. price\n" + "6. fuelType");
//			}
			
//		if (!flag) {
//			System.out.println("Cars not found..!!");
//		}

	}

}
