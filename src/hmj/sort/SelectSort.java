package hmj.sort;

public class SelectSort 
{

	public static void main(String[] args) 
	{
		//start
		int[] array = new int[80000];
		
		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * 8000000);
		}
		
		long time1 = 0;
		long time2 = 0;
		double time3 = 0;
		
		time1 = System.currentTimeMillis();
		select(array);
		time2 = System.currentTimeMillis();
		time3 = ((double)time2 - (double)time1)/1000;
		System.out.println("ºÄÊ±" + time3 + "Ãë");
		
	

	}
	
	public static void select(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
		{
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++)
			{
				if (array[minIndex] > array[j])
				{
					minIndex = j;
				}
			}
			if (minIndex != i)  
			{
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}

}
