package hmj.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo 
{

	public static void main(String[] args) 
	{
		//测试CircleArrayQueue功能
		CircleArrayQueue queue = new CircleArrayQueue(4);
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

class CircleArrayQueue
{
	private int maxSize; //队列的最大容量
	private int front;	 //队列的头指针(指向第一个元素的位置)初始值为0
	private int rear;    //队列的尾指针(指向最后一个元素的下一个位置)初始值为0
	private int[] array; //队列的数据存放容器(模拟队列)
	
	//创建队列
	public CircleArrayQueue(int queueMaxSize)
	{
		this.maxSize = queueMaxSize;
		this.array = new int[this.maxSize];
		//语言特性所以front与rear不用初始化
	}
	
	//判断队列是否满
	public boolean isFull()
	{
		return (this.rear + 1) % this.maxSize == this.front;
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
		
		this.array[this.rear] = num;
		this.rear = (this.rear + 1) % this.maxSize;
	}
	
	//从队列获取数据(出队列)
	public int getQueue()
	{
		if (this.isEmpty())
		{
			throw new RuntimeException("队列为空，获取数据失败！");
		}
		
		int tempValue = this.array[this.front];
		this.front = (this.front + 1) % this.maxSize;
		return tempValue;
	}
	
	//显示队列所有数据
	public void showQueue()
	{
		if (this.isEmpty())
		{
			System.out.println("队列为空！");
			return;
		}
		
		//获取队列中有用数据的个数
		int cnt = usefulNum();
		for (int i = this.front; i < this.front + cnt; i++)
		{
			System.out.printf("array[%d]=%d\n", i % this.maxSize, this.array[i % this.maxSize]);
		}
				
		System.out.println();
		
	}
	
	//获取队列中有用数据的个数
	public int usefulNum()
	{
		return (this.rear + this.maxSize - this.front) % this.maxSize;
	}
	
	//显示队列的头数据(注意不是取出数据)
	public int peekQueueFront()
	{
		if (this.isEmpty())
		{
			throw new RuntimeException("队列为空！");
		}
		return this.array[this.front];
	}
	
}
