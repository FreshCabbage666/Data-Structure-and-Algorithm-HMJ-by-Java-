package hmj.sparsearray;

public class SparseArray 
{
	
	public static void main(String[] args) 
	{
		//创建一个二维数组chessStatus保存棋子转态，0表示无子，1表示黑子，2表示蓝子
		int[][] chessStatus  = new int[11][11];
		chessStatus[1][2] = 1;
		chessStatus[2][3] = 2;
		
			//遍历一下
		for (int[] row : chessStatus)
		{
			for (int col : row)
			{
				System.out.print(col + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------------");
		
		//把此二维数组变成一个稀疏数组
		/**
		 * 1 获取行数（遍历二维数组，把非默认值个数获取，此值在加1（第一行是二维数组的状态）就是行数）列数就是3（行，列，值）
		 * 2 创建该数组
		 * 3 存入值
		 */
		int sum = 0;
		for (int i = 0; i < chessStatus.length; i++)
			for (int j = 0; j < chessStatus[i].length; j++)
				if (chessStatus[i][j] != 0)
					sum++;  //遍历一下，获取sum
		
		int sparseArr[][] = new int[sum + 1][3]; //初始化此稀疏数组,第一行存原数组的行，列，有效数据个数
		sparseArr[0][0] = chessStatus.length;
		sparseArr[0][1] = chessStatus[0].length;
		sparseArr[0][2] = sum;
		
		{
			int row = 1;
			for (int i = 0; i < chessStatus.length; i++)
			{
				for (int j = 0; j < chessStatus[i].length; j++)
				{
					if (chessStatus[i][j] != 0)
					{
						sparseArr[row][0] = i;
						sparseArr[row][1] = j;
						sparseArr[row][2] = chessStatus[i][j];
						row++;
					}
				}
			}
		}
		
					
		//把此稀疏数组恢复二维数组
		/**
		 *1 获取原数组行与列
		 *2 初始化新数组
		 *3 从稀疏数组中赋值给新的数组
		 */
		int[][] toArray = new int[sparseArr[0][0]][sparseArr[0][1]];
		
		for (int i = 1; i < sparseArr.length; i++)
		{
			toArray[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		
		//验证一下
		for (int i = 0; i < toArray.length; i++)
		{
			for (int j = 0; j < toArray[i].length; j++)
			{
				System.out.print(toArray[i][j] + " ");
			}
			System.out.println();	
		}
		
	}

}
