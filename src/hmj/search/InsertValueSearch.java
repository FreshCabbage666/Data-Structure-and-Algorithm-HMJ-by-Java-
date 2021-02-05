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
		if (left > right)	//这个数组是有序的，想想如果在这里就判断value与边界，是不是效率就提高了些呢？但是只需要一次就可了，那效率到底是高了还是低了？
			return -1;
		
		int mid = left + (right - left) * (value - array[left]) / (array[right] - array[left]);
		if (mid < left || mid > right) //如果使用上面算法，需要验证mid合法性，保证mid在left和right之间，防止下标越界
			return -1;		
		
		if (array[mid] == value)
			return mid;
		else if (value > array[mid])
			return insertValueSearch(array, mid + 1, right, value);
		else
			return insertValueSearch(array, left, mid - 1, value);		
	}

}
