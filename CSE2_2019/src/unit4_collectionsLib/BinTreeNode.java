package unit4_collectionsLib;

/** 
 * <h3 dir="rtl" style="color:red; font-family: Helvetica, Arial, sans-serif">
 * ������ ������ ����� ������ ��� ��� ������ T ���� ������ ������� �������.
 * </h3>
 * 
 * @author ���� ���� �����, ����� ������ ������, ����������� ������, �������
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
     * ������ ���� ����� ������; ��� ������ ��� x ���� ��� ������� ��� ��� null
	 * </b>
	 * 
     * @param x ��� ������
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
	 * ������ ���� ����� ������ ����� ���� x;
	 * left �-right �� (������ ��) ���� ������ ������ ���;
	 * ���� ������� ������ ����� null
	 * </b>
	 * 
	 * @param left ��-�� �����
     * @param x ��� ������
     * @param right ��-�� ����
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
	 * ������ ������ �� ���� �� ������
	 * </b>
	 * 
	 * @return ��� ������
     */
    public T getInfo()
    {
        return this.info;
    }
    
    /**
	 * <dt dir="rtl"/>
	 * <b>
	 * ������ ���� �� ���� ����� ������ �-x
	 * </b>
	 * 
	 * @param x ��� ������ ����
     */
    public void setInfo(T x)
    {
         this.info = x;
    }
    
    /**
	 * <dt dir="rtl"/>
	 * <b>
	 * ������ ������ �� ���� ������ �� ������;
	 * �� ��� ��� ����� ������ ������ null
	 * </b>
	 * 
	 * @return ���� ������
     */
    public BinTreeNode<T> getLeft()
    {   
        return this.left;
    }    
    
    /**
	 * <dt dir="rtl"/>
	 * <b>
	 * ������ ������ �� ���� ����� �� ������;
	 * �� ��� ��� ���� ������ ������ null
	 * </b>
	 * 
	 * @return ���� �����
     */
    public BinTreeNode<T> getRight()
    {   
        return this.right;
    }
    
    /**
	 * <dt dir="rtl"/>
	 * <b>
	 * ������ ������ �� ���� ������ ������ left
	 * </b>
	 * 
	 * @param left ���� ������ ����
     */
    public void setLeft(BinTreeNode<T> left)
    {
       this.left = left;
    }
    
    /**
	 * <dt dir="rtl"/>
	 * <b>
	 * ������ ������ �� ���� ����� ������ right
	 * </b>
	 * 
	 * @param right ���� ����� ����
     */
    public void setRight(BinTreeNode<T> right)
    {
    	this.right = right;
    }
    
    /**
	 * <dt dir="rtl"/>
     * <b>
     * ������ ������ ������ ������ �� ���� ����� ������
     * </b>
     * 
     * @return ������ ������ �� ���� ����� ������
     */
    public String toString()
    {
    	return this.info.toString();
    }   
}
