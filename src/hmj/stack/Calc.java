package hmj.stack;

public class Calc 
{

	public static void main(String[] args) 
	{
		//����ʵ��˼·����д����
		String expression = "7+2*6-4"; 
		//������ջ�ͷ���ջ
		CalcStack numStack = new CalcStack(10);
		CalcStack operStack = new CalcStack(10);
		//����ÿһ��ɨ��Ľ��
		char ch = 0; 
		
		//��ʼɨ��expression
		for (int i = 0; i < expression.length(); i++)
		{
			ch = expression.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') //����Ƿ���
			{
				if (operStack.isEmpty()) //�������ջΪ���Ǿ�ֱ��push
				{
					operStack.push(ch);
				}
				else //����ջ��Ϊ�գ�
				{
					if ( operStack.prioritySym(ch) <= operStack.prioritySym((char)operStack.peekChar()) ) //��ǰ���������ȼ���=����ջ�в�����
					{
						int num1 = numStack.pop();
						int num2 = numStack.pop();
						int ret = (int)operStack.cal(num1, num2, (char)operStack.pop());
						numStack.push(ret);
						operStack.push(ch);
					}
					else //ֱ����ջ
					{
						operStack.push(ch);
					}
				}
			}
			else //���������(���ﻹ��Ҫ�������£���Ϊ�п������Ƕ�λ����)
			{
				numStack.push(ch - '0'); //��ҪСת��һ��
			}
		}
		
		//�����ʽɨ����ϣ�����һ��
//		numStack.showStack();
//		operStack.showStack();
		
		while (!operStack.isEmpty())
		{
			int num1 = numStack.pop();
			int num2 = numStack.pop();
			int ret = (int)operStack.cal(num1, num2, (char)operStack.pop());
			numStack.push(ret);
			
		}
		numStack.showStack();
	}

}

//��������calc��stack(��ArrayStack����������)
class CalcStack extends ArrayStack
{
	public CalcStack(int num)
	{
		super(num);
	}

	//���ط������ȼ�������Խ�����ȼ�Խ��(����Ĭ��ֻ�мӼ��˳�)
	public int prioritySym(char oper)
	{
		return (oper == '+' || oper == '-') ? 0 : 1;
	}
	
	//�ж��Ƿ���һ�������(����ֻ������������֣�����true��ʾ����� false��ʾ����)
	public boolean isOperator(char oper)
	{
		return (oper == '+' || oper == '-' || oper == '*' || oper == '/');
	}
	
	//���㷽��(�����ر�ע���� 2�����1 Ҳ���Ǻ󵯳�������������)
	public double cal(double num1, double num2, char oper)
	{
		double value = 0;
		switch (oper) {
		case '+':
			value = num2 + num1;
			break;
		case '-':
			value = num2 - num1;
			break;
		case '*':
			value = num2 * num1;
			break;
		case '/':
			value = num2 / num1;
			break;
		default:
			break;
		}
		return value;
	}
	
	//���ط���ջ��top�����ǲ���ջ,���ô˷�����ʱ����ȷջ��Ϊ��
	public int peekChar()
	{
		return this.stack[this.top];
	}
	
	
}

