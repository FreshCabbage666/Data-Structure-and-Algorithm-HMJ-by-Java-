package hmj.search;

import java.util.ArrayList;

public class BinarySearch 
{

	public static void main(String[] args) 
	{
		int[] array = {3, 5, 6, 6, 7, 8, 9, 9, 9, 9, 12};
		
		System.out.println(binarySearch(array, 0, array.length - 1, 8));
		
		ArrayList<Integer> indices = new ArrayList<>();
		System.out.println(binarySearchAll(array, 0, array.length - 1, 9, indices));
		
	}
	
	
	//默认从小到大
	/**
	 * @param array 待查找的数组
	 * @param left  数组左边界
	 * @param right 数组右边界
	 * @param value 待寻找元素
	 * @return -1或者待寻找元素下标
	 */
	public static int binarySearch(int[] array, int left, int right, int value)
	{
		if (left > right)	
			return -1;
		
		int mid = (left + right) / 2;
		if (array[mid] == value)
			return mid;
		else if (value > array[mid])
			return binarySearch(array, mid + 1, right, value);
		else
			return binarySearch(array, left, mid - 1, value);		
	}
	
	//默认从小到大 多加的功能是如果找到了元素，获取所有找到元素的下标
	/**
	 * @param array 待查找的数组
	 * @param left  数组左边界
	 * @param right 数组右边界
	 * @param value 待寻找元素
	 * @param indices 所有待找元素的索引
	 * @return -1或者待寻找元素下标
	 */
	public static ArrayList<Integer> binarySearchAll(int[] array, int left, int right, int value, ArrayList<Integer> indices)
	{
		if (left > right)	
			return null;
		
		int mid = (left + right) / 2;
		if (array[mid] == value)
		{
			indices.add(mid);
			binarySearchAll(array, left, mid - 1, value, indices);
			binarySearchAll(array, mid + 1, right, value, indices);
			return indices;
		}
		else if (value > array[mid])
			return binarySearchAll(array, mid + 1, right, value, indices);
		else
			return binarySearchAll(array, left, mid - 1, value, indices);	
	}
	

}
