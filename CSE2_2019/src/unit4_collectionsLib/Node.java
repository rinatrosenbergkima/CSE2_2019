package unit4_collectionsLib;


/** 
 * <h3 dir="rtl" style="color:red; font-family: Helvetica, Arial, sans-serif">
 * המחלקה מגדירה חוליה גנרית שבה ערך מטיפוס T והפניה לחוליה העוקבת.
 * </h3>
 * 
 * @author צוות מדעי המחשב, המרכז להוראת המדעים, האוניברסיטה העברית, ירושלים
 * @version 8.11.2007
 */
public class Node<T>
{
    private T info;
    private Node<T> next;

    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה בונה חוליה; ערך החוליה הוא x ואין לה חוליה עוקבת
     * </b>
	 * 
     * @param x ערך החוליה
     */
    public Node(T x)
    {
        this.info = x;
        this.next = null;
    }

    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה בונה חוליה; ערך החוליה הוא x והחוליה העוקבת לה היא next.
     * ערכו של next יכול להיות null
     * </b>
	 * 
     * @param x ערך החוליה
     * @param next הפניה לחוליה העוקבת
     */
    public Node(T x, Node<T> next)
    {
        this.info = x;
        this.next = next;
    }
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה מחזירה את הערך של החוליה
     * </b>
	 * 
	 * @return ערך החוליה
     */
    public T getInfo()
    {
        return(this.info);
    }
    
    /**
	 * <dt dir="rtl" >
	 * <b>
	 * הפעולה משנה את הערך השמור בחוליה ל-x
	 * </b>
	 * 
	 * @param x ערך החוליה החדש 
     */
    public void setInfo(T x)
    {
         this.info = x;
    }
    
    /**
	 * <dt dir="rtl" >
	 * <b>
	 * הפעולה מחזירה את החוליה העוקבת; אם אין חוליה עוקבת, הפעולה מחזירה null
	 * </b>
	 * 
	 * @return הפניה לחוליה העוקבת
     */
    public Node<T> getNext()
    {   
        return(this.next);
    }
    
    /**
	 * <dt dir="rtl" >
	 * <b>
	 * הפעולה משנה את החוליה העוקבת ל-next.
	 * ערכו של next יכול להיות null
	 * </b>
	 * 
	 * @param next הפניה לחוליה העוקבת
     */
    public void setNext(Node<T> next)
    {
         this.next = next;
    }
    
    /**
	 * <dt dir="rtl" >
	 * <b>
	 * הפעולה מחזירה מחרוזת המתארת את החוליה
	 * </b>
	 * 
	 * @return מחרוזת המתארת את החוליה
     */
    public String toString()
    {
    	return("" + this.info);
    }
}