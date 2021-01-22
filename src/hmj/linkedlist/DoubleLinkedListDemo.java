package hmj.linkedlist;

public class DoubleLinkedListDemo 
{

	public static void main(String[] args) 
	{
		System.out.println("˫���������");
		
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
		list.update(new HeroNode2(4, "�Ǻ�", "�Ǻ�666"));
		list.showList();
		list.delete(3);
		System.out.println();
		list.showList();
	}
}

class DoubleLinkedList
{
	//����ͷ�ڵ㣬��Ҫ���⶯��һ�㲻���ʵ������
	private HeroNode2 headNode = new HeroNode2(0, "", "");
	
	//���һ����ȡͷ�ڵ�ķ���
	public HeroNode2 getHeadNode()
	{
		return this.headNode;
	}
	
	//��ʾ����(����)
	public void showList()
	{
		if (this.headNode.next == null)
		{
			System.out.println("����Ϊ�գ�");
			return;
		}

		HeroNode2 temp = this.headNode.next;

		while (true)
		{
			System.out.println(temp);
			if (temp.next == null)
				break;
			temp = temp.next;  //˼��һ�»���û������һ��д��
		}

	}
	
	//��ӽڵ㵽˫������(β������)
	public void addAppand(HeroNode2 node)
	{
		//��ʱָ��ָ��ͷ�ڵ�Ѱ�ҵ������β��
		HeroNode2 temp = this.headNode; 
		
		//�ҳ�β�ڵ�
		while (true)
		{
			if (temp.next == null)
				break;
			temp = temp.next;
		}
		temp.next = node;
		node.pre = temp;
		
	}

	//����no�޸Ľڵ���Ϣ
	public void update(HeroNode2 node)
	{
		if (this.headNode.next == null)
		{
			System.out.println("����Ϊ�գ��޷��޸ģ�");
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
			temp = temp.next; //��Ҫ����д�ˣ�
		}
		System.out.println("û�д�no���޸�ʧ�ܣ�");
	}
	
	//����noɾ���ڵ�
	public void delete(int no)
	{
		
		if (this.headNode.next == null)
		{
			System.out.println("����Ϊ�գ�ɾ��ʧ��");
			return;
		}
		
		HeroNode2 temp = this.headNode.next;
		
		//ֻ��Ҫ�ҵ�ɾ���ڵ��ǰһ��λ�ü���
		while (temp != null)
		{
			if (temp.no == no) //�ҵ��ˣ�ɾ����
			{
				temp.pre.next = temp.next; 
				if (temp.next != null) //Ϊ�˷�ֹ��ָ���쳣
					temp.next.pre = temp.pre;
				
				return;
			}
			temp = temp.next;
		}
		System.out.println("û���ҵ���no��ɾ��ʧ��");
	}
	
}

//����һ��HeroNode2��ÿһ��HeroNode2�������һ���ڵ�
class HeroNode2
{
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next;   //ָ����һ���ڵ�
	public HeroNode2 pre;    //ָ��ǰһ���ڵ�
	
	//���캯��
	public HeroNode2(int no, String name, String nickName)
	{
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	
	//Ϊ����ʾ���㣬��дtoString����
	@Override
	public String toString() 
	{
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
	
}