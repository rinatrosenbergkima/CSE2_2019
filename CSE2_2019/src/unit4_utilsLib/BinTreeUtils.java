package unit4_utilsLib;

import unit4_collectionsLib.*;

/**
 * <h3 dir="rtl" style="color:red; font-family: Helvetica, Arial, sans-serif">
 * מחלקת שירות המכילה אוסף פעולות סטטיות שימושיות בעבודה עם עץ בינרי 
 * </h3>
 *
 * @author צוות מדעי המחשב, המרכז להוראת המדעים, האוניברסיטה העברית, ירושלים
 * @version 20.11.2006
 */
public final class BinTreeUtils
{	
	private BinTreeUtils(){}
	
	
	/** 
	 * <dt dir="rtl" >
     * <b>
	 * הפעולה מציגה את הבינרי המתקבל בצורה גרפית
     * </b>
	 *
	 * @param tree עץ בינרי גנרי
	 * @param title פרמטר אופציונאלי: כותרת החלון בו יוצג העץ הבינרי
	 */
	public static void showTree(Object tree, String... title)
	{
		if(!tree.getClass().getName().endsWith("BinTreeNode"))
		{
			System.err.println();
			System.err.println("Error using showTree: The first param must be BinTreeNode Object!!!");
			System.exit(0);
		}
		else
		{
			String str ="";
	    	for(String s : title)
				str = str + s;
			BinTreeViewer.show(tree,str);
		}
	}
	/**
	 * <dt dir="rtl" >
     * <b>
	 * הפעולה יוצרת ומחזירה עץ ביטוי חשבוני
     * </b>
	 * 
	 * @param exp מחרוזת המייצגת ביטוי חשבוני תקין
	 * @return עץ ביטוי חשבוני
	 */
	public static BinTreeNode<String> buildExpressionTree(String exp)
	{
		return(Parser.parse(exp));
	}
	
	/**
	 * <dt dir="rtl" >
     * <b>
	 * הפעולה יוצרת ומחזירה עץ בינרי אקראי עם ערכים מספריים אקראיים
     * </b>
	 * 
	 * @param maxNodes מספר צמתים מקסימלי
	 * @param low ערך מינימלי שיכול להיות בעץ
	 * @param high ערך מקסימלי שיכול להיות בעץ
	 * @return עץ בינרי עם ערכים אקראיים
	 */
	public static BinTreeNode<Integer> buildRandomTree(int maxNodes, int low, int high)
	{
		int dir=0;
		BinTreeNode<Integer> t1,t2=null;
		int x = (int)(Math.random()*(high-low+1)+low);
		BinTreeNode<Integer> tree = new BinTreeNode<Integer>(x);
		
		for(int i=2; i<=maxNodes; i++)
		{
			t1 = tree;
			while(t1 != null)
			{
				t2 = t1;
				dir = (int)(Math.random()*2);
				if(dir==1)
					t1 = t1.getLeft();
				else
					t1 = t1.getRight();
			}
			x = (int)(Math.random()*(high-low+1)+low);
			if(dir==1)
				t2.setLeft(new BinTreeNode<Integer>(x));
			else
				t2.setRight(new BinTreeNode<Integer>(x));
		}
		
		return(tree);
	}
	
	//----------------------- traversals --------------------------
	/**
	 * <dt dir="rtl" >
     * <b>
	 * פעולה המחזירה מחרוזת המתארת את סריקת העץ בסדר תחילי
     * </b>
	 * 
	 * @param tree עץ בינרי גנרי
	 * @return מחרוזת המתארת את סריקת העץ בסדר תחילי
	 */
	public static String preOrderTraversal(BinTreeNode<?> tree)
	{
		String str = new String();
		
		str = str + tree.getInfo() + " , ";
		
		if (tree.getLeft() != null)
			str = str + preOrderTraversal(tree.getLeft());
		
		if (tree.getRight() != null)
			str = str + preOrderTraversal(tree.getRight());
		
		return(str);
	}
	
	/**
	 * <dt dir="rtl" >
     * <b>
	 * פעולה המחזירה מחרוזת המתארת את סריקת העץ בסדר תוכי
     * </b>
	 * 
	 * @param tree עץ בינרי גנרי
	 * @return מחרוזת המתארת את סריקת העץ בסדר תוכי
	 */
	public static String inOrderTraversal(BinTreeNode<?> tree)
	{
		String str = new String();
		
		if (tree.getLeft() != null)
			str = str + inOrderTraversal(tree.getLeft());
		
		str = str + tree.getInfo() + " , ";
		
		if (tree.getRight() != null)
			str = str + inOrderTraversal(tree.getRight());
		
		return(str);
	}
	
