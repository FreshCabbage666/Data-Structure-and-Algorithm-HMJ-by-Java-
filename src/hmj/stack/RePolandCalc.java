package hmj.stack;

import java.util.ArrayList;
import java.util.Stack;


public class RePolandCalc 
{

	public static void main(String[] args) 
	{
		/*2��������׺���ʽת��׺���ʽ�㷨ʵ�ֲ���*/
		
		//��Ҫת������׺���ʽ
		String midExp = "1 + ( ( 2 + 3 ) * 4 ) - 5";
		//String midExp = "1 * 2 + 5 - 6 / 3";
		//ʵ�ʲ�����ʱ�򷽱��������ʹ��ArrayList����
		ArrayList<String> midExpList = toArrayList(midExp);
		//System.out.println(midExpList);
		toReExp(midExpList);
		System.out.println(midExpList);
		
		/*��׺���ʽת��׺���ʽ�㷨ʵ�ֲ��Խ���*/
		
		
		/**************1(������֮ǰ��ͨ����׺���ʽ���������㷨ʵ�ֲ���)*******************/
//		//��Ҫ����ĺ�׺���ʽ
//		//(3+4)*5-6 => 3 4 + 5 * 6 -
//		String RePolandExp = "3 4 + 5 * 6 -";
//		//ʵ�ʲ�����ʱ�򷽱��������ʹ��ArrayList����
//		ArrayList<String> RePolandExpList = toArrayList(RePolandExp);
//		//����
//		try {
//			System.out.println(calc(RePolandExpList));
//		} catch (Exception e) {
//			System.out.print(e.getMessage());
//		}
		/**************(ͨ����׺���ʽ���������㷨ʵ�ֲ��Խ���)*******************/
		
		
//		/*3�ۺϲ���һ��*/
//		String exp = "1 * 2 + 5 - 6 / 3 * ( 100 / 5 )";
//		//System.out.println(toReExp(toArrayList(exp))); //����׺���ʽת��Ϊ��׺��ʽ
//		System.out.println(calc(toReExp(toArrayList(exp)))); //����һ������
//		/*�ۺϲ���һ��*/
		
	}
	
	//����׺���ʽת��Ϊ��׺���ʽ
	public static ArrayList<String> toReExp(ArrayList<String> midExpList)
	{
		//��ʼ������ջ���ֱ��������ջs1�ʹ洢�м���ջs2
		Stack<String> s1 = new Stack<String>();
		Stack<String> s2 = new Stack<String>();
		
		//��������ɨ����׺���ʽ(�����￪ʼ�㷨����ע���ж�String�ַ���������ʹ��==(����Ϊʲô��)��here����ĵط����Կ���ʹ��break��ǩ��(�൱��goto���))
		for (String item : midExpList)
		{
			if (item.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$")) //����ǲ�����������push��s2
			{
				s2.push(item);
			}
			else if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) //������������Ҫ�Ƚ����ȼ�(ע�����ﲻ����С����!)
			{
				boolean isLoop = true; //here
				while (isLoop)
				{
					if (s1.size() == 0 || s1.peek().equals("(")) //���s1Ϊ�գ�����ջ��������������ţ�ֱ��push�����ջs1
					{
						s1.push(item);
						isLoop = false;
					}
					else if (priority(item) > priority(s1.peek())) //item���ȼ���ջ��������ߣ�ͬ��
					{
						s1.push(item);
						isLoop = false;
					}
					else //��s1ջ�����������������ѹ��s2�У��ٴ�ת��A���λ����s1���µ�ջ��������Ƚ�
					{
						s2.push(s1.pop());
					}
				}
				
			}
			else if (item.equals("(") || item.equals(")")) //�����������
			{
				if (item.equals("("))
				{
					s1.push(item);
				}
				else //���ε���s1��ջ�����������ѹ��s2��ֱ������������Ϊֹ(���������ҲҪ����),��ʱ�����Խ�������Ŷ���
				{
					while (s1.peek().equals("(") == false)      //while (s1.peek() != "(")
					{
						s2.push(s1.pop());
					}
					s1.pop(); //�����������ҲҪ����
				}
			}
			//test
			//System.out.println("item:" + item + "    s2:" + s2 + "   s1:" + s1);
		}
				
		//��s1�е���������ε�����ѹ��s2
		while (s1.size() != 0)
		{
			s2.push(s1.pop());
		}
		
		//s2�����򣨴�ջ�ͱ��������Ƕ�Ӧ�ĺ�׺���ʽ
		midExpList.clear();
		for (String item : s2) //������ʵ�����������
		{
			midExpList.add(item);
		}
		
		return midExpList;
	}
	
	//������������ȼ�������Խ�����ȼ�Խ��(Ѫ�Ľ�ѵ���ַ����Ƚϸ�����equals������)
	public static int priority(String s)
	{
		int ret = 0;
		if (s.equals("+") || s.equals("-"))
			ret = 0;
		else if (s.equals("*") || s.equals("/"))
			ret = 1;
		else // ����Ĭ����С����
			ret = 2;
		return ret;
	}
	
	//��RePolandExpʹ��ArrayList��ţ����ڱ���
	public static ArrayList<String> toArrayList(String RePolandExp)
	{
		ArrayList<String> tempList = new ArrayList<String>();
		String[] tempString = RePolandExp.split(" ");
		for (String s : tempString)
		{
			tempList.add(s);
		}
		return tempList;
	}

	//����˼·ʵ�ִ��룬���ؼ�����
	public static double calc(ArrayList<String> arrayList)
	{
		Stack<String> tempStack = new Stack<String>();
		for (String s : arrayList)
		{
			//ʹ��������ʽ�򻯳���
			if (s.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$")) //��������һ������
			{
				tempStack.push(s);
			}
			else //�Ǿ��������
			{
				//�ر�ע��������߼���������num2�����һ����ջ�ģ�����Ҳ�� num2 ����� num1
				double num1 = Double.parseDouble(tempStack.pop());
				double num2 = Double.parseDouble(tempStack.pop());
				
				switch (s) {
				case "+":
					tempStack.push(Double.toString(num2 + num1));
					break;
				case "-":
					tempStack.push(Double.toString(num2 - num1));
					break;
				case "*":
					tempStack.push(Double.toString(num2 * num1));
					break;
				case "/":
					tempStack.push("" + (num2 / num1)); //����������ת��Ϊ�ַ�������������д��
					break;
				default:
					throw new RuntimeException("��׺���ʽ���󣬼���ʧ��!");
				}
			}
		}
		//�Ѽ���������
		return Double.parseDouble(tempStack.get(0));
	}
	
}
