package hmj.sort;


public class QuickSort 
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
		Quick(array, array.length - array.length, array.length - 1);
		time2 = System.currentTimeMillis();
		time3 = ((double)time2 - (double)time1)/1000;
		System.out.println("��ʱ" + time3 + "��");
		
	}
	//��������ߵ�һ��pivotѡΪ��׼��l��rָ��Ϊ������β����rָ�뿪ʼ�����(pivot>value[rָ��] �ͰѸ�ֵ����value[lָ��]��lָ��++���ִ�lָ�뿪ʼ),����rָ��++,ֱ��l��r���
	public static void Quick(int[] array, int left, int right)
	{
		if (left < 0  || right - left < 1 ) return;
		
		int l = left; //����left��right�ĳ�ʼֵ
		int r = right;
		int pivot = array[left]; //����ߵĵ�һ����Ϊ��׼;
		
		while (left < right)
		{
			//����ָ�뿪ʼ����
			while (array[right] > pivot && right > left)
				right--;
			
			if (right == left)
				break;
			else
				array[left++] = array[right];
			
			
			//��ָ�뿪ʼ����
			while (array[left] < pivot && right > left)
				left++;
			
			if (right == left)
				break;
			else
				array[right--] = array[left];
		}
		array[right] = pivot; //��ָ������ָ��������λ�ã����Ǳ��κ����ҵõ���pivotӦ���ڵ�λ��
		
		//���ʱ���������ͷֳ������������[l��left-1] �ұ���[left+1, r]
		Quick(array, l, left - 1);
		Quick(array, left + 1, r);
		
	}

}
