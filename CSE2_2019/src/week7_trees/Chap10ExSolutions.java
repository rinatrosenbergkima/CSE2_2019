package week7_trees;
import java.util.Scanner;
import unit4_collectionsLib.*;
import unit4_utilsLib.*;

/**
 * פתרונות לשאלות מפרק 10 עץ בינרי
 *  
 * @author צוות מדעי המחשב, המרכז להוראת המדעים, האוניברסיטה העברית, ירושלים
 * @version 26/11/2007
 */
public class Chap10ExSolutions
{

	public static void main(String[] args)
	{
		BinTreeNode<Integer> bt1 = BinTreeUtils.buildRandomTree(10, 2, 4);
		BinTreeUtils.showTree(bt1, "bt1");
		System.out.println(sumOfsingelLeftChild(bt1));
		System.out.println(sumOfsingelRightChild(bt1));
		System.out.println(diff3(bt1));
		System.out.println(diff2(bt1));
		System.out.println(diff1(bt1));

		
		BinTreeNode<Integer> bt2 = buildIdent1(bt1);
		BinTreeUtils.showTree(bt2, "bt2");

		
		BinTreeNode<Integer> bt3 = buildRandomTree(1);
		BinTreeUtils.showTree(bt3, "bt3");

		
		Scanner input = new Scanner(System.in).useDelimiter(""); //לקריאת תו אחר תו
		System.out.print("Enter expression: ");
		BinTreeNode<Character> bt4 = buildExpTree(input);
		BinTreeUtils.showTree(bt4, "bt4");


		System.out.println(numNodesInLevel(bt1,3));


		System.out.println(levelOrderList(bt1));
	}
	

	// =================== תשובה לתרגיל 10 פרק 10 ======================
	// רשימה של איברי העץ בסדר של סריקה לפי רמות
	public static List<Integer> levelOrderList(BinTreeNode<Integer> bt)
	{
		Node<Integer> pos = null;
		List<Integer> lst = new List<Integer>();

		BinTreeNode<Integer> node;
		Queue<BinTreeNode<Integer>> q = new Queue<BinTreeNode<Integer>>();

		q.insert(bt);
		while(!q.isEmpty())
		{
			node = q.remove();
			pos = lst.insert(pos, node.getInfo());
			if(node.getLeft() != null)
				q.insert(node.getLeft());
			if(node.getRight() != null)
				q.insert(node.getRight());
		}

		return lst;
	}

	
	// =================== תשובה לתרגיל 11 פרק 10 ======================
	// ספירת תווים
	public static int count(BinTreeNode<Character> bt, char ch)
	{
		if(bt == null)
			return 0;

		int exists = 0;
		if(bt.getInfo() == ch)
			exists = 1;

		return exists + count(bt.getLeft(),ch) + count(bt.getRight(),ch);
	}
	
	
	// =================== תשובה לתרגיל 12 פרק 10 ======================
	// הדפסת מחרוזות
	public static void printStrings(BinTreeNode<String> bt, char ch)
	{
		if(bt != null)
		{
			if(bt.getInfo().indexOf(ch)!=-1)
				System.out.println(bt.getInfo());
			printStrings(bt.getLeft(), ch);
			printStrings(bt.getRight(), ch);
		}	
	}
	
	// =================== תשובה לתרגיל 13 פרק 10 ======================
	// החלפת מחרוזות
	public static void replace(BinTreeNode<String> bt, String s1, String s2)
	{
		if(bt != null)
		{
			if(bt.getInfo().equals(s1))
				bt.setInfo(s2);
			replace(bt.getLeft(), s1, s2);
			replace(bt.getRight(), s1, s2);
		}	
	}

	
	// =================== תשובה לתרגיל 14 פרק 10 ======================
	// גובה עץ
	public static int height(BinTreeNode<?> tree)
	{
		int hl = 0;
		int hr = 0;

		if(tree.getLeft() != null)
			hl = 1 + height(tree.getLeft());
		if(tree.getRight() != null)
			hr = 1 + height(tree.getRight());
		
		return Math.max(hl,hr);
	}  
	
	
	// =================== תשובה לתרגיל 15 פרק 10 ======================
	// מספר צמתים ברמה נתונה בעץ
	public static int numNodesInLevel(BinTreeNode<Integer> bt, int level)
	{
		if(bt == null)
			return 0;

		if(level==0)
			return 1;

		return numNodesInLevel(bt.getLeft(),level-1) + numNodesInLevel(bt.getRight(),level-1);
	}
	
	
	// =================== תשובה לתרגיל 16 פרק 10 ======================
	// שתי גירסאות: בניית עץ זהה
	// 1.
	public static BinTreeNode<Integer> buildIdent1(BinTreeNode<Integer> bt)
	{	
		if(bt == null)
			return null;
		return new BinTreeNode<Integer>(buildIdent1(bt.getLeft()), bt.getInfo(), buildIdent1(bt.getRight()));
	}

