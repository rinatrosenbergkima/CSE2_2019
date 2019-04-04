package Week03_targil7;

//import java.util.Stack;
import java.util.Scanner;

public class Targil7 {
	static Stack <Car> stackCarsParked = new Stack<>();
	static Stack <Car> stackCarsOut = new Stack<>();
	
	public static void parkCar (int carId) {
		if (stackCarsParked.size() < 10) {
			Car carIn = new Car (carId);
			stackCarsParked.push(carIn);
			System.out.println(carIn+ " was parked at location "+stackCarsParked.size());
		}
		else
			System.out.println("Sorry, parking lot is full");
	}
	
	public static void exitCar(int carLicense) {
		boolean carFound = false;
		while (!stackCarsParked.isEmpty()) {	
			Car exitCar = stackCarsParked.pop();
			exitCar.increaseNumOfMoves();
			if (exitCar.getLicense ()== carLicense) {//this is the car that needs to exit
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
		System.out.println("stackCarsParked="+stackCarsParked);
		
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
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.println("Enter next input in the form of:\n "
				+ "A (park car)/D (exit car) followed by car license (e.g. A1234345)"
				+"\n Type 'Stop' to finish");
		while (true) {
			String nextInput = input.nextLine(); //in the form of A1111111
			if (nextInput.equals("Stop")) {//exit the program
				break;
			}
			char operation = nextInput.charAt(0);
			int carLicense = Integer.parseInt(nextInput.substring(1, nextInput.length()));
			if (operation=='A') { //Enter car
				parkCar(carLicense);
			}
			else if (operation=='D') { //Remove car
				exitCar(carLicense);
			}
	
		}
		
	}

}
