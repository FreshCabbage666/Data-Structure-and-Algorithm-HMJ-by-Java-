package hmj.recursion;


public class Maze 
{
	public static void main(String[] args) 
	{
		//创建二维数组模拟迷宫
		int[][] map = new int[8][7];
		
		//增加墙 使用1表示
		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[i].length; j++)
			{
				if ((i == 0 || i == 7 || j == 0 || j == 6) || ((i == 3 && j == 1) || (i == 3 && j == 2)))
				{
					map[i][j] = 1;
				}
			}
		}
		//增加挡板测试
		map[1][2] = 1;
//		map[2][2] = 1;
		
		//遍历map
		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[i].length; j++)
			{
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		//验证迷宫算法
		try {
			setWay(map, 1, 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//不使用异常
		//setWay(map, 1, 1);
		
		//遍历map
		System.out.println("小球走过的路");
		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[i].length; j++)
			{
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	//
	/**
	 * @param map 地图情况
	 * @param i	  横坐标
	 * @param j  纵坐标
	 * @return  是否有路,true表示有 
	 * @apiNote 使用递归回溯来给小球找路 从 [1,1]开始，[6,5]表示迷宫出口;
	 * 			map[i][j] 0表示没有走过  1表示墙  2表示路可以走  3表示走过了但走不通;
	 * 			走策略：下-右-上-左，若走不通再回溯，如果求最优解，不用算法，最暴力的方法是通过枚举不同的策略24统计最优解
	 * 			setWay(map, i + 1, j) || setWay(map, i , j + 1) || setWay(map, i - 1, j) || setWay(map, i , j - 1)
	 *  		
	 */
	public static boolean setWay(int[][] map, int i, int j)
	{
		if (map[6][5] == 2 )
			//return true; //到达目的地，地图记录完毕
		{
			throw new RuntimeException("到达目的地，地图记录完毕!");
		}
		
		if (map[i][j] == 0) //按照指定策略玩一把，先假定可以走通
		{
			map[i][j] = 2;
			if (setWay(map, i , j - 1) || setWay(map, i - 1, j) || setWay(map, i + 1, j) || setWay(map, i , j + 1))
			{
				return true;
			}
			else
			{
				map[i][j] = 3;
				return false;
			}
		}
		
//		if (map[i][j] == 2)   //这里为什么2也要返回false呢？有很多方法可以证明哦(可以按照左上下右的策略试试)
//			return true;
		//这里的情况是 1 2 3 都直接返回false
		return false;
	}
}
