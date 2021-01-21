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
		//���Խڵ����
		System.out.println(nodeSum(list.getHeadNode()));
		//���Ե�����K���ڵ�
		try {
			System.out.println("��k���ڵ��ǣ�" + reverseNodeInfo(list.getHeadNode(), 6));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//����pop����
//		System.out.println("pop֮ǰ----------------------------------");
//		pop(list.getHeadNode());
//		pop(list.getHeadNode());
//		pop(list.getHeadNode());
//		pop(list.getHeadNode());
//		pop(list.getHeadNode());
//		System.out.println(pop(list.getHeadNode()));
//		System.out.println("pop֮��----------------------------------");
//		list.showList();
		
		//��������ת
//		System.out.println("��ת֮ǰ----------------------------------");
//		list.showList();
//		System.out.println("��ת֮��----------------------------------");
//		reverseList(list.getHeadNode());
//		list.showList();
		
		//���Դ�ӡ��ת����(ԭ����ı�)
		reversePrint(list.getHeadNode());
		list.showList();
	}
	
	
	/**
	 * @param head
	 * @return �ڵ����
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
	 * @return ���ص�����k���ڵ���Ϣ
	 */
	public static HeroNode reverseNodeInfo(HeroNode head, int k)
	{
		if (head.next == null)
			throw new RuntimeException("����Ϊ��");
		
		//�������Ȼ�ȡ�б�Ԫ�ظ�������ȡ������-k+1��λ�õĽڵ���Ϣ���ҷ���
		int location = nodeSum(head) - k + 1;
		
		if (location < 1 || location > nodeSum(head))
			throw new RuntimeException("�����k���Ϸ���");
		
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
		
		throw new RuntimeException("û�ҵ���");
	}
	
	/**
	 * @param head
	 * @return void
	 */
	public static void reversePrint(HeroNode head)
	{
		if (head.next == null)
		{
			System.out.println("����Ϊ��");
			return;
		}
		Stack<HeroNode> stack = new Stack();
		HeroNode temp = head.next;
		while (temp != null)
		{
			stack.add(temp);
			temp = temp.next;
		}
		
		//��ʼ��ӡ
		System.out.println("��ת��ӡ------------------");
		while (stack.size() > 0)
		{
			System.out.println(stack.pop());
		}
		System.out.println("��ת��ӡ------------------");
			
	}
	
	/**
	 * @param head
	 * @return void
	 */
	public static void reverseList(HeroNode head)
	{
		//˼·:1���Ȼ�ȡ������ĸ���,�ж������Ƿ�Ϊ�ջ���1����ͼ���
		//	   2 �½�һ��������list2
		//	   3 ���ϵİ�Ԫ�ش�list1��β��ɾ��Ȼ����ӵ�list2��
		//	   4 ��list1��ͷ�ڵ����list2
		int cnt = nodeSum(head);
		if (cnt == 0 || cnt == 1)
		{
			System.out.println("������Ҫ��ת��");
			return;
		}
		
		SingleLinkedList list2 = new SingleLinkedList();
		
		for (int i = cnt; i > 0; i--)
		{
			list2.addAppand(pop(head));
		}
		//head = list2.getHeadNode(); //��������Ϊʲô��ôд�Ǵ����
		head.next = list2.getHeadNode().next;
		
	}
	
	/**
	 * @param head
	 * @return ɾ�����Ľڵ�
	 */
	public static HeroNode pop(HeroNode head)
	{
		HeroNode temp = head;
		if (temp.next == null)
		{
			System.out.println("����Ϊ�գ�ɾ��ʧ��");
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


//����LinkedList���������ǵĽڵ�
class SingleLinkedList
{
	//����ͷ�ڵ㣬��Ҫ���⶯��һ�㲻���ʵ������
	private HeroNode headNode = new HeroNode(0, "", "");
	
	//���һ����ȡͷ�ڵ�ķ���
	public HeroNode getHeadNode()
	{
		return this.headNode;
	}
	
	//��ӽڵ㵽��������(β������)
	public void addAppand(HeroNode node)
	{
		//��ʱָ��ָ��ͷ�ڵ�Ѱ�ҵ������β��
		HeroNode temp = this.headNode; 
		
		//�ҳ�β�ڵ�
		while (true)
		{
			if (temp.next == null)
				break;
			temp = temp.next;
		}
		temp.next = node;
		//node.next = null; //��������Ĵ���û�л����ʲô���
	}
	
	//����ָ��˳����ӽڵ㵽����
	public void addOrder(HeroNode node)
	{
		HeroNode temp = this.headNode;
		
//		if (temp.next == null) //�������Ϊ�գ��൱��β��(����Ϊʲô���if���벻��Ҫ)
//		{
//			temp.next = node;
//			return;
//		}
		
		while (temp.next != null) //������������no��С����λ�ò���
		{
			if (temp.next.no == node.no)
			{
				System.out.printf("�����no:%d�Ѿ����ڣ�����ʧ�ܣ�\n", node.no);
				return;
			}
			if (temp.next.no > node.no ) //�������temp.next֮ǰ����
			{
				node.next = temp.next; //��ʵ������Ի��ַ�ʽֱ��break�滻β��Ĵ��룬����Ϊʲô
				temp.next = node;
				return;
			}
			temp = temp.next;
		}
		//����������˵���������������󣬲����Ƿ��ǿ�������β����
		temp.next = node;
	}
	
	//����no�޸Ľڵ���Ϣ
	public void update(HeroNode node)
	{
		if (this.headNode.next == null)
		{
			System.out.println("����Ϊ�գ��޷��޸ģ�");
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
			temp = temp.next; //��Ҫ����д�ˣ�
		}
		System.out.println("û�д�no���޸�ʧ�ܣ�");
	}
	
	//����noɾ���ڵ�
	public void delete(int no)
	{
		HeroNode temp = this.headNode;
		if (temp.next == null)
		{
			System.out.println("����Ϊ�գ�ɾ��ʧ��");
			return;
		}
		
		//ֻ��Ҫ�ҵ�ɾ���ڵ��ǰһ��λ�ü���
		while (temp.next != null)
		{
			if (temp.next.no == no) //�ҵ��ˣ�ɾ����
			{
				temp.next = temp.next.next; //�����ǲ������һ����������ʽ�����ݣ��뻭ͼ��⣡
				return;
			}
			temp = temp.next;
		}
		System.out.println("û���ҵ���no��ɾ��ʧ��");
	}
	
	//��ʾ����(����)
	public void showList()
	{
		if (this.headNode.next == null)
		{
			System.out.println("����Ϊ�գ�");
			return;
		}
		
		HeroNode temp = this.headNode.next;
	
		while (true)
		{
			System.out.println(temp);
			if (temp.next == null)
				break;
			temp = temp.next;  //˼��һ�»���û������һ��д��
		}
			
	}
	
}


//����һ��HeroNode��ÿһ��HeroNode�������һ���ڵ�
class HeroNode
{
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;   //ָ����һ���ڵ�
	
	//���캯��
	public HeroNode(int no, String name, String nickName)
	{
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	
	//Ϊ����ʾ���㣬��дtoString����
	@Override
	public String toString() 
	{
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
	
}
