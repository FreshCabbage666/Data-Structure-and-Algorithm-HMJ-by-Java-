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
	
	//����������ذ汾(����д��ò�ƽ��Ĭ�ϲ������ַ���)
	public void preOrder()
	{
		this.preOrder(0);
	}
	//�������
	public void preOrder(int index)
	{
		if (this.array == null || array.length == 0)
			return;
		
		System.out.println(this.array[index]);
		//�����
		if (index * 2 + 1 <= this.array.length - 1)
		{
			this.preOrder(index * 2 + 1);
		}
		//���ұ�
		if (index * 2 + 2 <= this.array.length - 1)
		{
			this.preOrder(index * 2 + 2);
		}
	}

	
	//����������ذ汾
	public void midOrder()
	{
		this.midOrder(0);
	}
	//�������
	public void midOrder(int index)
	{
		if (this.array == null || array.length == 0)
			return;
		
		//�����
		if (index * 2 + 1 <= this.array.length - 1)
		{
			this.midOrder(index * 2 + 1);
		}
		
		System.out.println(this.array[index]);
		
		//���ұ�
		if (index * 2 + 2 <= this.array.length - 1)
		{
			this.midOrder(index * 2 + 2);
		}
	}

	
	//����������ذ汾
	public void backOrder()
	{
		this.backOrder(0);
	}
	//�������
	public void backOrder(int index)
	{
		if (this.array == null || array.length == 0)
			return;
		
		//�����
		if (index * 2 + 1 <= this.array.length - 1)
		{
			this.backOrder(index * 2 + 1);
		}
				
		//���ұ�
		if (index * 2 + 2 <= this.array.length - 1)
		{
			this.backOrder(index * 2 + 2);
		}
		
		System.out.println(this.array[index]);
	}
		
}
