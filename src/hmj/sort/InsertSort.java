package hmj.sort;


public class InsertSort
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
		insert(array);
		time2 = System.currentTimeMillis();
		time3 = ((double)time2 - (double)time1)/1000;
		System.out.println("��ʱ" + time3 + "��");

	}
	
	public static void insert(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++) 
		{
			//����һ��Ѱ�Ҳ���λ�ã�Ȼ����λ�ò���Ĺ���
			int j = i + 1;
			int index;
			for (index = i; index >= 0; index--)
			{
				if (array[index] < array[j])
					break;
			}
				
			if (index == i)
				continue;
			else
			{
				int temp = array[j];
				int n = j;
				for (; n > index + 1; n--)
					array[n] = array[n - 1];
				array[n] = temp;
			}
			
		}
	}

}
