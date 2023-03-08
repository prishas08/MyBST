
public class MyBST {
	
	BSTNode root;
	private class BSTNode
	{
		Integer val;
		BSTNode left, right;
		
		public BSTNode(Integer val)
		{
			this.val = val;
			left = right = null;
		}
		
		@Override
		public String toString()
		{
			return "" + this.val;
		}
	}
	
	public int size()
	{
		return size(root);
	}
	
	private int size(BSTNode root)
	{
		if(root == null)
		{
			return 0;
		}
		return 1 + size(root.left) + size(root.right);
	}
	public void insert(Integer n)
	{
		this.root = insert(root, n);
	}
	
	private BSTNode insert(BSTNode root, Integer n)
	{
		if(root == null)
		{
			root = new BSTNode(n);
		}
		if(n < root.val)
		{
			root.left = insert(root.left, n);
		}
		else if (n > root.val)
		{
			root.right = insert(root.right, n);
		}
		return root;
	}
	
	public boolean contains(Integer n)
	{
		return contains(root, n);
	}
	
	private boolean contains(BSTNode root, Integer n)
	{
		if(root == null)
		{
			return false;
		}
		else if (root.val == n)
		{
			return true;
		}
		else
		{
			return contains(root.left, n) || contains(root.right, n);
		}
	}
	public Integer getMax()
	{
		return getMax(root, root.val);
	}
	
	private Integer getMax(BSTNode root, Integer max)
	{
		if(root == null)
		{
			return max;
		}
		else
		{
			return getMax(root.right, root.val);
		}
	}
	
	public Integer getMin()
	{
		return getMin(root, root.val);
	}
	
	private Integer getMin(BSTNode root, Integer min)
	{
		if(root == null)
		{
			return min;
		}
		else
		{
			return getMin(root.left, root.val);
		}
	}
	
	public void delete(Integer n)
	{
		root = delete(root, n);
	}
	
	private BSTNode delete(BSTNode root, Integer n)
	{
		if(root == null)
		{
			 return root;
		}
		if (n < root.val)
		{
			root.left = delete(root.left,n);
		}
		else if (n > root.val)
		{
			root.right = delete(root.right,n);
		}
		else if(n==root.val)
		{
			if(root.left==null)
			{
				return root.right;
			}
			else if(root.right==null)
			{
				return root.left; 
			}
			root.val = getMin(root.right, root.val);
			root.right = delete(root.right, root.val);
		}
		return root;
	}
	
	public void inOrder()
	{
		inOrder(root);
	}
	
	private void inOrder(BSTNode root)
	{
		if(root!=null)
		{
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		}
	}
	
	public void print()
	{
		print(root, 0);
	}
	
	private void print(BSTNode root, int level)
	{
		if(root != null)
		{
			level+=4;
			print(root.right,level);
			System.out.println("\n");
			for(int i = 4; i < level; i++)
			{
				System.out.print(" ");
			}
			System.out.print(root.val);
			print(root.left, level);
		}
		
	}
	
	
	
	

}
