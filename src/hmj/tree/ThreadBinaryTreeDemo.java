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
		
		
		//����������������
		tbt.threadMidOrder();
	}

}

//����ʵ�������������ܵĶ�����
class ThreadBinaryTree extends BinaryTree
{
	//��Ҫһ��ָ��ǰ����ǰ�����������������Ĭ��Ϊnull(�ܶ෽��������Щ��ע��˼����)
	ThreadHeroNode pre;
	
	public ThreadBinaryTree(ThreadHeroNode root)
	{
		super(root);
	}
	
	//������������������
	public void threadNode()
	{
		threadNode((ThreadHeroNode)this.root);
	}
	
	//��������������
	public void threadNode(ThreadHeroNode node)
	{
		//������Ϊ�գ�ֱ���˳�
		if (node == null)
			return;
		
		//��ʼ���������
		if (node.left != null)
			threadNode((ThreadHeroNode)node.left);
		

		//��ʼ����������		
		//�ȿ���ǰ�����ָ��
		if (node.left == null)
		{
			node.left = pre;
			node.leftType = 1;
		}
		
		if (pre != null && pre.right == null) //��ǰ��������һ�βŴ����밡���������
		{
			pre.right = node;
			pre.rightType = 1;
		}		
		pre = node;

		
		//��ʼ�����ұ�������
		if (node.right != null)
			threadNode((ThreadHeroNode)node.right);
		
	}

	//�������������������
	public void threadMidOrder()
	{
		ThreadHeroNode temp = (ThreadHeroNode)root;
		while (temp != null) //���ѭ���õ��밡
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


//����һ�����
class ThreadHeroNode extends HeroNode
{
	int leftType;     //�����0��ʾ������  1��ʾָ��ǰ�����   //Ϊʲôleftָ�����ǰ������right�Ǻ����أ��뻭ͼ
	int rightType;	  //�����0��ʾ������  1��ʾָ��������
	
	public ThreadHeroNode(int id, String name)
	{
		super(id, name);
	}
}
