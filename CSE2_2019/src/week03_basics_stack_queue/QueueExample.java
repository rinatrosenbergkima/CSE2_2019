package week03_basics_stack_queue;
//import java.util.Queue;
//import java.util.LinkedList;

import unit4.collectionsLib.*; //Misrad Hachinuch collection

public class QueueExample {

	public static void queueExample() {
		//Create and initialize a Queue using a LinkedList:
		//Queue<String> que = new Queue <String>(); what will happen?
		//Queue<String> waitingQueue = new LinkedList<>();
		Queue<String> waitingQueue = new Queue();
		//Adding new elements to the Queue
		//waitingQueue.add("Rinat"); //this is the method in java.util.Queue
		waitingQueue.insert("Rinat");//this is the method in unit4.collectionLib
		waitingQueue.insert("Chris");
		waitingQueue.insert("John");
		waitingQueue.insert("Mark");
	
		//check is queue empty:
		System.out.println("isEmpty="+waitingQueue.isEmpty());
		
		//print queue:
		System.out.println("WaitingQueue: "+waitingQueue);
		
		//remove item from queue:
		String removedFromQueue = waitingQueue.remove();
		System.out.println("removedFromQueue="+removedFromQueue);
		
		//print queue:
		System.out.println("waitingQueue="+waitingQueue);
		
		//check who is in the head of the queue (will not be removed from queue):
		String headQueue = waitingQueue.head();
		System.out.println("headQueue="+headQueue);
		
		//print queue:
		System.out.println("waitingQueue="+waitingQueue);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queueExample();
	}

}
