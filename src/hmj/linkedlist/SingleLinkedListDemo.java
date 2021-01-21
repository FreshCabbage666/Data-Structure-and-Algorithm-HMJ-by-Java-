package hmj.linkedlist;

import java.util.Stack;



public class SingleLinkedListDemo 
{

	public static void main(String[] args) 
	{
		
		HeroNode node1 = new HeroNode(1, "hmj1", "hmj1");
		HeroNode node2 = new HeroNode(2, "hmj2", "hmj2");
		HeroNode node3 = new HeroNode(3, "hmj3", "hmj3");
		HeroNode node4 = new HeroNode(4, "hmj4", "hmj4");
		HeroNode node5 = new HeroNode(5, "hmj5", "hmj5");
		HeroNode node6 = new HeroNode(6, "hmj6", "hmj6");
		
		SingleLinkedList list = new SingleLinkedList();
		list.addOrder(node1);
		list.addOrder(node2);
		list.addOrder(node3);
		list.addOrder(node4);
		list.addOrder(node6);
		list.addOrder(node5);
		
		list.showList();
		//测试节点个数
		System.out.println(nodeSum(list.getHeadNode()));
		//测试倒数第K个节点
		try {
			System.out.println("第k个节点是：" + reverseNodeInfo(list.getHeadNode(), 6));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//测试pop方法
//		System.out.println("pop之前----------------------------------");
//		pop(list.getHeadNode());
//		pop(list.getHeadNode());
//		pop(list.getHeadNode());
//		pop(list.getHeadNode());
//		pop(list.getHeadNode());
//		System.out.println(pop(list.getHeadNode()));
//		System.out.println("pop之后----------------------------------");
//		list.showList();
		
		//测试链表反转
//		System.out.println("反转之前----------------------------------");
//		list.showList();
//		System.out.println("反转之后----------------------------------");
//		reverseList(list.getHeadNode());
//		list.showList();
		
		//测试打印反转链表(原表不会改变)
		reversePrint(list.getHeadNode());
		list.showList();
	}
	
	
	/**
	 * @param head
	 * @return 节点个数
	 */
	public static int nodeSum(HeroNode head)
	{
		if (head.next == null)
			return 0;
		
		HeroNode temp = head.next;
		int cnt = 1;
		while (temp.next != null)
		{
			cnt++;
			temp = temp.next;
		}
		return cnt;
	}

	
	/**
	 * @param i
	 * @return 返回倒数第k个节点信息
	 */
	public static HeroNode reverseNodeInfo(HeroNode head, int k)
	{
		if (head.next == null)
			throw new RuntimeException("链表为空");
		
		//分析：先获取列表元素个数，获取（个数-k+1）位置的节点信息并且返回
		int location = nodeSum(head) - k + 1;
		
		if (location < 1 || location > nodeSum(head))
			throw new RuntimeException("输入的k不合法！");
		
		HeroNode temp = head;
		int cnt = 0;
		while (temp != null)
		{
			if (cnt == location)
			{
				return temp;
			}
			cnt++;
			temp = temp.next;
		}
		
		throw new RuntimeException("没找到！");
	}
	
	/**
	 * @param head
	 * @return void
	 */
	public static void reversePrint(HeroNode head)
	{
		if (head.next == null)
		{
			System.out.println("链表为空");
			return;
		}
		Stack<HeroNode> stack = new Stack();
		HeroNode temp = head.next;
		while (temp != null)
		{
			stack.add(temp);
			temp = temp.next;
		}
		
		//开始打印
		System.out.println("反转打印------------------");
		while (stack.size() > 0)
		{
			System.out.println(stack.pop());
		}
		System.out.println("反转打印------------------");
			
	}
	
	/**
	 * @param head
	 * @return void
	 */
	public static void reverseList(HeroNode head)
	{
		//思路:1首先获取单链表的个数,判断链表是否为空或者1，否就继续
		//	   2 新建一个空链表list2
		//	   3 不断的把元素从list1的尾部删除然后添加到list2中
		//	   4 让list1的头节点等于list2
		int cnt = nodeSum(head);
		if (cnt == 0 || cnt == 1)
		{
			System.out.println("链表不需要反转！");
			return;
		}
		
		SingleLinkedList list2 = new SingleLinkedList();
		
		for (int i = cnt; i > 0; i--)
		{
			list2.addAppand(pop(head));
		}
		//head = list2.getHeadNode(); //想想这里为什么这么写是错误的
		head.next = list2.getHeadNode().next;
		
	}
	
	/**
	 * @param head
	 * @return 删除最后的节点
	 */
	public static HeroNode pop(HeroNode head)
	{
		HeroNode temp = head;
		if (temp.next == null)
		{
			System.out.println("链表为空，删除失败");
			return null;
		}
		
		while (temp.next.next != null)
		{
			temp = temp.next;
		}
		
		HeroNode returnNode = temp.next;
		temp.next = null;
		return returnNode;
	}
	
}


//创建LinkedList来管理我们的节点
class SingleLinkedList
{
	//创建头节点，不要随意动，一般不存放实际数据
	private HeroNode headNode = new HeroNode(0, "", "");
	
