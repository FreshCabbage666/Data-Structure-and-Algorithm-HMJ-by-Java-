package hmj.search;

public class SeqSearch 
{

	public static void main(String[] args) 
	{
		int[] array = {-1, 1, 2, 5, 7, 6};
		
		int ret = seqSearch(array, 5);
		if (ret == -1)
			System.out.println("没有找到");
		else
			System.out.println("下标是" + ret);

	}
	
	/**
	 * @param array 待查找数组
	 * @param value 查找的值
	 * @return 下标，-1表示没有找到
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
