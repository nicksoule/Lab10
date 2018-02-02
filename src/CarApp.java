/*
 * Nicholas Soule
 * 2/2/2018 
 * Lab 10 - Car Buying App
 */

import java.util.ArrayList;
import java.util.Scanner;

public class CarApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Car> carList = new ArrayList<>();
		carList.add(new Car("BMW", "750i", 2018, 80000));
		carList.add(new Car("Ford", "F-150", 2018, 35000));
		carList.add(new Car("Chevy", "Cruze", 2018, 27000));
		carList.add(new UsedCar("Honda", "Accord", 1997, 3000, 145000));
		carList.add(new UsedCar("Volvo", "V70XC", 1999, 2500, 256000));
		carList.add(new UsedCar("Volkswagen", "Jetta", 2011, 7000, 137000));
		String cont;
		int userNum;

		do {
			do {
				// program starts, lists all cars, lets user select a car then ask if they would like to buy it
				System.out.println("Welcome to the Grand Circus Car Store!");
				showCars(carList);
				userNum = Validator.getInt(scan, "Which car would you like?", 1, carList.size());
				System.out.println("You chose car number " + userNum);
				System.out.println(carList.get(userNum - 1));
				cont = Validator.getString(scan, "Would you like to buy this car? y/n", "y", "n");
			} while (cont.equalsIgnoreCase("n"));
			// if user chooses to buy the car, the car is removed, the list is displayed with what's left
			// and the user if asked if they would like to continue or leave the program.
			carList.remove(userNum);
			showCars(carList);
			cont = Validator.getString(scan, "Would you like to buy another car? y/n", "y", "n");
		} while (cont.equalsIgnoreCase("y"));
		System.out.println("Goodbye!");
		scan.close();

	}
	// method that lists all the cars
	public static void showCars(ArrayList<Car> carList) {
		for (int i = 0; i < carList.size(); ++i) {
			System.out.print(i + 1 + ") ");
			System.out.println(carList.get(i));
		}

	}

}
