package week03_targil7;

//import java.util.Stack;
import java.util.Scanner;
import unit4.collectionsLib.*;

public class Targil7 {
	static Stack <Car> stackCarsParked = new Stack<>();
	static Stack <Car> stackCarsOut = new Stack<>();
	static int numCarsParked;
	
	public static void parkCar (int carLicense) {
		//try to park car with carLicense (if there is a space)
		
		//if (stackCarsParked.size() < 10) { //if using java.util.Stack;
		if (numCarsParked < 10) { //if using edu_
			Car carIn = new Car (carLicense);
			stackCarsParked.push(carIn);
			numCarsParked++;
			System.out.println(carIn+ " was parked");
		}
		else
			System.out.println("Sorry, parking lot is full");
	}
	
	public static void exitCar(int carLicense) {
		//try to exit car with carLicense from stackCarsParked (if there) using stackCarsMoved.
		boolean carFound = false;
		while (!stackCarsParked.isEmpty()) {	
			Car exitCar = stackCarsParked.pop();
			exitCar.increaseNumOfMoves();
			if (exitCar.getLicense ()== carLicense) {//this is the car that needs to exit
				numCarsParked--;
				System.out.println(exitCar + " was removed");
				carFound = true;
				break; 
			}
			else {
				stackCarsOut.push(exitCar);
			}	
		}
		
		if (!carFound) {
			System.out.println("Sorry, car license "+carLicense+" was not found in the parking lot");
		}
		returnCarsOut();
		
	}
	public static void returnCarsOut() {
		//Return the cars that were moved out back to the parking place.
		while (!stackCarsOut.isEmpty()) {
			Car returnCar = stackCarsOut.pop();
			returnCar.increaseNumOfMoves();
			stackCarsParked.push(returnCar);
		}
	}
	
	public static void main(String[] args) {
		//Solve Targil 7 - manage a parking lot
		//See full description in stack_ex1.pdf targil 7
		
		Scanner input = new Scanner (System.in);
		numCarsParked=0;
		System.out.println("Enter next input in the form of:\n "
				+ "A (park car)/D (exit car) followed by car license (e.g. A1234345)"
				+"\n Type 'Stop' to finish");
		while (true) { //keep reading next input
			String nextInput = input.nextLine(); //in the form of A1111111
			if (nextInput.equals("Stop")) {//exit the program
				break;
			}
			char operation = nextInput.charAt(0);//'D' or 'A'
			int carLicense = Integer.parseInt(nextInput.substring(1, nextInput.length()));
			if (operation=='A') { //park car
				parkCar(carLicense);
			}
			else if (operation=='D') { //exit car from parking
				exitCar(carLicense);
			}
			System.out.println("stackCarsParked="+stackCarsParked);
	
		}
		
	}

}
