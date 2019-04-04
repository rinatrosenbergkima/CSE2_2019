//package unit4.collectionsLib;
package EduLibrary;

/** 
 * <h3 dir="rtl" style="color:red; font-family: Helvetica, Arial, sans-serif">
 * המחלקה מגדירה טיפוס אוסף בעל פרוטוקול LIFO להכנסה והוצאה של ערכים. 
 * </h3>
 * 
 * @author צוות מדעי המחשב, המרכז להוראת המדעים, האוניברסיטה העברית, ירושלים
 * @version 8.11.2007
 */
public class Stack<T>
{
	private List<T> data;  //רשימה בה יאוחסנו ערכי המחסנית
	
	/**
	 * <dt dir="rtl">
	 * <b>
	 * הפעולה בונה מחסנית ריקה
	 * </b>
	 */
	public Stack()
	{
	     this.data = new List<T>();
	}

	/**
	 * <dt dir="rtl"  >
	 * <b>
	 * הפעולה מחזירה 'אמת' אם המחסנית הנוכחית ריקה, ו'שקר' אחרת
	 * </b>
	 * 
	 * @return  `אמת` אם המחסנית הנוכחית ריקה, ו`שקר` אחרת
	 */
	public boolean isEmpty()
	{
		return(this.data.isEmpty());
	}
		
	/**
	 * <dt dir="rtl"  >
	 * <b>
	 * הפעולה מכניסה את הערך x לראש המחסנית הנוכחית (דחיפה)
	 * </b>
	 * 
	 * @param x ערך להכנסה לראש המחסנית
	 */
	public void push(T x)
	{
		this.data.insert(null,x);
	}

	/**
	 * <dt dir="rtl"  >
	 * <b>
	 * הפעולה מוציאה את הערך שבראש המחסנית הנוכחית ומחזירה אותו (שליפה)
	 * <br><u>הנחה:</u> המחסנית הנוכחית אינה ריקה
	 * </b>
	 * 
	 * @return ערך שבראש המחסנית
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
	 * הפעולה מחזירה את הערך שבראש המחסנית הנוכחית מבלי להוציאו
	 * <br><u>הנחה:</u> המחסנית הנוכחית אינה ריקה
	 * </b>
	 * 
	 * @return ערך שבראש המחסנית מבלי להוציאו
	 */
	public T top()
	{
		return(this.data.getFirst().getInfo());
	}    
	
	/** 
	 * <dt dir="rtl">
	 * <b>
	 * הפעולה מחזירה תיאור של המחסנית, כסדרה של ערכים, במבנה הזה(x1 הוא האיבר שבראש המחסנית):
     * [x1,x2,...,xn]
	 * </b>
	 * 
	 * @return מחרוזת המתארת את המחסנית
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