	// 2. 
	public static BinTreeNode<String> buildIdent2(BinTreeNode<String> bt)
	{
		BinTreeNode<String> left = null;
		BinTreeNode<String> right = null;

		if(bt.getLeft() != null)
			left = buildIdent2(bt.getLeft());
		if(bt.getRight() != null)
			right = buildIdent2(bt.getRight());

		return new BinTreeNode<String>(left, bt.getInfo(), right);
	}
	 
	
	
	// =================== תשובה לתרגיל 17 פרק 10 ======================
	// שתי גירסאות: האם עץ מלא	
	// 1. 
	public static boolean isFull1(BinTreeNode<Integer> bt)
	{   	
		if(bt.getLeft()==null && bt.getRight()==null)
			return true;

		if(bt.getLeft()==null || bt.getRight()==null)
			return false;

		if(height(bt.getLeft()) != height(bt.getRight()))
			return false;

		return isFull1(bt.getLeft()) && isFull1(bt.getRight());
	}
	// 2.
	public static boolean isFull2(BinTreeNode<Integer> bt)
	{   	
		int h = height(bt);  // גובה העץ
		int n = numOfNodes(bt);  // מספר הצמתים בעץ

		return (Math.pow(2,h+1)-1) == n;
	}
	// פעולת עזר: מחזירה את מספר הצמתים בעץ
	public static int numOfNodes(BinTreeNode<Integer> bt)
	{
		if(bt==null)
			return 0;

		return 1 + numOfNodes(bt.getLeft()) + numOfNodes(bt.getRight());
	}
	
	// =================== תשובה לתרגיל 18 פרק 10 ======================
	// שתי גירסאות: להחזרת ההורה של צומת נתון	
	// 1. גירסה רקורסיבית
	public static BinTreeNode<Integer> parent1(BinTreeNode<Integer> bt, BinTreeNode<Integer> child)
	{	
		if((bt == null) || (child == bt.getLeft()) || (child == bt.getRight()))
			return bt;

		BinTreeNode<Integer> node = parent1(bt.getLeft(),child);

		if(node == null)
			return parent1(bt.getRight(),child);
		else
			return node;
	}
	//2. גירסה לא רקורסיבית המשתמשת בתור - סריקה לפי רמות
	public static BinTreeNode<Integer> parent2(BinTreeNode<Integer> bt, BinTreeNode<Integer> child)
	{
		BinTreeNode<Integer> t;
		Queue<BinTreeNode<Integer>> q = new Queue<BinTreeNode<Integer>>();

		q.insert(bt);
		while (!q.isEmpty())
		{
			t = q.remove();
			if (t.getLeft() == child || t.getRight() == child)
				return t;


			if (t.getLeft() != null)
				q.insert (t.getLeft());
			if (t.getRight() != null)
				q.insert (t.getRight());
		}
		return null;
	}	   

	
	// =================== תשובה לתרגיל 19 פרק 10 ======================
	// בניית עץ בינרי אקראי שגובהו לכל היותר מתקבל כפרמטר	
	public static BinTreeNode<Integer> buildRandomTree(int maxLevels)
	{
		if(maxLevels==0)
			return new BinTreeNode<Integer>((int)(Math.random()*100));

		int rnd = (int)(Math.random()*6);
		int x = (int)(Math.random()*100);

		if(rnd == 0)	// עלה
		return new BinTreeNode<Integer>((int)(Math.random()*100));

		if(rnd==1)	//בן שמאלי בודד
			return new BinTreeNode<Integer>(buildRandomTree(maxLevels-1),x,null);

		if(rnd==2) // בן ימני בודד
			return new BinTreeNode<Integer>(null,x,buildRandomTree(maxLevels-1));

		// שני בנים
		return new BinTreeNode<Integer>(buildRandomTree(maxLevels-1),x,buildRandomTree(maxLevels-1));
	}

	
	// =================== תשובה לתרגיל 20 פרק 10 ======================
	// בניית עץ בינרי משתי סריקות נתונות
	public static BinTreeNode<Integer> buildTree(int[] preorder, int[] inorder)
	{
		int i = 0;
		BinTreeNode<Integer> bt = new BinTreeNode<Integer>(preorder[0]);

		//המשתנה יצביע על מקום האיבר הראשון של הסריקה התחילית בתוך הסריקה התוכית
		while (preorder[0] != inorder[i])
			i++;

		//תת העץ השמאלי
		if (i > 0)
		{
			int[] preorderL = new int[i];
			int[] inorderL = new int[i];
			for (int j=0; j<i; j++)
			{
				preorderL[j] = preorder[j+1]; 
				inorderL[j] = inorder[j];
			}
			bt.setLeft(buildTree(preorderL,inorderL));
		}

		//תת העץ הימני
		if (i < inorder.length-1)
		{
			int[] preorderR = new int [inorder.length-1-i];
			int[] inorderR = new int[inorder.length-1-i];
			for (int j=i+1; j<inorder.length; j++)
			{
				preorderR[j-i-1] = preorder[j]; 
				inorderR[j-i-1] = inorder[j];
			}
			bt.setRight(buildTree(preorderR,inorderR));
		}

		return bt;				
	}
	
