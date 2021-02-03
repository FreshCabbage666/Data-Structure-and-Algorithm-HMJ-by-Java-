package hmj.search;

public class SeqSearch 
{

	public static void main(String[] args) 
	{
		int[] array = {-1, 1, 2, 5, 7, 6};
		
		int ret = seqSearch(array, 5);
		if (ret == -1)
			System.out.println("û���ҵ�");
		else
			System.out.println("�±���" + ret);

	}
	
	/**
	 * @param array ����������
	 * @param value ���ҵ�ֵ
	 * @return �±꣬-1��ʾû���ҵ�
	 */
	public static int seqSearch(int[] array, int value)
	{
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] == value)
				return i;
		}
		return -1;
	}

}
