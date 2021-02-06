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
		ht.update(new Emp(29, "��������"));
		ht.list();
		ht.del(22);
		ht.list();
		
	}

}


//ÿ�����
class Emp
{
	public int id;      //����
	public String name; //����info���˼򻯣���һ��name����
	public Emp next;	 //�洢��һ��Ԫ�صĵ�ַ Ĭ��Ϊ��
	
	public Emp(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

}

//���ÿ����������
class EmpLinkedList
{
	public Emp head; //�������ͷָ�룬���ǲ���ͷ�ڵ��
	
	//add���� ����id����˳����ӣ�id�����ظ�
	public void add(Emp addEmp)
	{
		if (this.isExist(addEmp.id))
		{
			System.out.println("id�ظ�,���ʧ��!");
			return;
		}
		
		if (this.head == null)
		{
			this.head = addEmp;
			return;
		}
		
		Emp curr = this.head;
		Emp pre = this.head;
		//��Ѱ�ҳ���Ҫ�����Ԫ��֮ǰλ��(��0��ʼ)����0,1,3,4 ����2��Ӧ�ò����±�Ϊ2��λ��
		while (curr.id < addEmp.id)
		{
			pre = curr;
			curr = curr.next;
			if (curr == null)
				break;
		}
		
		if (curr == pre) //�������0λ�ò���
		{
			this.head = addEmp;
			addEmp.next = pre;
		}
		else if (curr != null)
		{
			addEmp.next = pre.next;
			pre.next = addEmp;
		}
		else //β��
		{
			pre.next = addEmp;
		}
		
		
	}
	
	//del���� ����idɾ��
	public void del(int id)
	{
		if (this.head == null)
		{
			System.out.println("��ǰ��Ϊ��");
			return;
		}
		
		if (this.head.id == id) //����ǵ�һ��Ԫ��
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
		
		System.out.println("û���ҵ���id");
	}
	
	//find���� ����id����emp��Ϣ
	public void find(int id)
	{
		if (this.head == null)
		{
			System.out.println("��ǰ��Ϊ��");
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
	
	//update���� ����id�޸���Ϣ(���������޸�id)
	public void update(Emp emp)
	{
		if (!isExist(emp.id))
		{
			System.out.println("���޴���");
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
	
	//�������� ������ǰEmpLinkedList���нڵ�
	public void list()
	{
		if (this.head == null)
		{
			System.out.println("��ǰλ��Ϊ�գ��������");
			return;
		}
		Emp temp = this.head;
		while (temp != null)
		{
			System.out.print("[" + temp.id + ", " + temp.name + "] \t");
			temp = temp.next;
		}
	}
	
	//isExist���� ����id�ж��Ƿ��Ѿ����ڣ�true��ʾ����
	public boolean isExist(int id)
	{
		if (this.head == null)
		{
			return false;
		}
		
		boolean flag = false; //Ĭ�ϲ�����
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

//hashTable��
class HashTable
{
	EmpLinkedList[] EmpLinkedListArray; //���ÿ�������ͷָ��
	int size; //��Ԫ�صĴ�С(Ӱ���ϣ����)
	
	public HashTable(int size)
	{
		this.size = size;
		EmpLinkedListArray = new EmpLinkedList[this.size];
		
		//�������ﲻд����ʲô�����(���ڴ�ͼ��)
		for (int i = 0; i < size; i++)
			EmpLinkedListArray[i] = new EmpLinkedList();
	}
	
	//add����
	public void add(Emp addEmp)
	{
		EmpLinkedListArray[hashFunc(addEmp.id)].add(addEmp);
	}
	
	//del���� ����idɾ��
	public void del(int id)
	{
		EmpLinkedListArray[hashFunc(id)].del(id);
	}
	
	//update���� ����id�޸���Ϣ
	public void update(Emp emp)
	{
		EmpLinkedListArray[hashFunc(emp.id)].update(emp);
	}
	
	//find���� ����id����emp��Ϣ
	public void find(int id)
	{
		EmpLinkedListArray[hashFunc(id)].find(id);
	}
	
	//�������� 
	public void list()
	{
		for (int i = 0; i < this.size; i++)
		{
			EmpLinkedListArray[i].list();
			System.out.println();
		}
		
	}
	
	//ɢ�к���(ɢ�к���ѡȡ��Ҫ�����ѧ��������֤�ռ��ʱ��һ����ƽ����)
	private int hashFunc(int id)
	{
		return id % this.size;
	}
	
}