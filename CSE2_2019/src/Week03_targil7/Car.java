package Week03_targil7;

public class Car {
	private int license;
	private int numOfMoves;
	
	public Car(int license){
		this.license = license;
		this.numOfMoves = 1;
	}
	public void increaseNumOfMoves() {
		this.numOfMoves++;
	}
	public int getLicense() {
		return this.license;
	}
	public String toString(){
		return "Car license "+ this.license +" (moved "+ this.numOfMoves +" times)";
	}
}
