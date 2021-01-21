package hmj.sparsearray;

public class SparseArray 
{
	
	public static void main(String[] args) 
	{
		//����һ����ά����chessStatus��������ת̬��0��ʾ���ӣ�1��ʾ���ӣ�2��ʾ����
		int[][] chessStatus  = new int[11][11];
		chessStatus[1][2] = 1;
		chessStatus[2][3] = 2;
		
			//����һ��
		for (int[] row : chessStatus)
		{
			for (int col : row)
			{
				System.out.print(col + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------------");
		
		//�Ѵ˶�ά������һ��ϡ������
		/**
		 * 1 ��ȡ������������ά���飬�ѷ�Ĭ��ֵ������ȡ����ֵ�ڼ�1����һ���Ƕ�ά�����״̬��������������������3���У��У�ֵ��
		 * 2 ����������
		 * 3 ����ֵ
		 */
		int sum = 0;
		for (int i = 0; i < chessStatus.length; i++)
			for (int j = 0; j < chessStatus[i].length; j++)
				if (chessStatus[i][j] != 0)
					sum++;  //����һ�£���ȡsum
		
		int sparseArr[][] = new int[sum + 1][3]; //��ʼ����ϡ������,��һ�д�ԭ������У��У���Ч���ݸ���
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
		
					
		//�Ѵ�ϡ������ָ���ά����
		/**
		 *1 ��ȡԭ����������
		 *2 ��ʼ��������
		 *3 ��ϡ�������и�ֵ���µ�����
		 */
		int[][] toArray = new int[sparseArr[0][0]][sparseArr[0][1]];
		
		for (int i = 1; i < sparseArr.length; i++)
		{
			toArray[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		
		//��֤һ��
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
