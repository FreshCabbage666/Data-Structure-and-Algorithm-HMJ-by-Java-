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
		
		
		//����basBubble
		time1 = System.currentTimeMillis();
		basBubble(array2);
		time2 = System.currentTimeMillis();
		time3 = ((double)time2 - (double)time1) / 1000;
		System.out.println("bas��ʱ��" + time3 + "��");
		
		//����optBubble
		time1 = System.currentTimeMillis();
		optBubble(array1);
		time2 = System.currentTimeMillis();
		time3 = ((double)time2 - (double)time1) / 1000;
		System.out.println("opt��ʱ��" + time3 + "��");
		

	}
	
	//����ð��
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
	
	//�Ż�ð��
	public static void optBubble(int[] array)
	{
		//�㷨�Ż�(�������ĳһ��û�з�������,˵����ʱ�Ѿ���ȫ������)
		for (int i = 0; i < array.length - 1; i++)
		{
			boolean flag = true; //�ȼ����������û�з�������
			for (int j = 0; j < array.length - i - 1; j++)
			{
				if (array[j] > array[j + 1]) 
				{
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					flag = false; //�����˽���֮ǰ���費����
				}
			}

			if (flag)  break;	//������������ʱ�����Ѿ�������
		}
	}
	
}
