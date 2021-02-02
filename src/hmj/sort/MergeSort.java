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
		mergeSort(array, 0, array.length - 1, temp); //记得这里的减-哦
		time2 = System.currentTimeMillis();
		time3 = ((double)time2 - (double)time1)/1000;
		System.out.println("耗时" + time3 + "秒");

	}
	
	//归并排序先分再合并 array是待排序的数组  r和l是待排序的数组下标范围  temp是临时数组
	public static void mergeSort(int[] array, int left, int right, int[] temp)
	{
		if (left < right)
		{
			//分(一开始就分)
			int mid = ( left + right) / 2;
			mergeSort(array, left, mid, temp);
			mergeSort(array, mid + 1, right, temp);
			//合(第一次合并是最左边两个回溯)
			merge(array, left, mid + 1, right, temp);
		}
		
	}
	
	//合并操作: 现在是有两个数组,i是左边数组第一个元素，j是右边数组第一个元素,end是右边数组最后一个元素(从小到大排序)
	public static void merge(int[] array, int i, int j, int end, int[] temp)
	{
		//保存i,j 想想这里为什么要保存这些？坑哦！
		int oneArrayStart = i;
		int twoArrayStart = j;
		int p = 0; //执向temp的指针
		
		
		//开始产生temp数组
		while (i <= twoArrayStart - 1 && j <= end)
			if (array[i] < array[j])
				temp[p++] = array[i++];
			else
				temp[p++] = array[j++];
		
		if (i > twoArrayStart - 1) //如果是第一个先遍历完 //想想>是怎么得来的，为什么不是==，debug哦！
			while (j <= end)
				temp[p++] = array[j++];
		else //否则就是第二个先遍历完
			while (i <= twoArrayStart - 1)
				temp[p++] = array[i++];
		
		
		//把temp的值传给array
		for (int num = 0; num < p; num++)
			array[oneArrayStart++] = temp[num];
		
	}
	
}
