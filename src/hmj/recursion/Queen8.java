package hmj.recursion;

public class Queen8
{
	public static final int MAX = 8; //������8���ʺ�
	public int cnt = 0; //8�ʺ�ڷŵ�λ������
	private int[] array = new int[MAX]; //�±��ʾ�ڼ����ʺ�(����)��value��ʾ�ڵ�ǰ�е���һ��
	
	public static void main(String[] args)
	{
		Queen8 q = new Queen8();
		q.check(0);
		System.out.println(q.cnt);
		
	}
	
	//��д�������õ�n���ʺ�(������ص��������)
	public void check(int n)
	{
		//��ʾ8���ʺ��Ѿ�������ϣ����Դ�ӡ��
		if (n == Queen8.MAX)
		{
			this.print();
			return;
		}
		
		//���η��ûʺ󣬲��Ҳ����Ƿ��ͻ(����i��ʾ��n�еĻʺ�λ��)
		for (int i = 0; i < Queen8.MAX; i++)
		{
			this.array[n] = i;
			
			if (judge(n)) //�������ͻ(�Ϸ�) �ͼ���������һ���ʺ󣬿�ʼ�ݹ�
			{
				check(n + 1); 
			}
			//�����ͻ�ˣ��ͻ����ѭ����Ѱ�ҵ�n���ʺ�����λ�� ����if��������ִ�н����������ǻ��ݣ������жϵ�ǰn��λ�ÿ��л��߲����У���������,������ж���һ��λ���Ƿ���ں������        
		}
		//�˺������صĵط�������
	}
	
	//����n���ʺ�ǰ�ڷ�λ���Ƿ�Ϸ� true��ʾ�Ϸ� (����ֻ��Ҫ���n֮ǰ��λ��)
	private boolean judge(int n)
	{
		//�жϴӵ�һ������n-1���ʺ�����λ���Ƿ��ͻ
		for (int i = 0; i < n; i++)
		{
			//��ͬһ�л���ͬһ��б�߶��ǳ�ͻ�ģ���������������ʾ����Ĭ�ϾͲ���ͬһ�������Բ���Ҫ�ж�
			if ( (this.array[i] == this.array[n]) || (Math.abs(n - i) == Math.abs(this.array[n] - this.array[i])) )
				return false;
		}
		return true;
	}
	
	//������лʺ�λ��
	private void print()
	{
		cnt++;//ͳ��print�������ô���
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}

