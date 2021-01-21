package hmj.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo 
{

	public static void main(String[] args) 
	{
		//����CircleArrayQueue����
		CircleArrayQueue queue = new CircleArrayQueue(4);
		char ch = ' ';
		Scanner in = new Scanner(System.in);
		boolean isEnd = false;

		while (!isEnd)
		{
			System.out.print("a �����\n" +
							 "g ������\n" +
							 "s ��ʾ��������\n" +
							 "p �鿴��һ��Ԫ��\n" +
							 "e �˳�����\n");
			ch = in.next().charAt(0); //���ﲻ������nextLine����Ϊʲô

			switch (ch) 
			{
			case 'a':
				//�����
				System.out.println("��������Ҫ���������");
				queue.addQueue(in.nextInt());
				break;
			case 'g':
				//������
				try {
					System.out.println(queue.getQueue());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 's':
				//��ʾ��������
				queue.showQueue();
				break;
			case 'p':
				//�鿴��һ��Ԫ��
				try {
					System.out.println(queue.peekQueueFront());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				//�˳�����
				in.close(); //�ر�����
				isEnd = true;
				break;
			default:
				System.out.println("û�����ѡ������ԣ�");
				break;
			}
		}

		System.out.println("���������");
	}

}

class CircleArrayQueue
{
	private int maxSize; //���е��������
	private int front;	 //���е�ͷָ��(ָ���һ��Ԫ�ص�λ��)��ʼֵΪ0
	private int rear;    //���е�βָ��(ָ�����һ��Ԫ�ص���һ��λ��)��ʼֵΪ0
	private int[] array; //���е����ݴ������(ģ�����)
	
	//��������
	public CircleArrayQueue(int queueMaxSize)
	{
		this.maxSize = queueMaxSize;
		this.array = new int[this.maxSize];
		//������������front��rear���ó�ʼ��
	}
	
	//�ж϶����Ƿ���
	public boolean isFull()
	{
		return (this.rear + 1) % this.maxSize == this.front;
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty()
	{
		return this.front == this.rear;
	}
	
	//������ݵ�����
	public void addQueue(int num)
	{
		if (this.isFull())
		{
			System.out.println("�������������ʧ��!");
			return;
		}
		
		this.array[this.rear] = num;
		this.rear = (this.rear + 1) % this.maxSize;
	}
	
	//�Ӷ��л�ȡ����(������)
	public int getQueue()
	{
		if (this.isEmpty())
		{
			throw new RuntimeException("����Ϊ�գ���ȡ����ʧ�ܣ�");
		}
		
		int tempValue = this.array[this.front];
		this.front = (this.front + 1) % this.maxSize;
		return tempValue;
	}
	
	//��ʾ������������
	public void showQueue()
	{
		if (this.isEmpty())
		{
			System.out.println("����Ϊ�գ�");
			return;
		}
		
		//��ȡ�������������ݵĸ���
		int cnt = usefulNum();
		for (int i = this.front; i < this.front + cnt; i++)
		{
			System.out.printf("array[%d]=%d\n", i % this.maxSize, this.array[i % this.maxSize]);
		}
				
		System.out.println();
		
	}
	
	//��ȡ�������������ݵĸ���
	public int usefulNum()
	{
		return (this.rear + this.maxSize - this.front) % this.maxSize;
	}
	
	//��ʾ���е�ͷ����(ע�ⲻ��ȡ������)
	public int peekQueueFront()
	{
		if (this.isEmpty())
		{
			throw new RuntimeException("����Ϊ�գ�");
		}
		return this.array[this.front];
	}
	
}
