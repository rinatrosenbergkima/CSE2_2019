package week10_OOP;
public class TargitOmar {

	
	public static void main(String[] args) {
		B1 a = new B1();
		System.out.println(((A1)a).i);
	}
}

class A1 {
	int i=10;
	public A1() {
		
	}
}
class B1 extends A1 {
	int i=20;
	public B1() {
		
	}



}