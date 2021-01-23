package hmj.stack;

public class ArrayStackDemo 
{

	public static void main(String[] args) 
	{
		ArrayStack stack = new ArrayStack(5);
		stack.showStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		//stack.showStack();
		stack.push(5);
		//stack.push(6);
		stack.showStack();
		try {
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

class ArrayStack
{
	protected int maxSize;//stack的容量
	protected int top;	//栈顶指针，初始化-1
	protected int[] stack;//存放栈元素的容器
	
	//初始化栈
	public ArrayStack (int size)
	{
		this.maxSize = size;
		this.top = -1;
		this.stack = new int[this.maxSize];
	}
	
	//判断栈是否已满
	public boolean isFull()
	{
		return this.top == this.maxSize - 1;
	}
	
	//判断栈是否为空
	public boolean isEmpty()
	{
		return this.top == -1;
	}
	
	//pop
	public int pop()
	{
		if (this.isEmpty())
			throw new RuntimeException("栈为空！");
		
//		int value = this.stack[top--];
//		return value;
		return this.stack[top--]; //哪一种写法更好点？
	}
	
	//push
	public void push(int item)
	{
		if (this.isFull())
		{
			System.out.println("栈已满！");
			return;
		}
		
		this.stack[++top] = item;
	}
	
	//遍历栈
	public void showStack()
	{
		if (this.isEmpty())
		{
			System.out.println("栈为空！");
			return;
		}
		
		for (int i = this.top; i >= 0; i--)
		{
			System.out.printf("ArrayStack[%d] = %d\n", i, this.stack[i]);
		}
	}
	
}


