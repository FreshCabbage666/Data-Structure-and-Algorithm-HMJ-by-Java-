package hmj.sort;


public class MergeSort 
{

	public static void main(String[] args) 
	{
//		int[] array = {-1,1,1,2,2,4,3,5,6,-2,-1};
//		int[] temp = new int[array.length];
//		mergeSort(array, 0, array.length - 1, temp);
//		for (int i : array)
//		{
//			System.out.print(i + " ");
//		}
		
		
		//start
		int[] array = new int[8000000];
		int[] temp = new int[array.length];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * 800000000);
		}

		long time1 = 0;
		long time2 = 0;
		double time3 = 0;

		time1 = System.currentTimeMillis();
		mergeSort(array, 0, array.length - 1, temp); //�ǵ�����ļ�-Ŷ
		time2 = System.currentTimeMillis();
		time3 = ((double)time2 - (double)time1)/1000;
		System.out.println("��ʱ" + time3 + "��");

	}
	
	//�鲢�����ȷ��ٺϲ� array�Ǵ����������  r��l�Ǵ�����������±귶Χ  temp����ʱ����
	public static void mergeSort(int[] array, int left, int right, int[] temp)
	{
		if (left < right)
		{
			//��(һ��ʼ�ͷ�)
			int mid = ( left + right) / 2;
			mergeSort(array, left, mid, temp);
			mergeSort(array, mid + 1, right, temp);
			//��(��һ�κϲ����������������)
			merge(array, left, mid + 1, right, temp);
		}
		
	}
	
	//�ϲ�����: ����������������,i����������һ��Ԫ�أ�j���ұ������һ��Ԫ��,end���ұ��������һ��Ԫ��(��С��������)
	public static void merge(int[] array, int i, int j, int end, int[] temp)
	{
		//����i,j ��������ΪʲôҪ������Щ����Ŷ��
		int oneArrayStart = i;
		int twoArrayStart = j;
		int p = 0; //ִ��temp��ָ��
		
		
		//��ʼ����temp����
		while (i <= twoArrayStart - 1 && j <= end)
			if (array[i] < array[j])
				temp[p++] = array[i++];
			else
				temp[p++] = array[j++];
		
		if (i > twoArrayStart - 1) //����ǵ�һ���ȱ����� //����>����ô�����ģ�Ϊʲô����==��debugŶ��
			while (j <= end)
				temp[p++] = array[j++];
		else //������ǵڶ����ȱ�����
			while (i <= twoArrayStart - 1)
				temp[p++] = array[i++];
		
		
		//��temp��ֵ����array
		for (int num = 0; num < p; num++)
			array[oneArrayStart++] = temp[num];
		
	}
	
}
