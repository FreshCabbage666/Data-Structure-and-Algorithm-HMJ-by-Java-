package hmj.tree;

public class ThreadBinaryTreeDemo 
{

	public static void main(String[] args) 
	{
		ThreadHeroNode root = new ThreadHeroNode(1, "1");
		ThreadHeroNode h1 = new ThreadHeroNode(1, "3");
		ThreadHeroNode h2 = new ThreadHeroNode(1, "6");
		ThreadHeroNode h3 = new ThreadHeroNode(1, "8");
		ThreadHeroNode h4 = new ThreadHeroNode(1, "10");
		ThreadHeroNode h5 = new ThreadHeroNode(1, "14");
		
		root.left = h1;
		root.right = h2;
		h1.left = h3;
		h1.right = h4;
		h2.left = h5;
		ThreadBinaryTree tbt = new ThreadBinaryTree(root);
		tbt.threadNode();
		
		//System.out.println(h3.right.name);
		//System.out.println(h3.left);
		//System.out.println(h4.right.name);
		//System.out.println(h4.left.name);
		//System.out.println(h5.left.name);
		//System.out.println(h5.right.name);
//		System.out.println(h2.left.name);
//		System.out.println(h2.right);
		
		
		//遍历线索化二叉树
		tbt.threadMidOrder();
	}

}

//创建实现了线索化功能的二叉树
class ThreadBinaryTree extends BinaryTree
{
	//需要一个指向当前结点的前驱结点来辅助线索化默认为null(很多方法都有这些，注意思考下)
	ThreadHeroNode pre;
	
	public ThreadBinaryTree(ThreadHeroNode root)
	{
		super(root);
	}
	
	//重载中序线索化方法
	public void threadNode()
	{
		threadNode((ThreadHeroNode)this.root);
	}
	
	//中序线索化方法
	public void threadNode(ThreadHeroNode node)
	{
		//如果结点为空，直接退出
		if (node == null)
			return;
		
		//开始左边线索化
		if (node.left != null)
			threadNode((ThreadHeroNode)node.left);
		

		//开始进行线索化		
		//先看当前结点左指针
		if (node.left == null)
		{
			node.left = pre;
			node.leftType = 1;
		}
		
		if (pre != null && pre.right == null) //当前不处理，后一次才处理，秒啊★★★★★★★★
		{
			pre.right = node;
			pre.rightType = 1;
		}		
		pre = node;

		
		//开始进行右边线索化
		if (node.right != null)
			threadNode((ThreadHeroNode)node.right);
		
	}

	//中序遍历线索化二叉树
	public void threadMidOrder()
	{
		ThreadHeroNode temp = (ThreadHeroNode)root;
		while (temp != null) //这个循环用得秒啊
		{
			while (temp.leftType == 0)
			{
				temp = (ThreadHeroNode)temp.left;
			}
			System.out.println(temp.id + ", " + temp.name);
				
			while (temp.rightType == 1)
			{
				temp = (ThreadHeroNode)temp.right;
				System.out.println(temp.id + ", " + temp.name);
			}
			temp = (ThreadHeroNode)temp.right;
		}
		
	}
	
}


//创建一个结点
class ThreadHeroNode extends HeroNode
{
	int leftType;     //如果是0表示左子树  1表示指向前驱结点   //为什么left指向的是前驱，而right是后驱呢？请画图
	int rightType;	  //如果是0表示右子树  1表示指向后驱结点
	
	public ThreadHeroNode(int id, String name)
	{
		super(id, name);
	}
}