	/**
	 * <dt dir="rtl" >
     * <b>
	 * פעולה המחזירה מחרוזת המתארת את סריקת העץ בסדר סופי
     * </b>
	 * 
	 * @param tree עץ בינרי גנרי
	 * @return מחרוזת המתארת את סריקת העץ בסדר סופי
	 */
	public static String postOrderTraversal(BinTreeNode<?> tree)
	{
		String str = new String();
		
		if (tree.getLeft() != null)
			str = str + postOrderTraversal(tree.getLeft());
		
		if (tree.getRight() != null)
			str = str + postOrderTraversal(tree.getRight());
		
		str = str + tree.getInfo() + " , ";
		
		return(str);
	}
	
	/*
	public static <T> String inOrderTraversal2(BinTree<T> tree)
	{
		BinTree<T> t = tree;
		String str = new String();
		Stack<BinTree<T>> stack = new Stack<BinTree<T>>();
		
		do
		{
			while(t != null)
			{
				stack.push(t);
				t = t.getLeft();
			}
			if(!stack.isEmpty())
			{
				t = stack.pop();
				str = str + t.getInfo() + " ";
				t = t.getRight();
			}
		} while(!stack.isEmpty() || t != null);
		
		return(str);
	}
	*/
	
	/**
	 * <dt dir="rtl" >
     * <b>
	 * פעולה המחזירה מחרוזת המתארת את סריקת העץ לפי רמות
     * </b>
	 * 
	 * @param tree עץ בינרי גנרי
	 * @return מחרוזת המתארת את סריקת העץ לפי רמות
	 */
    public static String levelOrderTraversal(BinTreeNode<?> tree)
	{
		BinTreeNode<?> t;
		String str = new String();
		Queue<BinTreeNode<?>> q = new Queue<BinTreeNode<?>>();
		
		q.insert(tree);
		while(!q.isEmpty())
		{
			t = q.remove();
			str = str + t.getInfo() + " , ";
			if(t.getLeft() != null)
				q.insert(t.getLeft());
			if(t.getRight() != null)
				q.insert(t.getRight());
		}
			
		return(str);
	}
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * פעולה המחזירה את גובה העץ (עץ עלה גובהו 0)
     * </b>
	 * 
	 * @param tree עץ בינרי גנרי
	 * @return גובה העץ
     */
	public static int height(BinTreeNode<?> tree)
    {
    	int hl = 0;
    	int hr = 0;
    	
    	if(tree.getLeft() != null)
    		hl = 1 + height(tree.getLeft());
    	if(tree.getRight() != null)
    		hr = 1 + height(tree.getRight());
    	return(Math.max(hl,hr));
    }    
	
	/* פעולה זו גם מחשבת בצורה תקינה את גובה העץ, אבל לא מומלץ לכתוב כך
	public static <T> int height2(BinTree<T> t)
	{
		if(t==null)
			return(-1);
		else
			return(1 + Math.max(height2(t.getLeft()),height2(t.getRight())));
	}   
	*/
	
	/**
	 * <dt dir="rtl" >
     * <b>
	 * הפעולה מחזירה את מספר הצמתים בעץ
     * </b>
	 * 
	 * @param tree עץ בינרי גנרי
	 * @return מספר הצמתים בעץ
	 */
	public static int numOfNodes(BinTreeNode<?> tree)
	{
		int nl = 0;
		int nr = 0;
		
		if(tree.getLeft() != null)
			nl = numOfNodes(tree.getLeft());
		if(tree.getRight() != null)
			nr = numOfNodes(tree.getRight());
		return(1 + nl + nr);
	}
	 
    /* פעולה זו גם מחשבת בצורה תקינה את מספר הצמתים בעץ - דרך נוספת
    public static <T> int numOfNodes2(BinTree<T> tree)
    {
    	int n = 0;
    	
    	if(tree.getLeft() != null)
    		n = numOfNodes2(tree.getLeft());
    	if(tree.getRight() != null)
    		n = n + numOfNodes2(tree.getRight());
    	return(1 + n);
    }    
    
    // פעולה זו גם מחשבת בצורה תקינה את מספר הצמתים בעץ, אבל לא מומלץ לכתוב כך
    public static <T> int numOfNodes3(BinTree<T> tree)
    {
    	if(tree==null)
    		return(0);
    	else
    		return(1 + numOfNodes3(tree.getLeft()) + numOfNodes3(tree.getRight()));
    }    
    */
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה מחזירה עץ בינרי חדש שהוא העתק מדוייק (שכפול) של העץ שהתקבל
     * </b>
	 * 
	 * @param tree עץ בינרי גנרי
	 * @return עץ בינרי 
     */
	public static <T> BinTreeNode<T> clone(BinTreeNode<T> tree)
	{
		BinTreeNode<T> left = null;
		BinTreeNode<T> right = null;
		
		if(tree.getLeft() != null)
			left = clone(tree.getLeft());
		if(tree.getRight() != null)
			right = clone(tree.getRight());
	
		return(new BinTreeNode<T>(left, tree.getInfo(), right));
	}
	 
