package hmj.sort;


public class BubbleSort 
{

	public static void main(String[] args) 
	{
		int[] array1 = new int[80000];
		int[] array2 = new int[80000];
		for (int i = 0; i < array1.length; i++)
		{
			array1[i] = (int)(Math.random() * 8000000);
			array2[i] = array1[i];
		}
		
		long time1 = 0;
		long time2 = 0;
		double time3 = 0;
		
		
		//测试basBubble
		time1 = System.currentTimeMillis();
		basBubble(array2);
		time2 = System.currentTimeMillis();
		time3 = ((double)time2 - (double)time1) / 1000;
		System.out.println("bas耗时：" + time3 + "秒");
		
		//测试optBubble
		time1 = System.currentTimeMillis();
		optBubble(array1);
		time2 = System.currentTimeMillis();
		time3 = ((double)time2 - (double)time1) / 1000;
		System.out.println("opt耗时：" + time3 + "秒");
		

	}
	
	//基本冒泡
	public static void basBubble(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
		{
			for (int j = 0; j < array.length - i - 1; j++)
			{
				if (array[j] > array[j + 1]) 
				{
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
	
	//优化冒泡
	public static void optBubble(int[] array)
	{
		//算法优化(如果发现某一趟没有发生交换,说明此时已经完全有序了)
		for (int i = 0; i < array.length - 1; i++)
		{
			boolean flag = true; //先假设此趟排序没有发生交换
			for (int j = 0; j < array.length - i - 1; j++)
			{
				if (array[j] > array[j + 1]) 
				{
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					flag = false; //发生了交换之前假设不成立
				}
			}

			if (flag)  break;	//如果假设成立此时数组已经有序了
		}
	}
	
}
