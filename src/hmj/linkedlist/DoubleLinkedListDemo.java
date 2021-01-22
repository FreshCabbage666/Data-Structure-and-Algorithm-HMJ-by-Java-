package hmj.linkedlist;

public class DoubleLinkedListDemo 
{

	public static void main(String[] args) 
	{
		System.out.println("双向链表测试");
		
		HeroNode2 node1 = new HeroNode2(1, "hmj1", "hmj1");
		HeroNode2 node2 = new HeroNode2(2, "hmj2", "hmj2");
		HeroNode2 node3 = new HeroNode2(3, "hmj3", "hmj3");
		HeroNode2 node4 = new HeroNode2(4, "hmj4", "hmj4");
		HeroNode2 node5 = new HeroNode2(5, "hmj5", "hmj5");
		HeroNode2 node6 = new HeroNode2(6, "hmj6", "hmj6");
		
		DoubleLinkedList list = new DoubleLinkedList();
		list.addAppand(node1);
		list.addAppand(node2);
		list.addAppand(node3);
		list.addAppand(node4);
		list.addAppand(node5);
		list.addAppand(node6);
		
		list.showList();
		list.update(new HeroNode2(4, "呵呵", "呵呵666"));
		list.showList();
		list.delete(3);
		System.out.println();
		list.showList();
	}
}

class DoubleLinkedList
{
	//创建头节点，不要随意动，一般不存放实际数据
	private HeroNode2 headNode = new HeroNode2(0, "", "");
	
	//添加一个获取头节点的方法
	public HeroNode2 getHeadNode()
	{
		return this.headNode;
	}
	
	//显示链表(遍历)
	public void showList()
	{
		if (this.headNode.next == null)
		{
			System.out.println("链表为空！");
			return;
		}

		HeroNode2 temp = this.headNode.next;

		while (true)
		{
			System.out.println(temp);
			if (temp.next == null)
				break;
			temp = temp.next;  //思考一下还有没有另外一种写法
		}

	}
	
	//添加节点到双向链表(尾部插入)
	public void addAppand(HeroNode2 node)
	{
		//临时指针指向头节点寻找到链表的尾部
		HeroNode2 temp = this.headNode; 
		
		//找出尾节点
		while (true)
		{
			if (temp.next == null)
				break;
			temp = temp.next;
		}
		temp.next = node;
		node.pre = temp;
		
	}

	//根据no修改节点信息
	public void update(HeroNode2 node)
	{
		if (this.headNode.next == null)
		{
			System.out.println("链表为空，无法修改！");
			return;
		}
		
		HeroNode2 temp = this.headNode.next;
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
		
		if (this.headNode.next == null)
		{
			System.out.println("链表为空，删除失败");
			return;
		}
		
		HeroNode2 temp = this.headNode.next;
		
		//只需要找到删除节点的前一个位置即可
		while (temp != null)
		{
			if (temp.no == no) //找到了，删除他
			{
				temp.pre.next = temp.next; 
				if (temp.next != null) //为了防止空指针异常
					temp.next.pre = temp.pre;
				
				return;
			}
			temp = temp.next;
		}
		System.out.println("没有找到次no，删除失败");
	}
	
}

//定义一个HeroNode2，每一个HeroNode2对象就是一个节点
class HeroNode2
{
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next;   //指向下一个节点
	public HeroNode2 pre;    //指向前一个节点
	
	//构造函数
	public HeroNode2(int no, String name, String nickName)
	{
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	
	//为了显示方便，重写toString方法
	@Override
	public String toString() 
	{
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
	
}