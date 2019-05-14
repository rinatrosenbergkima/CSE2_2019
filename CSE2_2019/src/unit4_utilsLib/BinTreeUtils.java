package unit4_utilsLib;
import unit4_collectionsLib.BinTreeNode;
import unit4_collectionsLib.Queue;

/**
 * <h3 dir="rtl" style="color:red; font-family: Helvetica, Arial, sans-serif">
 * îçì÷ú ùéøåú äîëéìä àåñó ôòåìåú ñèèéåú ùéîåùéåú áòáåãä òí òõ áéðøé 
 * </h3>
 *
 * @author öååú îãòé äîçùá, äîøëæ ìäåøàú äîãòéí, äàåðéáøñéèä äòáøéú, éøåùìéí
 * @version 20.11.2006
 */
public final class BinTreeUtils
{	
	private BinTreeUtils(){}
	
	
	/** 
	 * <dt dir="rtl" >
     * <b>
	 * äôòåìä îöéâä àú äáéðøé äîú÷áì áöåøä âøôéú
     * </b>
	 *
	 * @param tree òõ áéðøé âðøé
	 * @param title ôøîèø àåôöéåðàìé: ëåúøú äçìåï áå éåöâ äòõ äáéðøé
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
			//BinTreeViewer.show(tree,str);
		}
	}
	/**
	 * <dt dir="rtl" >
     * <b>
	 * äôòåìä éåöøú åîçæéøä òõ áéèåé çùáåðé
     * </b>
	 * 
	 * @param exp îçøåæú äîééöâú áéèåé çùáåðé ú÷éï
	 * @return òõ áéèåé çùáåðé
	 */
	public static BinTreeNode<String> buildExpressionTree(String exp)
	{
		return(Parser.parse(exp));
	}
	
	/**
	 * <dt dir="rtl" >
     * <b>
	 * äôòåìä éåöøú åîçæéøä òõ áéðøé à÷øàé òí òøëéí îñôøééí à÷øàééí
     * </b>
	 * 
	 * @param maxNodes îñôø öîúéí î÷ñéîìé
	 * @param low òøê îéðéîìé ùéëåì ìäéåú áòõ
	 * @param high òøê î÷ñéîìé ùéëåì ìäéåú áòõ
	 * @return òõ áéðøé òí òøëéí à÷øàééí
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
	 * ôòåìä äîçæéøä îçøåæú äîúàøú àú ñøé÷ú äòõ áñãø úçéìé
     * </b>
	 * 
	 * @param tree òõ áéðøé âðøé
	 * @return îçøåæú äîúàøú àú ñøé÷ú äòõ áñãø úçéìé
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
	 * ôòåìä äîçæéøä îçøåæú äîúàøú àú ñøé÷ú äòõ áñãø úåëé
     * </b>
	 * 
	 * @param tree òõ áéðøé âðøé
	 * @return îçøåæú äîúàøú àú ñøé÷ú äòõ áñãø úåëé
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
	 * ôòåìä äîçæéøä îçøåæú äîúàøú àú ñøé÷ú äòõ áñãø ñåôé
     * </b>
	 * 
	 * @param tree òõ áéðøé âðøé
	 * @return îçøåæú äîúàøú àú ñøé÷ú äòõ áñãø ñåôé
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
	 * ôòåìä äîçæéøä îçøåæú äîúàøú àú ñøé÷ú äòõ ìôé øîåú
     * </b>
	 * 
	 * @param tree òõ áéðøé âðøé
	 * @return îçøåæú äîúàøú àú ñøé÷ú äòõ ìôé øîåú
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
     * ôòåìä äîçæéøä àú âåáä äòõ (òõ òìä âåáäå 0)
     * </b>
	 * 
	 * @param tree òõ áéðøé âðøé
	 * @return âåáä äòõ
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
	
	/* ôòåìä æå âí îçùáú áöåøä ú÷éðä àú âåáä äòõ, àáì ìà îåîìõ ìëúåá ëê
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
	 * äôòåìä îçæéøä àú îñôø äöîúéí áòõ
     * </b>
	 * 
	 * @param tree òõ áéðøé âðøé
	 * @return îñôø äöîúéí áòõ
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
	 
    /* ôòåìä æå âí îçùáú áöåøä ú÷éðä àú îñôø äöîúéí áòõ - ãøê ðåñôú
    public static <T> int numOfNodes2(BinTree<T> tree)
    {
    	int n = 0;
    	
    	if(tree.getLeft() != null)
    		n = numOfNodes2(tree.getLeft());
    	if(tree.getRight() != null)
    		n = n + numOfNodes2(tree.getRight());
    	return(1 + n);
    }    
    
    // ôòåìä æå âí îçùáú áöåøä ú÷éðä àú îñôø äöîúéí áòõ, àáì ìà îåîìõ ìëúåá ëê
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
     * äôòåìä îçæéøä òõ áéðøé çãù ùäåà äòú÷ îãåéé÷ (ùëôåì) ùì äòõ ùäú÷áì
     * </b>
	 * 
	 * @param tree òõ áéðøé âðøé
	 * @return òõ áéðøé 
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
	 * îçæéøä òõ 'ôéøîéãä' ùì îñôøéí ùìîéí
	 */
//    private static BinTree<Integer> createPiramidTree(int h)
//    {
//    	if(h == 0)
//    		return(new BinTree<Integer>(0));
//    	return(new BinTree<Integer>(h, createPiramidTree(h-1),createPiramidTree(h-1)));
//    }
    
