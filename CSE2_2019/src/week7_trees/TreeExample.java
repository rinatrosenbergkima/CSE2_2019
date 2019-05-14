package week7_trees;
import unit4_collectionsLib.*;
import unit4_utilsLib.*;
public class TreeExample {
	public static void treeExample1 () {
		BinTreeNode<Integer> bt1 = new BinTreeNode<Integer>(3);
		bt1.setLeft(new BinTreeNode<Integer>(5));
		bt1.setRight(new BinTreeNode<Integer>(7));
		System.out.print(" isLeaf="+BinTreeUtils.isLeaf(bt1.getRight()));
		
	}
	

	public int numOfNodes (BinTreeNode<Integer> tr)
	{
		int leftCount = 0;
		int rightCount = 0;
		if (tr.getLeft() != null)
		leftCount = numOfNodes(tr.getLeft());
		if (tr.getRight() != null)
		rightCount = numOfNodes(tr.getRight());
		return (leftCount + rightCount +1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treeExample1();
	}
}
