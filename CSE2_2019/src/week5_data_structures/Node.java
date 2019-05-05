package week5_data_structures;

public class Node<T> {
	private T info;
	private Node<T> next;

	public Node(T x)
	{
		//constructor with info only
	    this.info = x;
	    this.next = null;
	}
	public Node(T x, Node<T> next)
	{
		//constructor with info and next point
	    this.info = x;
	    this.next = next;
	}
	public T getInfo()
	{
	    return(this.info);
	}
	public void setInfo(T x)
	{
	     this.info = x;
	}
	public Node<T> getNext()
	{   
	    return(this.next);
	}
	public void setNext(Node<T> next)
	{
	     this.next = next;
	}
	public String toString()
	{
		return("" + this.info);
	}
}
