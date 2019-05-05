package unit4_collectionsLib;

/** 
 * <h3 dir="rtl" style="color:red; font-family: Helvetica, Arial, sans-serif">
 * המחלקה מגדירה חוליה בינרית שבה ערך מטיפוס T ושתי הפניות לחוליות בינריות.
 * </h3>
 * 
 * @author צוות מדעי המחשב, המרכז להוראת המדעים, האוניברסיטה העברית, ירושלים
 * @version 18.11.2007
 */
public class BinTreeNode<T>
{
    private BinTreeNode<T> left;
    private T info;
    private BinTreeNode<T> right;
    
    /**
	 * <dt dir="rtl"/>
	 * <b>
     * הפעולה בונה חוליה בינרית; ערך החוליה הוא x וערך שתי ההפניות שלה הוא null
	 * </b>
	 * 
     * @param x ערך החוליה
     */
    public BinTreeNode(T x)
    {
    	this.left = null;
        this.info = x;
        this.right = null;
    }
    
    /**
	 * <dt dir="rtl"/>
	 * <b>
	 * הפעולה בונה חוליה בינרית שערכה יהיה x;
	 * left ו-right הן (הפניות אל) הילד השמאלי והימני שלה;
	 * ערכי ההפניות יכולים להיות null
	 * </b>
	 * 
	 * @param left תת-עץ שמאלי
     * @param x ערך החוליה
     * @param right תת-עץ ימני
     */
    public BinTreeNode(BinTreeNode<T> left, T x, BinTreeNode<T> right)
    {
    	this.left = left;
        this.info = x;
        this.right = right;
    }
    
    /**
	 * <dt dir="rtl"/>
	 * <b>
	 * הפעולה מחזירה את הערך של החוליה
	 * </b>
	 * 
	 * @return ערך החוליה
     */
    public T getInfo()
    {
        return this.info;
    }
    
    /**
	 * <dt dir="rtl"/>
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
	 * <dt dir="rtl"/>
	 * <b>
	 * הפעולה מחזירה את הילד השמאלי של החוליה;
	 * אם אין ילד שמאלי הפעולה מחזירה null
	 * </b>
	 * 
	 * @return הילד השמאלי
     */
    public BinTreeNode<T> getLeft()
    {   
        return this.left;
    }    
    
    /**
	 * <dt dir="rtl"/>
	 * <b>
	 * הפעולה מחזירה את הילד הימני של החוליה;
	 * אם אין ילד ימני הפעולה מחזירה null
	 * </b>
	 * 
	 * @return הילד הימני
     */
    public BinTreeNode<T> getRight()
    {   
        return this.right;
    }
    
    /**
	 * <dt dir="rtl"/>
	 * <b>
	 * הפעולה מחליפה את הילד השמאלי בחוליה left
	 * </b>
	 * 
	 * @param left הילד השמאלי החדש
     */
    public void setLeft(BinTreeNode<T> left)
    {
       this.left = left;
    }
    
    /**
	 * <dt dir="rtl"/>
	 * <b>
	 * הפעולה מחליפה את הילד הימני בחוליה right
	 * </b>
	 * 
	 * @param right הילד הימני החדש
     */
    public void setRight(BinTreeNode<T> right)
    {
    	this.right = right;
    }
    
    /**
	 * <dt dir="rtl"/>
     * <b>
     * הפעולה מחזירה מחרוזת המתארת את הערך השמור בחוליה
     * </b>
     * 
     * @return מחרוזת המתארת את הערך השמור בחוליה
     */
    public String toString()
    {
    	return this.info.toString();
    }   
}
