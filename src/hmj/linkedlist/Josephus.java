package hmj.linkedlist;

public class Josephus 
{

	public static void main(String[] args) 
	{
		CircleSingleLinkedList list = new CircleSingleLinkedList();
		list.addBoy(25);
		//list.showCSLit();
		list.printCSList(1, 2, 25);
	}

}


//创建一个单向的环形的链表
class CircleSingleLinkedList
{
	private Boy first;
	
	//环形链表的增加(创建)
	public void addBoy(int sum)
	{
		if (sum < 1)
		{
			System.out.println("个数不够，创建失败！");
			return;
		}
		
		Boy curBoy = null;
		for (int i = 1; i <= sum; i++)
		{
			if (i == 1)
			{
				this.first = new Boy(1);
				this.first.setNext(first);
				curBoy = first;
			}
			else
			{
				Boy temp = new Boy(i);
				curBoy.setNext(temp);
				temp.setNext(this.first);
				curBoy = temp;
			}
		}
		
	}
	
	//环形链表的遍历
	public void showCSLit()
	{
		if (this.first == null)
		{
			System.out.println("链表为空！");
			return;
		}
		
		Boy curBoy = this.first;
		
//		do
//		{
//			System.out.println(curBoy.getNo());
//			curBoy = curBoy.getNext();
//		} while (curBoy.getNext() != this.first); //这样写为什么不可以？
		
		while (curBoy.getNext() != this.first) //运行到倒数第一个就跳出了，所以后面还需打印一次
		{
			System.out.println(curBoy.getNo());
			curBoy = curBoy.getNext();
			//curBoy.setNext(curBoy.getNext()); 想想为什么不可以这样写？
		}
		System.out.println(curBoy.getNo());
	}
	
	//根据用户的输入来输出出圈顺序(第几个，数多少次，一共有多少boy)
	public void printCSList(int startNo, int count, int sum)
	{
		if (this.first == null || startNo < 1 || startNo > sum || count <= 0)
		{
			System.out.println("数据错误!");
			return;
		}
		
		Boy heelPtr = this.first;
		while (heelPtr.getNext() != this.first) //把heelPtr指向first前一个(也就是list最后一个)
		{
			heelPtr = heelPtr.getNext();
		}
		
		//第startNo个开始数，就把first和heelPtr移动startNo-1次
		for (int i = 1; i <= startNo - 1; i++)
		{
			this.first = this.first.getNext();
			heelPtr = heelPtr.getNext();
		}
		
		while (sum != 0)
		{
			for (int i = 1; i <= count - 1; i++)
			{
				this.first = this.first.getNext();
				heelPtr = heelPtr.getNext();
			}
			System.out.println(this.first.getNo());
			this.first = this.first.getNext();
			heelPtr.setNext(this.first);
			sum--;
		}
		System.out.println("结束！");
	}
	
}


//创建boy表示一个节点
class Boy
{
	private int no;
	private Boy next;
	
	public Boy(int no)
	{
		this.no = no;
	}

	public int getNo() 
	{
		return no;
	}

	public void setNo(int no) 
	{
		this.no = no;
	}

	public Boy getNext() 
	{
		return next;
	}

	public void setNext(Boy next) 
	{
		this.next = next;
	}
	
	
}
