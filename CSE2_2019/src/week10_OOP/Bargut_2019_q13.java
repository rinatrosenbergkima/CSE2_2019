package week10_OOP;

public class Bargut_2019_q13{
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A(5);
		A ab = new B();
		B b1 = new B("B",1);
		B b2 = new B("B",5);
		//if (a1.equals(b1)) System.out.println(1);
		//if (b1.equals(a1)) System.out.println(2);
		//if (a1.equals(ab)) System.out.println(3);
	    if (ab.equals(a1)) System.out.println(4);
		//if (b1.equals(ab)) System.out.println(5);
		//if (ab.equals(ab)) System.out.println(6);
		//if (a1.equals(a2)) System.out.println(7);
		//if (b1.equals(b2)) System.out.println(8);
		
	}	
}
class A {
	private int val;
	public A() {
		this.val = 1;
	}
	public A (int val) {
		this.val=val;
	}
	public int getVal() {
		return this.val;
	}
	public boolean equals(Object other) {
		System.out.println("AObject");
		if (other instanceof A)
			return (this.val==((A) other).val);
		return false;
	}
}


class B extends A {
	private String st;
	public B() {
		this.st = "B";
	}
	public B(String st, int val) {
		super(val);
		this.st=st;
	}
	public String getStr() {
		return this.st;
	}
	public boolean equals (Object other) {
		System.out.println("BObject");
		if (other instanceof B)
			return (this.st.equals(((B)other).st) 
					&& this.getVal()==((B) other).getVal());
		return false;
	}
	public boolean equals (A other) {
		System.out.println ("B A");
		if (other instanceof B)
			return (this.st.contentEquals(((B) other).st)
				&& this.getVal()==((B)other).getVal());
		return false;
	}
	public boolean equals (B other) {
		System.out.println("BB");
		return (this.st.equals(other.st)
				&& this.getVal()==other.getVal());
	}
}


