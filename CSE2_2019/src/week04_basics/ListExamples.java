package week04_basics;
import java.util.Scanner;

import unit4.collectionsLib.*;

public class ListExamples {
	
	public static void listExample1() {
		//insert numbers to list
		List<Integer> lst = new List<Integer>();
		for (int i=0;i<3;i++) {
			lst.insert(null,i);
			System.out.println(lst);
			System.out.println("length="+getLength(lst));
		}
		
	}
	
	public static void listExample2() {
		Scanner input = new Scanner (System.in);
		List<String> lst = new List<String>();
		Node<String> p=null;
		Node<String> j=null;
		for (int i=0;i<4;i++) {
			String strInput = input.nextLine();
			j=lst.insert(p, strInput);//strInput will enter the head of the list!
			//p=lst.insert(p, strInput);//strInput will enter the tail of the list!
			System.out.println(lst);
		}
	}
	
	public static int getLength(List<Integer> lst){
		Node<Integer> nCurrentNode = lst.getFirst();
		int nLength=0;
		while (nCurrentNode!=null) {
			nLength++;
			nCurrentNode = nCurrentNode.getNext();
		}
		return nLength;
	}
	
	public static void insertNamesByOrder() {
		Scanner input = new Scanner (System.in);
		List<String> lst = new List<String>();
		for (int i=0;i<4;i++) {
			String strInput = input.nextLine();
			insertIntoSortedList(lst,strInput);
			System.out.println(lst);
		}
	}
	
	public static void insertIntoSortedList(List<String> lst, String str) {
		Node<String> prev = null;
		Node<String> pos = lst.getFirst();
		while ((pos!=null) && (pos.getInfo().compareTo(str)<0)) {
			prev=pos;
			pos=pos.getNext();
			System.out.println(lst);
		}
		lst.insert(prev, str);
	}
	
	public static List<Integer> getEvenNumbers(List<Integer> inputList){
		List<Integer> evenList = new List<Integer>();
		Node<Integer> posInput=inputList.getFirst();
		Node<Integer> posEven=null;
		while (posInput != null) {
			if ((posInput.getInfo() % 2 ) == 0) {

				posEven = evenList.insert(posEven, posInput.getInfo());
			}
			posInput = posInput.getNext();
			System.out.println(evenList);
		}
		
		return evenList;
	}
	
	public static void callGetEvenNumbers() {
		Scanner input = new Scanner (System.in);
		System.out.println("Enter 10 integers:");
		List <Integer> lst = new List<Integer>();
		Node<Integer> p=null;
		for (int i=0;i<10;i++) {
			int intInput = Integer.parseInt(input.nextLine());
			lst.insert(p, intInput);//strInput will enter the head of the list!
			//p=lst.insert(p, strInput);//strInput will enter the tail of the list!
			System.out.println(lst);
		}
		System.out.println("The even list is:");
		System.out.println(getEvenNumbers(lst));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//listExample1();
		//listExample2();
		//insertNamesByOrder();
		callGetEvenNumbers();
	}
}