	// =================== תשובה לתרגיל 21 פרק 10 ======================
	// יש 3 גירסאות לפתרון תרגיל זה
	// 1. פתרון לא רקורסיבי המשתמש בתור
	public static int diff1(BinTreeNode<Integer> bt)
	{
		int diff = 0;
		BinTreeNode<Integer> t;
		Queue<BinTreeNode<Integer>> q = new Queue<BinTreeNode<Integer>>();

		q.insert(bt);
		while (!q.isEmpty())
		{
			t = q.remove();
			if (t.getLeft() == null && t.getRight() != null)
				diff += t.getRight().getInfo();
			if (t.getLeft() != null && t.getRight() == null)
				diff -= t.getLeft().getInfo();

			if (t.getLeft() != null)
				q.insert (t.getLeft());
			if (t.getRight() != null)
				q.insert (t.getRight());
		}
		return diff;
	}

	// 2. פתרון רקורסיבי עם פעולה אחת
	public static int diff2(BinTreeNode<Integer> bt)
	{
		if(bt.getLeft()==null && bt.getRight()==null) 
			return 0;

		if (bt.getLeft()==null)
			return diff2(bt.getRight()) + bt.getRight().getInfo();

		if (bt.getRight()==null)
			return diff2(bt.getLeft()) - bt.getLeft().getInfo();

		return diff2(bt.getLeft()) + diff2(bt.getRight());
	}

	// 3. פתרון לא רקורסיבי המשתמש בשתי פעולות עזר רקקורסיביות
	public static int diff3(BinTreeNode<Integer> bt)
	{
		return sumOfsingelRightChild(bt) - sumOfsingelLeftChild(bt);
	}
	// פעולת עזר: מחזירה את סכום הילדים השמאליים היחידים
	public static int sumOfsingelLeftChild(BinTreeNode<Integer> bt)
	{
		if(bt == null)
			return 0;

		int val = 0;
		if(bt.getLeft()!=null && bt.getRight()==null)
			val = bt.getLeft().getInfo();

		return val + sumOfsingelLeftChild(bt.getLeft()) + sumOfsingelLeftChild(bt.getRight());
	}
	// פעולת עזר: מחזירה את סכום הילדים הימניים היחידים
	public static int sumOfsingelRightChild(BinTreeNode<Integer> bt)
	{
		if(bt == null)
			return 0;

		int val = 0;
		if(bt.getLeft()==null && bt.getRight()!=null)
			val = bt.getRight().getInfo();

		return val + sumOfsingelRightChild(bt.getLeft()) + sumOfsingelRightChild(bt.getRight());
	}
	
	
	// ======================= תשובה לשאלה 22 פרק 10 =========================
	public static boolean isSimilarTrees(BinTreeNode<Integer> bt1, BinTreeNode<Integer> bt2)
	{
		if ((bt1.getLeft() != null && bt2.getLeft() == null) ||
				(bt1.getLeft() == null && bt2.getLeft() != null) ||  
				(bt1.getRight() != null && bt2.getRight() == null) ||
				(bt1.getRight() == null && bt2.getRight() != null))
			return false;
		
		boolean resL = true;
		boolean resR = true;
		
		if (bt1.getLeft() != null)
			resL = isSimilarTrees(bt1.getLeft(),bt2.getLeft());
		
		if (!resL)
			return false;
		
		if (bt1.getRight() != null)
			resR = isSimilarTrees(bt1.getRight(),bt2.getRight());
		
		return resR;
	}

	// ========================== תשובה לשאלה 23 פרק 10 =========================
	// בניית עץ ביטוי מהקלט
	public static BinTreeNode<Character> buildExpTree(Scanner input)
	{
		BinTreeNode<Character> bt = null;
		char ch = input.next().charAt(0);

		if(Character.isDigit(ch))
			bt = new BinTreeNode<Character>(ch);
		else
			if(ch == '(')
			{		
				BinTreeNode<Character> btLeft = buildExpTree(input);
				ch = input.next().charAt(0); //פעולה
				BinTreeNode<Character> btRight = buildExpTree(input);
				bt = new BinTreeNode<Character>(btLeft, ch, btRight);
				ch = input.next().charAt(0); //חייב להיות סוגר
			}

		return bt;
	}
	
	
	// ========================== תשובה לשאלה 24 פרק 10 =========================
	// סעיף ג
	public static int maxInBST(BinTreeNode<Integer> bst)
	{
		if(bst.getRight() == null)
			return bst.getInfo();
		return maxInBST(bst.getRight());
	}
	
	
	// ========================== תשובה לשאלה 25 פרק 10 =========================
	// סעיף ג: עץ-בינרי-משופע
	public static boolean isInclined(BinTreeNode<Integer> bt)
	{
		if(bt == null || (bt.getLeft()==null && bt.getRight()==null))
			return true;
		
		boolean left = true;
		boolean right = true;
		
		if(bt.getLeft() != null)
			left = bt.getInfo() > bt.getLeft().getInfo();
		if(bt.getRight() != null)
			right = bt.getInfo() < bt.getRight().getInfo();
		
		return left && right && isInclined(bt.getLeft()) && isInclined(bt.getRight());
	}
}