	/**
	 * מחזירה עץ 'פירמידה' של מספרים שלמים
	 */
//    private static BinTree<Integer> createPiramidTree(int h)
//    {
//    	if(h == 0)
//    		return(new BinTree<Integer>(0));
//    	return(new BinTree<Integer>(h, createPiramidTree(h-1),createPiramidTree(h-1)));
//    }
    
    /* פעולה זו גם יוצרת עץ פירמידה
    public static BinTree<Integer> createPiramidTree2(int h)
    {
    	BinTree<Integer> t = new BinTree<Integer>(h);
    	if(h > 0)
    	{
    		t.setLeft(createPiramidTree2(h-1));
    		t.setRight(createPiramidTree2(h-1));
    	}
       	return(t);
    }
    */
    
    //h בודק האם העץ הוא עץ פירמידה בגובה
//    private static boolean isPyramidTree(BinTree<Integer> tree, int h)
//    {
//    	if(tree.getInfo() != h)
//    		return(false);
//    	
//    	if(BinTreeUtils.isLeaf(tree) && h==0)
//    		return(true);
//    	
//    	if(tree.getLeft()==null || tree.getRight()==null)
//    		return(false);
//    	
//    	return(isPyramidTree(tree.getLeft(),h-1) && isPyramidTree(tree.getRight(),h-1));
//    }
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה בודקת האם העץ מלא
     * </b>
	 * 
	 * @param tree עץ בינרי גנרי
	 * @return הפעולה מחזירה 'אמת' אם העץ מלא, ו'שקר' אחרת 
     */
    public static boolean isFull(BinTreeNode<?> tree)
    {   	
    	if(BinTreeUtils.isLeaf(tree))
    		return(true);
    	
    	if(tree.getLeft()==null || tree.getRight()==null)
    		return(false);
    	
    	if(BinTreeUtils.height(tree.getLeft()) != BinTreeUtils.height(tree.getRight()))
    		return(false);
    	
    	return(isFull(tree.getLeft()) && isFull(tree.getRight()));
    }
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה מחזירה את הערך הגדול ביותר בעץ בינרי של מספרים שלמים
     * </b>
	 * 
	 * @param tree עץ בינרי של מספרים שלמים
	 * @return הערך הגדול ביותר בעץ 
     */   
    public static int max(BinTreeNode<Integer> tree)
    {
    	int ml = tree.getInfo();
    	int mr = tree.getInfo();
    	
    	if(tree.getLeft() != null)
    		ml = Math.max(tree.getInfo(),max(tree.getLeft()));
    	if(tree.getRight() != null)
    		mr = Math.max(tree.getInfo(),max(tree.getRight()));
    	return(Math.max(ml,mr));
    }    
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה מחזירה את סכום הצמתים בעץ בינרי של מספרים שלמים
     * </b>
	 * 
	 * @param tree עץ בינרי של מספרים שלמים
	 * @return סכום כל ערכי הצמתים בעץ 
     */    
    public static int sumOfNodes(BinTreeNode<Integer> tree)
    {
    	int sl = 0;
    	int sr = 0;
    	
    	if(tree.getLeft() != null)
    		sl = sumOfNodes(tree.getLeft());
    	if(tree.getRight() != null)
    		sr = sumOfNodes(tree.getRight());
    	return(tree.getInfo() + sl + sr);
    }    
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה מחזירה את סכום הצמתים ברמה מסויימת בעץ בינרי של מספרים שלמים
     * </b>
	 * 
	 * @param tree עץ בינרי של מספרים שלמים
	 * @param level רמה בעץ(מספר גדול או שווה לאפס)
	 * @return סכום הצמתים ברמה מסויימת בעץ 
     */   
    public static int sumOfNodesInLevel(BinTreeNode<Integer> tree, int level)
    {
    	int sl = 0;
    	int sr = 0;
    	
    	if(level==0)
    		return(tree.getInfo());
    	if(tree.getLeft() != null)
    		sl = sumOfNodesInLevel(tree.getLeft(),level-1);
    	if(tree.getRight() != null)
    		sr = sumOfNodesInLevel(tree.getRight(),level-1);
    	return(sl + sr);
    }    
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה שבודקת האם כל הצמתים בעץ חיוביים
     * </b>
	 * 
	 * @param tree עץ בינרי של מספרים שלמים
	 * @return מחזירה 'אמת' אם כל הצמתים בעץ חיוביים, ו'שקר' אחרת 
     */  
    public static boolean isAllPositive(BinTreeNode<Integer> tree)
    {
    	boolean resL = true;
    	boolean resR = true;
    	
    	if(tree.getInfo() < 0)
    		return(false);
    	if(tree.getLeft() != null)
    		resL = isAllPositive(tree.getLeft());
    	if(tree.getRight() != null)
    		resR = isAllPositive(tree.getRight());
    	return(resL && resR);
    }    
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה שבודקת האם ערך מסויים נמצא בעץ
     * </b>
	 * 
	 * @param tree עץ בינרי של מספרים שלמים
	 * @param x ערך לחיפוש
	 * @return הפעולה מחזירה 'אמת' אם הערך המתקבל נמצא בעץ, ו'שקר' אחרת 
     */   
    public static boolean exists(BinTreeNode<Integer> tree, int x)
    {
    	boolean resL = false;
    	boolean resR = false;
    	
    	if(tree.getInfo()==x)
    		return(true);
    	if(tree.getLeft() != null)
    		resL = exists(tree.getLeft(),x);
    	if(tree.getRight() != null)
    		resR = exists(tree.getRight(),x);
    	return(resL || resR);
    }    
    //null רצוי לכתוב פעולה שמחזירה הפנייה לערך אם קיים אחרת יוחזר 
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה שבודקת האם העץ שמתקבל הוא עץ עלה
     * </b>
	 * 
	 * @param tree עץ בינרי גנרי
	 * @return הפעולה מחזירה 'אמת' אם העץ הוא עץ עלה, ו'שקר' אחרת 
     */
    public static boolean isLeaf(BinTreeNode<?> tree)
    {
    	return((tree.getLeft()==null) && (tree.getRight()==null));
    }
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * הפעולה מחזירה את מספר העלים בעץ
     * </b>
	 * 
	 * @param tree עץ בינרי גנרי
	 * @return מספר העלים בעץ 
     */     
    public static int numOfLeaves(BinTreeNode<?> tree)
    {
    	int nl = 0;
    	int nr = 0;
    	
    	if(tree.getLeft()==null && tree.getRight()==null)
    		return(1);
    	if(tree.getLeft() != null)
    		nl = numOfLeaves(tree.getLeft());
    	if(tree.getRight() != null)
    		nr = numOfLeaves(tree.getRight());
    	return(nl + nr);
    }   
    
//    private static int numOfLeaves2(BinTree<?> tree)
//    {
//    	if(tree == null)
//    		return(0);
//    	if(tree.getLeft()==null && tree.getRight()==null)
//    		return(1);
//    	return(numOfLeaves(tree.getLeft()) + numOfLeaves(tree.getRight()));
//    }   
    
    /* error!!!
    public static <T> int alim(BinTree<T> t)
	{
		if(isLeaf(t))
			return(1);
		if(t.getLeft() != null)
			return(alim(t.getLeft()));
		if(t.getRight() != null)
			return(alim(t.getRight()));
		return(alim(t.getLeft())+alim(t.getRight())+1);
	}
    */
    
    /**
	 * <dt dir="rtl" >
     * <b>
     *  הפעולה מחזירה את ההורה של צומת מסוים בעץ; במידה והצומת הוא שורש העץ יוחזר null 
     * </b>
	 * 
	 * @param tree עץ בינרי גנרי
	 * @param child הפנייה לצומת בעץ
	 * @return הפנייה לשורש העץ שהוא הורה
     */
    public static BinTreeNode<?> parent(BinTreeNode<?> tree, BinTreeNode<?> child)
    {	
    	if((tree == null) || (child == tree.getLeft()) || (child == tree.getRight()))
    		return(tree);
    	BinTreeNode<?> tmp = parent(tree.getLeft(),child);
    	if(tmp == null)
    		return(parent(tree.getRight(),child));
    	else
    		return(tmp);
    }
}
