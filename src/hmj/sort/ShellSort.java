package hmj.sort;


public class ShellSort
{
	public static void main(String[] args)
	{

		//start
		int[] array = new int[8000000];

		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * 800000000);
		}

		long time1 = 0;
		long time2 = 0;
		double time3 = 0;

		time1 = System.currentTimeMillis();
		shell(array);
		time2 = System.currentTimeMillis();
		time3 = ((double)time2 - (double)time1)/1000;
		System.out.println("耗时" + time3 + "秒");
		
	}
	
	public static void insert(int[] array)
	{
		if (array.length <= 1) return;
		
		for (int i = 1; i < array.length; i++)
		{
			int insertIndex = i;
			int insertValue = array[insertIndex];
			for (; insertIndex - 1 >= 0 && array[insertIndex - 1] > insertValue; insertIndex--)
				array[insertIndex] = array[insertIndex - 1];
			array[insertIndex] = insertValue;
		}
		
	}
	
	public static void shell(int[] array)
	{
		int n = array.length / 2; 
		while (n >= 1)
		{
			for (int i = n; i < array.length; i++)
			{
				int insertIndex = i;
				int insertValue = array[insertIndex];
				for (; insertIndex - n >= 0 && array[insertIndex - n] > insertValue; insertIndex -= n) //这里有点不同主要是：insertIndex - n >= 0
					array[insertIndex] = array[insertIndex - n];
				array[insertIndex] = insertValue;
			}
			n /= 2;
			//System.out.println(Arrays.toString(array));
		}
		
		
	}
	
}


