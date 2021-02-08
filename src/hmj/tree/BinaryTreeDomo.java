package hmj.tree;


public class BinaryTreeDomo
{
	public static void main(String[] args)
	{
		//����5���ڵ㲢����һ����ϵ�����
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
		
		//���Ա��������������������������
//		//����
//		//bt.preOrder();
//		//����
//		//bt.midOrder();
//		//����
//		bt.backOrder();
		
		
		//���Բ��ҡ����������������������
		//����
		//HeroNode ht = bt.preFind(5);
		//����
		//HeroNode ht = bt.midFind(5);
		//����
//		HeroNode ht = bt.backFind(5);
//		if (ht == null)
//			System.out.println("û�ҵ�");
//		else
//			System.out.println(ht.id + ", " + ht.name);
		
		
		//����ɾ�������������������������
		//bt.preOrder();
		bt.delNode(5);
		bt.preOrder();
		bt.delNode(3);
		bt.preOrder();
		
	}
}


class BinaryTree
{
	HeroNode root; //���ڵ�

	public BinaryTree(HeroNode root) 
	{
		this.root = root;
	}
	
	//�������
	public void preOrder()
	{
		if (this.root != null)
			this.root.preOrder();
		else
			System.out.println("�������޷�����");
	}
	
	//�������
	public void midOrder()
	{
		if (this.root != null)
			this.root.midOrder();
		else
			System.out.println("�������޷�����");
	}
		
	//�������
	public void backOrder()
	{
		if (this.root != null)
			this.root.backOrder();
		else
			System.out.println("�������޷�����");
	}
	
	//�������
	public HeroNode preFind(int id)
	{
		if (this.root == null)
			return null;
		
		HeroNode temp = this.root.preFind(id);
		return temp;
	}
	
	//�������
	public HeroNode midFind(int id)
	{
		if (this.root == null)
			return null;
		
		HeroNode temp = this.root.midFind(id);
		return temp;
	}

	//�������
	public HeroNode backFind(int id)
	{
		if (this.root == null)
			return null;
		
		HeroNode temp = this.root.backFind(id);
		return temp;
	}

	//ɾ�����
	public HeroNode delNode(int id)
	{
		if (this.root == null)
		{
			System.out.println("������");
			return null;
		}
		
		HeroNode temp = null;
		temp = this.root.delNode(id);
		if (this.root == temp)
		{
			this.root = null; //���������
		}
		return temp;
	}
}

//ÿ��Ԫ�ؽڵ�
class HeroNode
{
	int id;			 //id��
	String name;	 //����info
	HeroNode left;   //left��right�Ƿֱ�ָ�����ҵ�ָ��
	HeroNode right;
	
	public HeroNode(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	//�������
	public void preOrder()
	{
		System.out.println(this.id + ", " + this.name);
		if (this.left != null)
			this.left.preOrder();
		if (this.right != null)
			this.right.preOrder();
	}
	
	//�������
	public void midOrder()
	{
		if (this.left != null)
			this.left.midOrder();
		System.out.println(this.id + ", " + this.name);
		if (this.right != null)
			this.right.midOrder();
	}
		
	//�������
	public void backOrder()
	{
		if (this.left != null)
			this.left.backOrder();
		if (this.right != null)
			this.right.backOrder();
		System.out.println(this.id + ", " + this.name);
	}
	
	//�������
	public HeroNode preFind(int id)
	{
		HeroNode ret = null;
		
		System.out.println("ͳ��Ѱ�Ҵ���");
		if (this.id == id) //������ �Ϳ��Է�����
		{
			ret = this;
			return ret;
		}
		
		if (this.left != null) //���û���ҵ������ж���ڵ㣬���ѽ����ret
		{
			ret = this.left.preFind(id);
		}
		
		if (ret != null) //���ret��Ϊ�գ�˵����߽ڵ��ҵ��ˣ�����Ҫ������
		{
			return ret;
		}
		
		if (this.right != null ) //ִ�е�����˵����ڵ�û���ҵ������ж��ҽڵ㣬���ѽ����ret
		{
			ret = this.right.preFind(id);
		}
		
		return ret; //����ret��û���ҵ�����ʱ�����Է��أ��ҵ�ret��Ϊ��
	}

	//�������
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
		
		System.out.println("ͳ��Ѱ�Ҵ���");
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

	//�������
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
		
		if (ret != null) //�����������ʡ����
		{
			return ret;
		}
		
		System.out.println("ͳ��Ѱ�Ҵ���");
		if (this.id == id)
		{
			ret = this;
		}
		
		return ret;
	}

	//ɾ�����
	public HeroNode delNode(int id)
	{
		HeroNode ret = null;
		
		if (this.left != null)
		{
			ret = this.left.delNode(id);
		}
		
		if (ret != null && this.left.id == id) //�����&&���������ӵ�̫��Ҫ�ˣ���˼��˼����
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