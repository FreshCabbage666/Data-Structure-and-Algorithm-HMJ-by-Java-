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


//����һ������Ļ��ε�����
class CircleSingleLinkedList
{
	private Boy first;
	
	//�������������(����)
	public void addBoy(int sum)
	{
		if (sum < 1)
		{
			System.out.println("��������������ʧ�ܣ�");
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
	
	//��������ı���
	public void showCSLit()
	{
		if (this.first == null)
		{
			System.out.println("����Ϊ�գ�");
			return;
		}
		
		Boy curBoy = this.first;
		
//		do
//		{
//			System.out.println(curBoy.getNo());
//			curBoy = curBoy.getNext();
//		} while (curBoy.getNext() != this.first); //����дΪʲô�����ԣ�
		
		while (curBoy.getNext() != this.first) //���е�������һ���������ˣ����Ժ��滹���ӡһ��
		{
			System.out.println(curBoy.getNo());
			curBoy = curBoy.getNext();
			//curBoy.setNext(curBoy.getNext()); ����Ϊʲô����������д��
		}
		System.out.println(curBoy.getNo());
	}
	
	//�����û��������������Ȧ˳��(�ڼ����������ٴΣ�һ���ж���boy)
	public void printCSList(int startNo, int count, int sum)
	{
		if (this.first == null || startNo < 1 || startNo > sum || count <= 0)
		{
			System.out.println("���ݴ���!");
			return;
		}
		
		Boy heelPtr = this.first;
		while (heelPtr.getNext() != this.first) //��heelPtrָ��firstǰһ��(Ҳ����list���һ��)
		{
			heelPtr = heelPtr.getNext();
		}
		
		//��startNo����ʼ�����Ͱ�first��heelPtr�ƶ�startNo-1��
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
		System.out.println("������");
	}
	
}


//����boy��ʾһ���ڵ�
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
