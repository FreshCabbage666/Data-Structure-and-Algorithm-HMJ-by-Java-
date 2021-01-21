package hmj.queue;
import java.util.Scanner;

public class ArrayQueueDemo
{
	public static void main(String[] args) 
	{
		//测试ArrayQueue功能
		ArrayQueue queue = new ArrayQueue(3);
		char ch = ' ';
		Scanner in = new Scanner(System.in);
		boolean isEnd = false;

		while (!isEnd)
		{
			System.out.print("a 入队列\n" +
							 "g 出队列\n" +
							 "s 显示所有数据\n" +
							 "p 查看第一个元素\n" +
							 "e 退出程序\n");
			ch = in.next().charAt(0); //这里不可以是nextLine想想为什么

			switch (ch) 
			{
			case 'a':
				//入队列
				System.out.println("请输入您要加入的数字");
				queue.addQueue(in.nextInt());
				break;
			case 'g':
				//出队列
				try {
					System.out.println(queue.getQueue());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 's':
				//显示所有数据
				queue.showQueue();
				break;
			case 'p':
				//查看第一个元素
				try {
					System.out.println(queue.peekQueueFront());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				//退出程序
				in.close(); //关闭输入
				isEnd = true;
				break;
			default:
				System.out.println("没有这个选项，请重试！");
				break;
			}
		}

		System.out.println("程序结束！");

	}

}


//队列的实现类
class ArrayQueue
{
	private int maxSize; //队列的最大容量
	private int front;	 //队列的头指针(指向第一个元素的前一个位置)
	private int rear;    //队列的尾指针(指向最后一个元素位置)
	private int[] array; //队列的数据存放容器(模拟队列)
	
	//创建队列
	public ArrayQueue(int queueMaxSize)
	{
		this.maxSize = queueMaxSize;
		this.front = this.rear = -1;
		this.array = new int[this.maxSize];
	}
	
	//判断队列是否满
	public boolean isFull()
	{
		return rear == this.maxSize - 1;
	}
	
	//判断队列是否为空
	public boolean isEmpty()
	{
		return this.front == this.rear;
	}
	
	//添加数据到队列
	public void addQueue(int num)
	{
		if (this.isFull())
		{
			System.out.println("队列已满，添加失败!");
			return;
		}
		this.array[++this.rear] = num;
	}
	
	//从队列获取数据(出队列)
	public int getQueue()
	{
		if (this.isEmpty())
		{
			throw new RuntimeException("队列为空，获取数据失败！");
		}
		
		return array[++front];
	}
	
	//显示队列所有数据
	public void showQueue()
	{
		if (this.isEmpty())
		{
			System.out.println("队列为空！");
			return;
		}
		
		for (int i = 0; i < this.array.length; i++)
		{
			System.out.printf("array[%d]=%d\n", i, this.array[i]);
		}
				
		System.out.println();
		
	}
	
	//显示队列的头数据(注意不是取出数据)
	public int peekQueueFront()
	{
		if (this.isEmpty())
		{
			throw new RuntimeException("队列为空！");
		}
		return this.array[this.front + 1];
	}
	
}