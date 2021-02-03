package hmj.sort;


public class RadixSort 
{

	public static void main(String[] args) 
	{	
		//start
		int[] array = new int[40000000];

		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * 800000000);
		}

		long time1 = 0;
		long time2 = 0;
		double time3 = 0;

		time1 = System.currentTimeMillis();
		radix(array);
		time2 = System.currentTimeMillis();
		time3 = ((double)time2 - (double)time1)/1000;
		System.out.println("��ʱ" + time3 + "��");
	}
	
	public static void radix(int[] array)
	{
		//��׼��10��Ͱ���ֱ��ŵ�ǰλ��Ϊ0~9��ֵ
		int[][] buckets = new int[10][array.length];
		//׼��һ��������ÿ��Ͱ��ǰԪ�صĸ���
		int[] bucketCnt = new int[10];
		
		//�ҳ��������Ԫ��λ��
		int max = array[0];
		for (int i : array)
			if (i > max)
				max = i;
		//Ѱ�ҳ�max��λ��
		int num = (max + "").length();
		
		//cnt��ʾλ������1,2���������������Ԫ��λ��,mul�Ǹ��ݹ��ɵó���Ҳ����ÿһ�α�֤ȡһλ����
		for (int cnt = 1, mul = 1; cnt <= num; cnt++, mul *= 10)
		{
			//��Ԫ�ذ��չ涨����Ͱ��
			for (int i = 0; i < array.length; i++)
			{
				//ȡ����λ
				int loc = array[i] / mul % 10;
				//�����λ���������ŵ���Ӧ��Ͱ��
				buckets[loc][bucketCnt[loc]++] = array[i];
			}
			//��Ͱ�еİ��չ涨�Ż�array������i��ʾ�ڼ���Ͱ��p��ʾ��ǰarray��λ��
			for (int i = 0, p = 0; i < 10; i++)
			{
				//���Ͱ��������
				if (bucketCnt[i] != 0)
				{
					//���ΰ�Ͱ�е����ݴ���array
					for (int j = 0; j < bucketCnt[i]; j++)
					{
						array[p++] = buckets[i][j];
					}
					//��Ҫ���һ��Ͱ��Ԫ��(����ÿ��Ͱ��Ԫ�ظ���Ϊ0)
					bucketCnt[i] = 0;
				}
			}
			//test
//			System.out.println("��" + cnt + "��");
//			System.out.println(Arrays.toString(array));
//			System.out.println();
		}
		

	}

}
