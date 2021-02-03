package hmj.sort;


public class RadixSort 
{

	public static void main(String[] args) 
	{	
		//start
		int[] array = new int[40000000];

		for (int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * 800000000);
		}

		long time1 = 0;
		long time2 = 0;
		double time3 = 0;

		time1 = System.currentTimeMillis();
		radix(array);
		time2 = System.currentTimeMillis();
		time3 = ((double)time2 - (double)time1)/1000;
		System.out.println("耗时" + time3 + "秒");
	}
	
	public static void radix(int[] array)
	{
		//先准备10个桶，分别存放当前位数为0~9的值
		int[][] buckets = new int[10][array.length];
		//准备一个数组存放每个桶当前元素的个数
		int[] bucketCnt = new int[10];
		
		//找出数组最大元素位数
		int max = array[0];
		for (int i : array)
			if (i > max)
				max = i;
		//寻找出max的位数
		int num = (max + "").length();
		
		//cnt表示位数依次1,2。。。到数组最大元素位数,mul是根据规律得出的也就是每一次保证取一位出来
		for (int cnt = 1, mul = 1; cnt <= num; cnt++, mul *= 10)
		{
			//把元素按照规定存入桶中
			for (int i = 0; i < array.length; i++)
			{
				//取出个位
				int loc = array[i] / mul % 10;
				//把这个位代表的数存放到对应的桶中
				buckets[loc][bucketCnt[loc]++] = array[i];
			}
			//把桶中的按照规定放回array数组中i表示第几个桶，p表示当前array的位置
			for (int i = 0, p = 0; i < 10; i++)
			{
				//如果桶中有数据
				if (bucketCnt[i] != 0)
				{
					//依次把桶中的数据传给array
					for (int j = 0; j < bucketCnt[i]; j++)
					{
						array[p++] = buckets[i][j];
					}
					//需要清空一下桶中元素(更改每个桶的元素个数为0)
					bucketCnt[i] = 0;
				}
			}
			//test
//			System.out.println("第" + cnt + "次");
//			System.out.println(Arrays.toString(array));
//			System.out.println();
		}
		

	}

}
