package hmj.search;

import java.util.Arrays;

public class FibonacciSearch 
{

	public static void main(String[] args) 
	{
		int[] array = {1, 8, 10, 89, 1000, 1234};
		
		fibonacciSearch(array, 1);

	}
	
	
	//构建一个fibonacciArray，length建议默认为20
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
		
		throw new RuntimeException("length不合法!");
	}
	
	//FibonacciSearch开始
	public static int fibonacciSearch(int[] array, int value)
	{
		int left = 0;
		int right = array.length - 1;
		int k = 0; //对应 大于数组长度的最近一个斐波那契数值的下标
		int[] fibonacciArray = CreatFibonacciArray(20);
		while (array.length >= fibonacciArray[k])
		{
			k++;
		}
		//1数组元素个数应该是 fibonacciArray[k],填充的元素一律使用最右边的值
		int count = fibonacciArray[k];
		
		//2对数组进行填充，填充值应该是原数组最后一个元素(从小到大排序的话那就是最大的那个元素)
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
