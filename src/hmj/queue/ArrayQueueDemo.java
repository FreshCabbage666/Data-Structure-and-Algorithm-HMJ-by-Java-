package hmj.queue;
import java.util.Scanner;

public class ArrayQueueDemo
{
	public static void main(String[] args) 
	{
		//����ArrayQueue����
		ArrayQueue queue = new ArrayQueue(3);
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


//���е�ʵ����
class ArrayQueue
{
	private int maxSize; //���е��������
	private int front;	 //���е�ͷָ��(ָ���һ��Ԫ�ص�ǰһ��λ��)
	private int rear;    //���е�βָ��(ָ�����һ��Ԫ��λ��)
	private int[] array; //���е����ݴ������(ģ�����)
	
	//��������
	public ArrayQueue(int queueMaxSize)
	{
		this.maxSize = queueMaxSize;
		this.front = this.rear = -1;
		this.array = new int[this.maxSize];
	}
	
	//�ж϶����Ƿ���
	public boolean isFull()
	{
		return rear == this.maxSize - 1;
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
		this.array[++this.rear] = num;
	}
	
	//�Ӷ��л�ȡ����(������)
	public int getQueue()
	{
		if (this.isEmpty())
		{
			throw new RuntimeException("����Ϊ�գ���ȡ����ʧ�ܣ�");
		}
		
		return array[++front];
	}
	
	//��ʾ������������
	public void showQueue()
	{
		if (this.isEmpty())
		{
			System.out.println("����Ϊ�գ�");
			return;
		}
		
		for (int i = 0; i < this.array.length; i++)
		{
			System.out.printf("array[%d]=%d\n", i, this.array[i]);
		}
				
		System.out.println();
		
	}
	
	//��ʾ���е�ͷ����(ע�ⲻ��ȡ������)
	public int peekQueueFront()
	{
		if (this.isEmpty())
		{
			throw new RuntimeException("����Ϊ�գ�");
		}
		return this.array[this.front + 1];
	}
	
}