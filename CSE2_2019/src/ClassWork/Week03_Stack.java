package ClassWork;

import java.util.Stack;
public class Week03_Stack {
	public static void stackExample() {
		//Create a stack
		Stack <String> stackOfCards = new Stack<>();
		
		//Pushing new items to the Stack:
		stackOfCards.push("Jack");
		stackOfCards.push("Queen");
		stackOfCards.push("King");
		System.out.println("Stack=>" + stackOfCards);
		
		//Popping items from the Stack"
		String cardAtTop = stackOfCards.pop();
		System.out.println("Stack.pop()=>"+cardAtTop);
		System.out.println("CurrentStack=>"+stackOfCards);
		System.out.println();
		
		//Get the item at the top of the stack without removing it
		cardAtTop = stackOfCards.peek();
		System.out.println("Stack.peek()=>"+cardAtTop);
		System.out.println("Current Stack=>"+stackOfCards);
		System.out.println("Size of Stack=>"+stackOfCards.size());
		
		//search for element
		int position = stackOfCards.search("Queen");
		if (position != -1) {
			System.out.println("Found Queen at position:"+position);
		}
		else
		{
			System.out.println("Element not found");
		}
		
		System.out.println("Current Stack=>"+stackOfCards);
	}
	
	
	public static void main(String[] args) {
		stackExample();
	}
}
