package hmj.tree;

public class ArrayBianryTreeDomo 
{

	public static void main(String[] args) 
	{
		int[] array = {0, 1, 2, 3, 4, 5, 6, 7};
		ArrayBinaryTree abt = new ArrayBinaryTree(array);
		
		//test
		//abt.preOrder();
		//abt.midOrder();
		abt.backOrder();
	}

}

class ArrayBinaryTree
{
	int[] array;
	public ArrayBinaryTree(int[] array)
	{
		this.array = array;
		
	}
	
	//先序遍历重载版本(这种写法貌似解决默认参数这种方法)
	public void preOrder()
	{
		this.preOrder(0);
	}
	//先序遍历
	public void preOrder(int index)
	{
		if (this.array == null || array.length == 0)
			return;
		
		System.out.println(this.array[index]);
		//先左边
		if (index * 2 + 1 <= this.array.length - 1)
		{
			this.preOrder(index * 2 + 1);
		}
		//再右边
		if (index * 2 + 2 <= this.array.length - 1)
		{
			this.preOrder(index * 2 + 2);
		}
	}

	
	//中序遍历重载版本
	public void midOrder()
	{
		this.midOrder(0);
	}
	//中序遍历
	public void midOrder(int index)
	{
		if (this.array == null || array.length == 0)
			return;
		
		//先左边
		if (index * 2 + 1 <= this.array.length - 1)
		{
			this.midOrder(index * 2 + 1);
		}
		
		System.out.println(this.array[index]);
		
		//再右边
		if (index * 2 + 2 <= this.array.length - 1)
		{
			this.midOrder(index * 2 + 2);
		}
	}

	
	//后序遍历重载版本
	public void backOrder()
	{
		this.backOrder(0);
	}
	//后序遍历
	public void backOrder(int index)
	{
		if (this.array == null || array.length == 0)
			return;
		
		//先左边
		if (index * 2 + 1 <= this.array.length - 1)
		{
			this.backOrder(index * 2 + 1);
		}
				
		//再右边
		if (index * 2 + 2 <= this.array.length - 1)
		{
			this.backOrder(index * 2 + 2);
		}
		
		System.out.println(this.array[index]);
	}
		
}
