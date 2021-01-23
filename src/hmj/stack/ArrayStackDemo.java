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
	protected int maxSize;//stack������
	protected int top;	//ջ��ָ�룬��ʼ��-1
	protected int[] stack;//���ջԪ�ص�����
	
	//��ʼ��ջ
	public ArrayStack (int size)
	{
		this.maxSize = size;
		this.top = -1;
		this.stack = new int[this.maxSize];
	}
	
	//�ж�ջ�Ƿ�����
	public boolean isFull()
	{
		return this.top == this.maxSize - 1;
	}
	
	//�ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty()
	{
		return this.top == -1;
	}
	
	//pop
	public int pop()
	{
		if (this.isEmpty())
			throw new RuntimeException("ջΪ�գ�");
		
//		int value = this.stack[top--];
//		return value;
		return this.stack[top--]; //��һ��д�����õ㣿
	}
	
	//push
	public void push(int item)
	{
		if (this.isFull())
		{
			System.out.println("ջ������");
			return;
		}
		
		this.stack[++top] = item;
	}
	
	//����ջ
	public void showStack()
	{
		if (this.isEmpty())
		{
			System.out.println("ջΪ�գ�");
			return;
		}
		
		for (int i = this.top; i >= 0; i--)
		{
			System.out.printf("ArrayStack[%d] = %d\n", i, this.stack[i]);
		}
	}
	
}


