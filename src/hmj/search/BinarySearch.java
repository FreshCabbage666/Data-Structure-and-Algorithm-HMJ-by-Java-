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
	
	
	//Ĭ�ϴ�С����
	/**
	 * @param array �����ҵ�����
	 * @param left  ������߽�
	 * @param right �����ұ߽�
	 * @param value ��Ѱ��Ԫ��
	 * @return -1���ߴ�Ѱ��Ԫ���±�
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
	
	//Ĭ�ϴ�С���� ��ӵĹ���������ҵ���Ԫ�أ���ȡ�����ҵ�Ԫ�ص��±�
	/**
	 * @param array �����ҵ�����
	 * @param left  ������߽�
	 * @param right �����ұ߽�
	 * @param value ��Ѱ��Ԫ��
	 * @param indices ���д���Ԫ�ص�����
	 * @return -1���ߴ�Ѱ��Ԫ���±�
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