	//添加一个获取头节点的方法
	public HeroNode getHeadNode()
	{
		return this.headNode;
	}
	
	//添加节点到单向链表(尾部插入)
	public void addAppand(HeroNode node)
	{
		//临时指针指向头节点寻找到链表的尾部
		HeroNode temp = this.headNode; 
		
		//找出尾节点
		while (true)
		{
			if (temp.next == null)
				break;
			temp = temp.next;
		}
		temp.next = node;
		//node.next = null; //想想这里的代码没有会出现什么后果
	}
	
	//按照指定顺序添加节点到链表
	public void addOrder(HeroNode node)
	{
		HeroNode temp = this.headNode;
		
//		if (temp.next == null) //如果链表为空，相当于尾插(想想为什么这段if代码不需要)
//		{
//			temp.next = node;
//			return;
//		}
		
		while (temp.next != null) //遍历链表，按照no从小到大位置插入
		{
			if (temp.next.no == node.no)
			{
				System.out.printf("插入的no:%d已经存在，插入失败！\n", node.no);
				return;
			}
			if (temp.next.no > node.no ) //满足就在temp.next之前插入
			{
				node.next = temp.next; //其实这里可以换种方式直接break替换尾插的代码，想想为什么
				temp.next = node;
				return;
			}
			temp = temp.next;
		}
		//如果到了这里，说明链表遍历到了最后，不管是否是空链表，都尾插了
		temp.next = node;
	}
	
	//根据no修改节点信息
	public void update(HeroNode node)
	{
		if (this.headNode.next == null)
		{
			System.out.println("链表为空，无法修改！");
			return;
		}
		
		HeroNode temp = this.headNode.next;
		while (temp.next != null)
		{
			if (temp.no == node.no)
			{
				temp.name = node.name;
				temp.nickName = node.nickName;
				return;
			}
			temp = temp.next; //不要忘记写了！
		}
		System.out.println("没有次no，修改失败！");
	}
	
	//根据no删除节点
	public void delete(int no)
	{
		HeroNode temp = this.headNode;
		if (temp.next == null)
		{
			System.out.println("链表为空，删除失败");
			return;
		}
		
		//只需要找到删除节点的前一个位置即可
		while (temp.next != null)
		{
			if (temp.next.no == no) //找到了，删除他
			{
				temp.next = temp.next.next; //不管是不是最后一个，这个表达式都兼容，请画图理解！
				return;
			}
			temp = temp.next;
		}
		System.out.println("没有找到次no，删除失败");
	}
	
	//显示链表(遍历)
	public void showList()
	{
		if (this.headNode.next == null)
		{
			System.out.println("链表为空！");
			return;
		}
		
		HeroNode temp = this.headNode.next;
	
		while (true)
		{
			System.out.println(temp);
			if (temp.next == null)
				break;
			temp = temp.next;  //思考一下还有没有另外一种写法
		}
			
	}
	
}


//定义一个HeroNode，每一个HeroNode对象就是一个节点
class HeroNode
{
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;   //指向下一个节点
	
	//构造函数
	public HeroNode(int no, String name, String nickName)
	{
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	
	//为了显示方便，重写toString方法
	@Override
	public String toString() 
	{
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
	
}
