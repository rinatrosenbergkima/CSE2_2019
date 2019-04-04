//package unit4.collectionsLib;
package EduLibrary;

/** 
 * <h3 dir="rtl" style="color:red; font-family: Helvetica, Arial, sans-serif">
 * ������ ������ ����� ���� ��� �������� LIFO ������ ������ �� �����. 
 * </h3>
 * 
 * @author ���� ���� �����, ����� ������ ������, ����������� ������, �������
 * @version 8.11.2007
 */
public class Stack<T>
{
	private List<T> data;  //����� �� ������� ���� �������
	
	/**
	 * <dt dir="rtl">
	 * <b>
	 * ������ ���� ������ ����
	 * </b>
	 */
	public Stack()
	{
	     this.data = new List<T>();
	}

	/**
	 * <dt dir="rtl"  >
	 * <b>
	 * ������ ������ '���' �� ������� ������� ����, �'���' ����
	 * </b>
	 * 
	 * @return  `���` �� ������� ������� ����, �`���` ����
	 */
	public boolean isEmpty()
	{
		return(this.data.isEmpty());
	}
		
	/**
	 * <dt dir="rtl"  >
	 * <b>
	 * ������ ������ �� ���� x ���� ������� ������� (�����)
	 * </b>
	 * 
	 * @param x ��� ������ ���� �������
	 */
	public void push(T x)
	{
		this.data.insert(null,x);
	}

	/**
	 * <dt dir="rtl"  >
	 * <b>
	 * ������ ������ �� ���� ����� ������� ������� ������� ���� (�����)
	 * <br><u>����:</u> ������� ������� ���� ����
	 * </b>
	 * 
	 * @return ��� ����� �������
	 */
	public T pop()
	{
		T x = this.data.getFirst().getInfo();
		this.data.remove(this.data.getFirst());
		return(x);
	}
	
	/**
	 * <dt dir="rtl">
	 * <b>
	 * ������ ������ �� ���� ����� ������� ������� ���� �������
	 * <br><u>����:</u> ������� ������� ���� ����
	 * </b>
	 * 
	 * @return ��� ����� ������� ���� �������
	 */
	public T top()
	{
		return(this.data.getFirst().getInfo());
	}    
	
	/** 
	 * <dt dir="rtl">
	 * <b>
	 * ������ ������ ����� �� �������, ����� �� �����, ����� ���(x1 ��� ����� ����� �������):
     * [x1,x2,...,xn]
	 * </b>
	 * 
	 * @return ������ ������ �� �������
	 */
	public String toString()
	{	
		Node<T> pos = this.data.getFirst();
		
		String str = "[";
		while(pos!=null)
		{
			str = str + pos.getInfo().toString();
			if(pos.getNext()!=null)
				str = str + ",";
			pos = pos.getNext();
		}
		str = str + "]";
		
		return(str);
	}
}