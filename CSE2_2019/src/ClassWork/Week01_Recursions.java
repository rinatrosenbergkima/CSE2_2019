package ClassWork;

public class Week01_Recursions {
	
	public static int factorial (int num) {
	//calculate recursively the factorial of num:
		if (num==0)
			return 1;
		else
			return (num * factorial (num-1));
	}
	
	public static void reverseNum (int num) {
	//print reverse of num. For example, if num=12345 print 54321.
		if (num<10)
			System.out.println(num);
		else
		{
			System.out.print(num%10);
			reverseNum(num/10);
		}
	}
	//mutual recursion
	public static int g(int num) {
		if (num==0)
			return 1;
		else
			return (num * h(num-1));
	}
	public static int h (int n) {
		return g(n);
	}
	
	public static int fibonacci(int k) {
		if (k==1)
			return 0;
		if (k==2)
			return 1;
		return (fibonacci (k-1)+fibonacci(k-2));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		System.out.println("factorial(4)="+ factorial(4));
		reverseNum(12345);
		System.out.println("g(5)="+g(5));
		System.out.println("fibonacci(7)="+fibonacci(7));
	}
}