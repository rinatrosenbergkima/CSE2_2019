//package unit4.collectionsLib;
package EduLibrary;

/** 
 * <h3 dir="rtl" style="color:red; font-family: Helvetica, Arial, sans-serif">
 * המחלקה מגדירה טיפוס אוסף עם פרוטוקול FIFO להכנסה והוצאה של ערכים.
 * </h3>
 * 
 * @author צוות מדעי המחשב, המרכז להוראת המדעים, האוניברסיטה העברית, ירושלים
 * @version 8.11.2007
 */
public class Queue<T>
{
	private List<T> data;	 // רשימה בה יאוחסנו ערכי התור
	private Node<T> lastPos; // (הפנייה לאיבר האחרון ברשימה(יעילות 
	
	/**
	 * <dt dir="rtl" >
	 * <b> 
	 * הפעולה בונה תור ריק
	 * </b>
	 */
	public Queue()
	{
		this.lastPos = null;
		this.data = new List<T>();
	}
	
	/**
	 * <dt dir="rtl" >
	 * <b>
	 * הפעולה מחזירה 'אמת' אם התור הנוכחי ריק, ו'שקר' אחרת
	 * </b>
	 * 
	 * @return `אמת` אם התור הנוכחי ריק, ו`שקר` אחרת
	 */
	public boolean isEmpty()
	{
		return(this.data.isEmpty());
	}
	
	/**
	 * <dt dir="rtl" >
	 * <b>
	 * הפעולה מכניסה את הערך x לסוף התור הנוכחי
	 * </b>
	 * 
	 * @param x הערך שיוכנס לסוף התור
	 */
	public void insert(T x)
	{
		this.lastPos = this.data.insert(this.lastPos,x);
	}
	
	/**
	 * <dt dir="rtl" >
	 * <b>
	 * הפעולה מוציאה את הערך שבראש התור הנוכחי ומחזירה אותו
	 * <br><u>הנחה:</u> התור הנוכחי אינו ריק
	 * </b>
	 * 
	 * @return הערך מראש התור 
	 */
	public T remove()
	{
		if(this.lastPos == this.data.getFirst())
			this.lastPos = null;
		T x = this.data.getFirst().getInfo();
		this.data.remove(this.data.getFirst());
		return(x);
	}
	
	/**
	 * <dt dir="rtl" >
	 * <b>
	 * הפעולה מחזירה את ערכו של האיבר שבראש התור מבלי להוציאו
	 * <br/><u>הנחה:</u> התור הנוכחי אינו ריק
	 * </b>
	 * 
	 * @return הערך בראש התור מבלי להוציאו
	 */
	public T head()
	{
		return(this.data.getFirst().getInfo());
	}
	
	/** 
	 * <dt dir="rtl" >
	 * <b>
	 * הפעולה מחזירה מחרוזת המתארת את התור כסדרה של ערכים, במבנה הזה(x1 הוא האיבר שבראש התור):
     * [x1,x2,...,xn]
	 * </b>
	 * 
	 * @return מחרוזת המתארת את התור
	 */
	public String toString()
	{	
		Node<T> pos = this.data.getFirst();
		
		String str = "[";
		while(pos!=null)
		{
			str = str + pos.getInfo().toString();
			if(pos.getNext() != null)
				str = str + ",";
			pos = pos.getNext();
		}
		str = str + "]";
		
		return(str);
	}
}
