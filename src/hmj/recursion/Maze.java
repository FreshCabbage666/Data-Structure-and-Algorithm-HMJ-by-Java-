package hmj.recursion;


public class Maze 
{
	public static void main(String[] args) 
	{
		//������ά����ģ���Թ�
		int[][] map = new int[8][7];
		
		//����ǽ ʹ��1��ʾ
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
		//���ӵ������
		map[1][2] = 1;
//		map[2][2] = 1;
		
		//����map
		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[i].length; j++)
			{
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		//��֤�Թ��㷨
		try {
			setWay(map, 1, 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//��ʹ���쳣
		//setWay(map, 1, 1);
		
		//����map
		System.out.println("С���߹���·");
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
	 * @param map ��ͼ���
	 * @param i	  ������
	 * @param j  ������
	 * @return  �Ƿ���·,true��ʾ�� 
	 * @apiNote ʹ�õݹ��������С����· �� [1,1]��ʼ��[6,5]��ʾ�Թ�����;
	 * 			map[i][j] 0��ʾû���߹�  1��ʾǽ  2��ʾ·������  3��ʾ�߹��˵��߲�ͨ;
	 * 			�߲��ԣ���-��-��-�����߲�ͨ�ٻ��ݣ���������Ž⣬�����㷨������ķ�����ͨ��ö�ٲ�ͬ�Ĳ���24ͳ�����Ž�
	 * 			setWay(map, i + 1, j) || setWay(map, i , j + 1) || setWay(map, i - 1, j) || setWay(map, i , j - 1)
	 *  		
	 */
	public static boolean setWay(int[][] map, int i, int j)
	{
		if (map[6][5] == 2 )
			//return true; //����Ŀ�ĵأ���ͼ��¼���
		{
			throw new RuntimeException("����Ŀ�ĵأ���ͼ��¼���!");
		}
		
		if (map[i][j] == 0) //����ָ��������һ�ѣ��ȼٶ�������ͨ
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
		
//		if (map[i][j] == 2)   //����Ϊʲô2ҲҪ����false�أ��кܶ෽������֤��Ŷ(���԰����������ҵĲ�������)
//			return true;
		//���������� 1 2 3 ��ֱ�ӷ���false
		return false;
	}
}
