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
		System.out.println("耗时" + time3 + "秒");
		
	}
	//把数组左边第一个pivot选为基准，l和r指针为数组首尾，从r指针开始，如果(pivot>value[r指针] 就把该值放在value[l指针]，l指针++，又从l指针开始),否则r指针++,直到l和r相等
	public static void Quick(int[] array, int left, int right)
	{
		if (left < 0  || right - left < 1 ) return;
		
		int l = left; //保存left和right的初始值
		int r = right;
		int pivot = array[left]; //已左边的第一个数为基准;
		
		while (left < right)
		{
			//从右指针开始遍历
			while (array[right] > pivot && right > left)
				right--;
			
			if (right == left)
				break;
			else
				array[left++] = array[right];
			
			
			//左指针开始遍历
			while (array[left] < pivot && right > left)
				left++;
			
			if (right == left)
				break;
			else
				array[right--] = array[left];
		}
		array[right] = pivot; //左指针与右指针相遇的位置，就是本次函数找得到的pivot应该在的位置
		
		//这个时候这个数组就分成了两个左边是[l，left-1] 右边是[left+1, r]
		Quick(array, l, left - 1);
		Quick(array, left + 1, r);
		
	}

}
