package week10_OOP;

public class ExtandExample {
	public static void main(String[] args) {
		//Animal animal1 = new Animal ("Mr. Animal");
		//animal1.sayHi();
		Animal cat1 = new Cat ("Kity", 7);
		//((Cat) cat1).sayMiaw();
		//Animal cat2 = new Cat("Garfild",7);
		//cat2.sayHi();
		//System.out.println("animal1="+ animal1);
		//System.out.println("cat1="+ cat1);
		//System.out.println("cat2="+ cat2);
		//System.out.println(cat2 instanceof Cat);
		//System.out.println(cat2 instanceof Animal);
		//System.out.println(animal1 instanceof Cat);
		
	}

}

class Animal {
	public String name;
	public Animal () {
		System.out.println("create Animal()");
		this.name = "someone";
	}
	public Animal(String name) {
		System.out.println("create Animal(name)");
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void sayHi() {
		System.out.println("Hi! my name is " + this.name + ". I'm an Animal" );
	}	
	@Override
	public String toString() {
		return "Animal [name=" + this.name + "]";
	}	
}

class Cat extends Animal {

	private int lives;

	public Cat(String name, int lives) {
		super(name);
		System.out.println("create Cat");
		this.lives = lives;
	}
	public void sayHi() {
		System.out.println("Hi! my name is "+this.name + ". I'm a Cat Miaw");
	}
	
	public void sayMiaw() {
		System.out.println("Maiw");
	}
	@Override
	public String toString() {
		return "Cat [lives=" + this.lives +", "+ super.toString() +"]";
	}
}

