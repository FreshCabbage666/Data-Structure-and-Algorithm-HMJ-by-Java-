package hmj.hashtable;

public class HashTableDemo 
{

	public static void main(String[] args) 
	{
		HashTable ht = new HashTable(7);
		
		ht.add(new Emp(15, "h15"));
		ht.add(new Emp(22, "h22"));
		ht.add(new Emp(1, "h1"));
//		ht.add(new Emp(29, "h29"));
//		ht.add(new Emp(8, "h8"));
		
		
		ht.find(29);
		ht.update(new Emp(29, "哈哈哈哈"));
		ht.list();
		ht.del(22);
		ht.list();
		
	}

}


//每个结点
class Emp
{
	public int id;      //索引
	public String name; //这里info做了简化，用一个name代替
	public Emp next;	 //存储下一个元素的地址 默认为空
	
	public Emp(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

}

//存放每个结点的引用
class EmpLinkedList
{
	public Emp head; //此链表的头指针，这是不带头节点的
	
	//add方法 根据id按照顺序添加，id不可重复
	public void add(Emp addEmp)
	{
		if (this.isExist(addEmp.id))
		{
			System.out.println("id重复,添加失败!");
			return;
		}
		
		if (this.head == null)
		{
			this.head = addEmp;
			return;
		}
		
		Emp curr = this.head;
		Emp pre = this.head;
		//先寻找出需要插入的元素之前位置(从0开始)，如0,1,3,4 插入2，应该插在下标为2的位置
		while (curr.id < addEmp.id)
		{
			pre = curr;
			curr = curr.next;
			if (curr == null)
				break;
		}
		
		if (curr == pre) //如果是在0位置插入
		{
			this.head = addEmp;
			addEmp.next = pre;
		}
		else if (curr != null)
		{
			addEmp.next = pre.next;
			pre.next = addEmp;
		}
		else //尾插
		{
			pre.next = addEmp;
		}
		
		
	}
	
	//del方法 根据id删除
	public void del(int id)
	{
		if (this.head == null)
		{
			System.out.println("当前表为空");
			return;
		}
		
		if (this.head.id == id) //如果是第一个元素
		{
			this.head = this.head.next;
			return;
		}
		
		Emp curr = this.head.next;
		Emp pre = this.head;
		
		while (curr != null)
		{
			if (curr.id == id)
			{
				pre.next = curr.next;
				return;
			}
			pre = curr;
			curr = curr.next;
		}
		
		System.out.println("没有找到此id");
	}
	
	//find方法 根据id查找emp信息
	public void find(int id)
	{
		if (this.head == null)
		{
			System.out.println("当前表为空");
			return;
		}

		Emp temp = this.head;
		do
		{
			if (temp.id == id)
			{
				System.out.println(temp.id + ", " + temp.name);
				break;
			}
			temp = temp.next;
		} while (temp != null);
		
	}
	
	//update方法 根据id修改信息(但不可以修改id)
	public void update(Emp emp)
	{
		if (!isExist(emp.id))
		{
			System.out.println("查无此人");
			return;
		}
		
		Emp temp = this.head;
		do
		{
			if (temp.id == emp.id)
			{
				temp.name = emp.name;
				break;
			}
			temp = temp.next;
		} while (temp != null);
		
	}
	
	//遍历方法 遍历当前EmpLinkedList所有节点
	public void list()
	{
		if (this.head == null)
		{
			System.out.println("当前位置为空，无需遍历");
			return;
		}
		Emp temp = this.head;
		while (temp != null)
		{
			System.out.print("[" + temp.id + ", " + temp.name + "] \t");
			temp = temp.next;
		}
	}
	
	//isExist方法 根据id判断是否已经存在，true表示存在
	public boolean isExist(int id)
	{
		if (this.head == null)
		{
			return false;
		}
		
		boolean flag = false; //默认不存在
		Emp temp = this.head;
		do
		{
			if (temp.id == id)
			{
				flag = true;
				break;
			}
			temp = temp.next;
		} while (temp != null);
		
		return flag;
	}
}

//hashTable表
class HashTable
{
	EmpLinkedList[] EmpLinkedListArray; //存放每个链表的头指针
	int size; //表元素的大小(影响哈希函数)
	
	public HashTable(int size)
	{
		this.size = size;
		EmpLinkedListArray = new EmpLinkedList[this.size];
		
		//想想这里不写会有什么后果？(画内存图！)
		for (int i = 0; i < size; i++)
			EmpLinkedListArray[i] = new EmpLinkedList();
	}
	
	//add方法
	public void add(Emp addEmp)
	{
		EmpLinkedListArray[hashFunc(addEmp.id)].add(addEmp);
	}
	
	//del方法 根据id删除
	public void del(int id)
	{
		EmpLinkedListArray[hashFunc(id)].del(id);
	}
	
	//update方法 根据id修改信息
	public void update(Emp emp)
	{
		EmpLinkedListArray[hashFunc(emp.id)].update(emp);
	}
	
	//find方法 根据id查找emp信息
	public void find(int id)
	{
		EmpLinkedListArray[hashFunc(id)].find(id);
	}
	
	//遍历方法 
	public void list()
	{
		for (int i = 0; i < this.size; i++)
		{
			EmpLinkedListArray[i].list();
			System.out.println();
		}
		
	}
	
	//散列函数(散列函数选取需要结合数学分析，保证空间和时间一定的平衡性)
	private int hashFunc(int id)
	{
		return id % this.size;
	}
	
}