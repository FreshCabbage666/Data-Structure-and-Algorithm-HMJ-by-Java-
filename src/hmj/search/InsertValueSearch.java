package hmj.search;

public class InsertValueSearch 
{

	public static void main(String[] args)
	{
		int[] array = {3, 5, 6, 6, 7, 8, 9, 9, 9, 9, 12};
		
		System.out.println(insertValueSearch(array, 0, array.length - 1, 19));

	}
	
	public static int insertValueSearch(int[] array, int left, int right, int value)
	{
		if (left > right)	//�������������ģ����������������ж�value��߽磬�ǲ���Ч�ʾ������Щ�أ�����ֻ��Ҫһ�ξͿ��ˣ���Ч�ʵ����Ǹ��˻��ǵ��ˣ�
			return -1;
		
		int mid = left + (right - left) * (value - array[left]) / (array[right] - array[left]);
		if (mid < left || mid > right) //���ʹ�������㷨����Ҫ��֤mid�Ϸ��ԣ���֤mid��left��right֮�䣬��ֹ�±�Խ��
			return -1;		
		
		if (array[mid] == value)
			return mid;
		else if (value > array[mid])
			return insertValueSearch(array, mid + 1, right, value);
		else
			return insertValueSearch(array, left, mid - 1, value);		
	}

}
