package hmj.tree;


public class BinaryTreeDomo
{
	public static void main(String[] args)
	{
		//创建5个节点并按照一定关系组成树
		HeroNode root = new HeroNode(1, "h1");
		HeroNode hn2 = new HeroNode(2, "h2");
		HeroNode hn3 = new HeroNode(3, "h3");
		HeroNode hn4 = new HeroNode(4, "h4");
		HeroNode hn5 = new HeroNode(5, "h5");
		
		//test
//		HeroNode hn6 = new HeroNode(6, "h6");
//		HeroNode hn7 = new HeroNode(7, "h7");
		
		root.left = hn2;
		root.right = hn3;
		hn3.left = hn5;
		hn3.right = hn4;
		
		//test
//		hn2.left = hn6;
//		hn2.right = hn7;
		
		BinaryTree bt = new BinaryTree(root);
		
		//测试遍历★★★★★★★★★★★★★★★★★★★★★★
//		//先序
//		//bt.preOrder();
//		//中序
//		//bt.midOrder();
//		//后序
//		bt.backOrder();
		
		
		//测试查找★★★★★★★★★★★★★★★★★★★★★★
		//先序
		//HeroNode ht = bt.preFind(5);
		//中序
		//HeroNode ht = bt.midFind(5);
		//后序
//		HeroNode ht = bt.backFind(5);
//		if (ht == null)
//			System.out.println("没找到");
//		else
//			System.out.println(ht.id + ", " + ht.name);
		
		
		//测试删除★★★★★★★★★★★★★★★★★★★★★★
		//bt.preOrder();
		bt.delNode(5);
		bt.preOrder();
		bt.delNode(3);
		bt.preOrder();
		
	}
}


class BinaryTree
{
	HeroNode root; //根节点

	public BinaryTree(HeroNode root) 
	{
		this.root = root;
	}
	
	//先序遍历
	public void preOrder()
	{
		if (this.root != null)
			this.root.preOrder();
		else
			System.out.println("空树，无法遍历");
	}
	
	//中序遍历
	public void midOrder()
	{
		if (this.root != null)
			this.root.midOrder();
		else
			System.out.println("空树，无法遍历");
	}
		
	//后序遍历
	public void backOrder()
	{
		if (this.root != null)
			this.root.backOrder();
		else
			System.out.println("空树，无法遍历");
	}
	
	//先序查找
	public HeroNode preFind(int id)
	{
		if (this.root == null)
			return null;
		
		HeroNode temp = this.root.preFind(id);
		return temp;
	}
	
	//中序查找
	public HeroNode midFind(int id)
	{
		if (this.root == null)
			return null;
		
		HeroNode temp = this.root.midFind(id);
		return temp;
	}

	//后序查找
	public HeroNode backFind(int id)
	{
		if (this.root == null)
			return null;
		
		HeroNode temp = this.root.backFind(id);
		return temp;
	}

	//删除结点
	public HeroNode delNode(int id)
	{
		if (this.root == null)
		{
			System.out.println("空树！");
			return null;
		}
		
		HeroNode temp = null;
		temp = this.root.delNode(id);
		if (this.root == temp)
		{
			this.root = null; //清空整个树
		}
		return temp;
	}
}

//每个元素节点
class HeroNode
{
	int id;			 //id号
	String name;	 //代表info
	HeroNode left;   //left和right是分别指向左右的指针
	HeroNode right;
	
	public HeroNode(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	//先序遍历
	public void preOrder()
	{
		System.out.println(this.id + ", " + this.name);
		if (this.left != null)
			this.left.preOrder();
		if (this.right != null)
			this.right.preOrder();
	}
	
	//中序遍历
	public void midOrder()
	{
		if (this.left != null)
			this.left.midOrder();
		System.out.println(this.id + ", " + this.name);
		if (this.right != null)
			this.right.midOrder();
	}
		
	//后序遍历
	public void backOrder()
	{
		if (this.left != null)
			this.left.backOrder();
		if (this.right != null)
			this.right.backOrder();
		System.out.println(this.id + ", " + this.name);
	}
	
	//先序查找
	public HeroNode preFind(int id)
	{
		HeroNode ret = null;
		
		System.out.println("统计寻找次数");
		if (this.id == id) //如果相等 就可以返回了
		{
			ret = this;
			return ret;
		}
		
		if (this.left != null) //如果没有找到，先判断左节点，并把结果给ret
		{
			ret = this.left.preFind(id);
		}
		
		if (ret != null) //如果ret不为空，说明左边节点找到了，不需要继续找
		{
			return ret;
		}
		
		if (this.right != null ) //执行到这里说明左节点没有找到，就判断右节点，并把结果给ret
		{
			ret = this.right.preFind(id);
		}
		
		return ret; //不管ret有没有找到，此时都可以返回，找到ret不为空
	}

	//中序查找
	public HeroNode midFind(int id)
	{
		HeroNode ret = null;
		
		if (this.left != null)
		{
			ret = this.left.midFind(id);
		}
		
		if (ret != null)
		{
			return ret;
		}
		
		System.out.println("统计寻找次数");
		if (this.id == id)
		{
			ret = this;
			return ret;
		}
		
		if (this.right != null)
		{
			ret = this.right.midFind(id);
		}
	
		return ret;
		
	}

	//后序查找
	public HeroNode backFind(int id)
	{
		HeroNode ret = null;
		
		if (this.left != null)
		{
			ret = this.left.backFind(id);
		}
		
		if (ret != null)
		{
			return ret;
		}
		
		if (this.right != null)
		{
			ret = this.right.backFind(id);
		}
		
		if (ret != null) //想想这里可以省略吗
		{
			return ret;
		}
		
		System.out.println("统计寻找次数");
		if (this.id == id)
		{
			ret = this;
		}
		
		return ret;
	}

	//删除结点
	public HeroNode delNode(int id)
	{
		HeroNode ret = null;
		
		if (this.left != null)
		{
			ret = this.left.delNode(id);
		}
		
		if (ret != null && this.left.id == id) //这里的&&后面条件加的太重要了！多思考思考！
		{
			this.left = null;
			return ret;
		}
		
		if (this.right != null)
		{
			ret = this.right.delNode(id);
		}
		
		if (ret != null && this.right.id == id)
		{
			this.right = null;
			return ret;
		}
		
		if (this.id == id)
		{
			ret = this;
		}
		return ret;
	}

	
}