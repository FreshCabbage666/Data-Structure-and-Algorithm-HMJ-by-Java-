package hmj.recursion;

public class Queen8
{
	public static final int MAX = 8; //代表有8个皇后
	public int cnt = 0; //8皇后摆放的位置总数
	private int[] array = new int[MAX]; //下标表示第几个皇后(行数)，value表示在当前行的哪一列
	
	public static void main(String[] args)
	{
		Queen8 q = new Queen8();
		q.check(0);
		System.out.println(q.cnt);
		
	}
	
	//编写方法放置第n个皇后(★★★★重点代码★★★★)
	public void check(int n)
	{
		//表示8个皇后已经放置完毕，可以打印了
		if (n == Queen8.MAX)
		{
			this.print();
			return;
		}
		
		//依次放置皇后，并且测试是否冲突(这里i表示第n行的皇后位置)
		for (int i = 0; i < Queen8.MAX; i++)
		{
			this.array[n] = i;
			
			if (judge(n)) //如果不冲突(合法) 就继续放置下一个皇后，开始递归
			{
				check(n + 1); 
			}
			//如果冲突了，就会继续循环，寻找第n个皇后合理的位置 或者if里面的语句执行结束，这里是回溯，可以判断当前n行位置可行或者不可行，不管怎样,会继续判断下一个位置是否存在合理情况        
		}
		//此函数返回的地方有两个
	}
	
	//检测第n个皇后当前摆放位置是否合法 true表示合法 (这里只需要检测n之前的位置)
	private boolean judge(int n)
	{
		//判断从第一个到第n-1个皇后和这个位置是否冲突
		for (int i = 0; i < n; i++)
		{
			//在同一列或者同一个斜线都是冲突的，这里特殊的数组表示方法默认就不在同一行了所以不需要判断
			if ( (this.array[i] == this.array[n]) || (Math.abs(n - i) == Math.abs(this.array[n] - this.array[i])) )
				return false;
		}
		return true;
	}
	
	//输出所有皇后位置
	private void print()
	{
		cnt++;//统计print方法调用次数
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}

