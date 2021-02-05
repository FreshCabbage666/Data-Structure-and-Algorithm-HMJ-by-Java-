package hmj.search;

import java.util.Arrays;

public class FibonacciSearch 
{

	public static void main(String[] args) 
	{
		int[] array = {1, 8, 10, 89, 1000, 1234};
		
		fibonacciSearch(array, 1);

	}
	
	
	//����һ��fibonacciArray��length����Ĭ��Ϊ20
	public static int[] CreatFibonacciArray(int length)
	{
		if (length > 2)
		{
			int[] array = new int[length];
			
			array[0] = array[1] = 1;
			for (int i = 2; i < length; i++)
				array[i] =  array[i - 1] + array[i - 2];
			
			return array;
		}
		
		throw new RuntimeException("length���Ϸ�!");
	}
	
	//FibonacciSearch��ʼ
	public static int fibonacciSearch(int[] array, int value)
	{
		int left = 0;
		int right = array.length - 1;
		int k = 0; //��Ӧ �������鳤�ȵ����һ��쳲�������ֵ���±�
		int[] fibonacciArray = CreatFibonacciArray(20);
		while (array.length >= fibonacciArray[k])
		{
			k++;
		}
		//1����Ԫ�ظ���Ӧ���� fibonacciArray[k],����Ԫ��һ��ʹ�����ұߵ�ֵ
		int count = fibonacciArray[k];
		
		//2�����������䣬���ֵӦ����ԭ�������һ��Ԫ��(��С��������Ļ��Ǿ��������Ǹ�Ԫ��)
		int[] newArray = new int[count];
		for (int i = 0; i < newArray.length; i++)
		{
			if (i <= array.length - 1)
				newArray[i] = array[i];
			else
				newArray[i] = array[array.length - 1];
		}
		
		//test
		System.out.println(Arrays.toString(newArray));
		
		return 0;
	}

}