    /* ôòåìä æå âí éåöøú òõ ôéøîéãä
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
    
    //h áåã÷ äàí äòõ äåà òõ ôéøîéãä áâåáä
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
     * äôòåìä áåã÷ú äàí äòõ îìà
     * </b>
	 * 
	 * @param tree òõ áéðøé âðøé
	 * @return äôòåìä îçæéøä 'àîú' àí äòõ îìà, å'ù÷ø' àçøú 
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
     * äôòåìä îçæéøä àú äòøê äâãåì áéåúø áòõ áéðøé ùì îñôøéí ùìîéí
     * </b>
	 * 
	 * @param tree òõ áéðøé ùì îñôøéí ùìîéí
	 * @return äòøê äâãåì áéåúø áòõ 
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
     * äôòåìä îçæéøä àú ñëåí äöîúéí áòõ áéðøé ùì îñôøéí ùìîéí
     * </b>
	 * 
	 * @param tree òõ áéðøé ùì îñôøéí ùìîéí
	 * @return ñëåí ëì òøëé äöîúéí áòõ 
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
     * äôòåìä îçæéøä àú ñëåí äöîúéí áøîä îñåééîú áòõ áéðøé ùì îñôøéí ùìîéí
     * </b>
	 * 
	 * @param tree òõ áéðøé ùì îñôøéí ùìîéí
	 * @param level øîä áòõ(îñôø âãåì àå ùååä ìàôñ)
	 * @return ñëåí äöîúéí áøîä îñåééîú áòõ 
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
     * äôòåìä ùáåã÷ú äàí ëì äöîúéí áòõ çéåáééí
     * </b>
	 * 
	 * @param tree òõ áéðøé ùì îñôøéí ùìîéí
	 * @return îçæéøä 'àîú' àí ëì äöîúéí áòõ çéåáééí, å'ù÷ø' àçøú 
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
     * äôòåìä ùáåã÷ú äàí òøê îñåééí ðîöà áòõ
     * </b>
	 * 
	 * @param tree òõ áéðøé ùì îñôøéí ùìîéí
	 * @param x òøê ìçéôåù
	 * @return äôòåìä îçæéøä 'àîú' àí äòøê äîú÷áì ðîöà áòõ, å'ù÷ø' àçøú 
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
    //null øöåé ìëúåá ôòåìä ùîçæéøä äôðééä ìòøê àí ÷ééí àçøú éåçæø 
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * äôòåìä ùáåã÷ú äàí äòõ ùîú÷áì äåà òõ òìä
     * </b>
	 * 
	 * @param tree òõ áéðøé âðøé
	 * @return äôòåìä îçæéøä 'àîú' àí äòõ äåà òõ òìä, å'ù÷ø' àçøú 
     */
    public static boolean isLeaf(BinTreeNode<?> tree)
    {
    	return((tree.getLeft()==null) && (tree.getRight()==null));
    }
    
    /**
	 * <dt dir="rtl" >
     * <b>
     * äôòåìä îçæéøä àú îñôø äòìéí áòõ
     * </b>
	 * 
	 * @param tree òõ áéðøé âðøé
	 * @return îñôø äòìéí áòõ 
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
     *  äôòåìä îçæéøä àú ääåøä ùì öåîú îñåéí áòõ; áîéãä åäöåîú äåà ùåøù äòõ éåçæø null 
     * </b>
	 * 
	 * @param tree òõ áéðøé âðøé
	 * @param child äôðééä ìöåîú áòõ
	 * @return äôðééä ìùåøù äòõ ùäåà äåøä
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
