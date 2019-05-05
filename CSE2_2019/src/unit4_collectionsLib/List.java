package unit4_collectionsLib;
import java.util.Scanner;

/** 
 * <h3 dir="rtl" style="color:red; font-family: Helvetica, Arial, sans-serif">
 * המחלקה מגדירה אוסף סדרתי-לינארי שהגישה אל ערכיו מתבצעת בכל מקום באוסף.
 * </h3>
 * 
 * @author צוות מדעי המחשב, המרכז להוראת המדעים, האוניברסיטה העברית, ירושלים
 * @version 8.11.2007
 * @param <T> טיפוס הערכים ברשימה
 */
public class List<T>
{
    private Node<T> first;
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה בונה רשימה ריקה
     * </b>
     */
    public List()
    {
    	this.first = null; 
    }
   
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה מחזירה את המקום של החוליה הראשונה ברשימה הנוכחית; אם הרשימה ריקה, הפעולה תחזיר null
     * </b>
     * 
     * @return מיקום האיבר הראשון
     */
    public Node<T> getFirst()
    {   
		return(this.first);
    }       
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה מכניסה לרשימה הנוכחית את הערך x מקום אחד אחרי המקום pos;
     * אם pos הוא null, אז x יוכנס למקום הראשון ברשימה;
     * הפעולה מחזירה את המקום של החוליה החדשה שהוכנסה. 
     * <br>
     * <u>הנחה:</u> pos הוא מקום קיים ברשימה הנוכחית או null
     * </b>
     * 
     * @param pos מקום ברשימה אחריו יוכנס הערך
     * @param x ערך להכנסה
     * @return מיקום החוליה החדשה שהוכנסה 
     */
    public Node<T> insert(Node<T> pos, T x)
    {
    	Node<T> node = new Node<T>(x);
    	
    	if(pos == null)
    	{
    		node.setNext(this.first);
    		this.first = node;
    	}
    	else
    	{
            node.setNext(pos.getNext());
            pos.setNext(node);
    	}
        return(node);
    }
     
    /**
	 * <dt dir="rtl" >
	 * <b>
     * הפעולה מוציאה מהרשימה הנוכחית את האיבר הנמצא במקום pos, ומחזירה את המקום העוקב ל-pos; 
     * אם הוצא האיבר האחרון - יוחזר null
     * <br>
     * <u>הנחה:</u> pos הוא מקום ברשימה הנוכחית ואינו null.
     * </b>
	 * 
     * @param pos מקום ברשימה להוצאה
     * @return מקום העוקב ל pos  
     */
    public Node<T> remove(Node<T> pos)
	{   
		if(this.first == pos)
			this.first = pos.getNext(); 
		else
		{
  	    	Node<T> prevPos = this.getFirst();
  	    	while(prevPos.getNext() != pos)
  	    		prevPos = prevPos.getNext();
			prevPos.setNext(pos.getNext());
		}	
		
		Node<T> nextPos = pos.getNext();
		pos.setNext(null);
		
		return nextPos;
	} 
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה מחזירה 'אמת' אם הרשימה הנוכחית ריקה, ו'שקר' אחרת
     * </b>
     * 
     * @return `אמת` אם הרשימה הנוכחית ריקה, ו`שקר` אחרת
     */
    public boolean isEmpty()
    {
    	return(this.first == null);
    }
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה מחזירה תיאור של הרשימה, כסדרה של ערכים, במבנה הזה(x1 הוא האיבר הראשון ברשימה):
     * [x1,x2,...,xn]
     * </b>
     * 
     * @return מחרוזת המתארת את הרשימה
     */
    public String toString()
    {
    	String str = "[";
    	Node<T> pos = this.first;
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