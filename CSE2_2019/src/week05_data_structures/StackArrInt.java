package week05_data_structures;

public class StackArrInt {
	public static final int STACK_SIZE = 100;
	private int[] data;
	private int top; //top is the location of the top value in the array. -1 if array is empty
	
	public void Stuck() {
		//create empty stuck
		this.top = -1;
		this.data = new int[STACK_SIZE];
	}
	public boolean isEmpty() {
		//return this.first == null;
	}
	
	public void push(T x) {
		//this.first = new Node<T>(x, this.first);
	}
	 
	public T pop() {
		//T x = this.first.getInfo();
		//this.first = this.first.getNext();
		//return x;
	}
	
	public T top() {
		//return this.first.getInfo();
	}
	
	public String toString() {
		String str = "[";
		//Node<T> pos = this.first;
		//while (pos != null) {
		//	str = str + pos.getInfo().toString();
		//	if (pos.getNext() != null)
		//		str = str + ",";
		//	pos = pos.getNext();
		//}
		//str = str + "]";
		return str;
	}
	
}
