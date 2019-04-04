package week03_basics_stack_queue;
import java.util.Queue;
import java.util.LinkedList;
public class QueueExample {

	public static void queueExample() {
		//Create and initialize a Queue using a LinkedList:
		//Queue<String> que = new Queue <String>(); what will happen?
		Queue<String> waitingQueue = new LinkedList<>();
		
		//Adding new elements to the Queue
		waitingQueue.add("Rinat");
		waitingQueue.add("Chris");
		waitingQueue.add("John");
		waitingQueue.add("Mark");
	
		System.out.println("WaitingQueue: "+waitingQueue);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queueExample();
	}

}
