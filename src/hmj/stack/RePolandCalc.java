package hmj.stack;

import java.util.ArrayList;
import java.util.Stack;


public class RePolandCalc 
{

	public static void main(String[] args) 
	{
		/*2以下是中缀表达式转后缀表达式算法实现测试*/
		
		//需要转换的中缀表达式
		String midExp = "1 + ( ( 2 + 3 ) * 4 ) - 5";
		//String midExp = "1 * 2 + 5 - 6 / 3";
		//实际操作的时候方便起见我们使用ArrayList操作
		ArrayList<String> midExpList = toArrayList(midExp);
		//System.out.println(midExpList);
		toReExp(midExpList);
		System.out.println(midExpList);
		
		/*中缀表达式转后缀表达式算法实现测试结束*/
		
		
		/**************1(以下是之前的通过后缀表达式计算结果的算法实现测试)*******************/
//		//需要计算的后缀表达式
//		//(3+4)*5-6 => 3 4 + 5 * 6 -
//		String RePolandExp = "3 4 + 5 * 6 -";
//		//实际操作的时候方便起见我们使用ArrayList操作
//		ArrayList<String> RePolandExpList = toArrayList(RePolandExp);
//		//计算
//		try {
//			System.out.println(calc(RePolandExpList));
//		} catch (Exception e) {
//			System.out.print(e.getMessage());
//		}
		/**************(通过后缀表达式计算结果的算法实现测试结束)*******************/
		
		
//		/*3综合测试一下*/
//		String exp = "1 * 2 + 5 - 6 / 3 * ( 100 / 5 )";
//		//System.out.println(toReExp(toArrayList(exp))); //把中缀表达式转换为后缀形式
//		System.out.println(calc(toReExp(toArrayList(exp)))); //进行一个计算
//		/*综合测试一下*/
		
	}
	
	//把中缀表达式转换为后缀表达式
	public static ArrayList<String> toReExp(ArrayList<String> midExpList)
	{
		//初始化两个栈，分别是运算符栈s1和存储中间结果栈s2
		Stack<String> s1 = new Stack<String>();
		Stack<String> s2 = new Stack<String>();
		
		//从左至右扫描中缀表达式(从这里开始算法，请注意判断String字符串不可以使用==(想想为什么？)，here代码的地方可以考虑使用break标签吗？(相当于goto语句))
		for (String item : midExpList)
		{
			if (item.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$")) //如果是操作数，将其push到s2
			{
				s2.push(item);
			}
			else if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) //如果是运算符需要比较优先级(注意这里不包括小括号!)
			{
				boolean isLoop = true; //here
				while (isLoop)
				{
					if (s1.size() == 0 || s1.peek().equals("(")) //如果s1为空，或者栈顶运算符是左括号，直接push运算符栈s1
					{
						s1.push(item);
						isLoop = false;
					}
					else if (priority(item) > priority(s1.peek())) //item优先级比栈顶运算符高，同上
					{
						s1.push(item);
						isLoop = false;
					}
					else //将s1栈顶运算符弹出，并且压入s2中，再次转到A这个位置与s1中新的栈顶运算符比较
					{
						s2.push(s1.pop());
					}
				}
				
			}
			else if (item.equals("(") || item.equals(")")) //如果遇到括号
			{
				if (item.equals("("))
				{
					s1.push(item);
				}
				else //依次弹出s1的栈顶运算符，并压入s2，直到遇到左括号为止(这个左括号也要消灭),此时，可以将这对括号丢弃
				{
					while (s1.peek().equals("(") == false)      //while (s1.peek() != "(")
					{
						s2.push(s1.pop());
					}
					s1.pop(); //把这个左括号也要消灭
				}
			}
			//test
			//System.out.println("item:" + item + "    s2:" + s2 + "   s1:" + s1);
		}
				
		//把s1中的运算符依次弹出并压入s2
		while (s1.size() != 0)
		{
			s2.push(s1.pop());
		}
		
		//s2的逆序（从栈低遍历）就是对应的后缀表达式
		midExpList.clear();
		for (String item : s2) //这样其实就是逆序遍历
		{
			midExpList.add(item);
		}
		
		return midExpList;
	}
	
	//返回运算符优先级，数字越大优先级越高(血的教训：字符串比较给我用equals！！！)
	public static int priority(String s)
	{
		int ret = 0;
		if (s.equals("+") || s.equals("-"))
			ret = 0;
		else if (s.equals("*") || s.equals("/"))
			ret = 1;
		else // 这里默认是小括号
			ret = 2;
		return ret;
	}
	
	//把RePolandExp使用ArrayList存放，便于遍历
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

	//按照思路实现代码，返回计算结果
	public static double calc(ArrayList<String> arrayList)
	{
		Stack<String> tempStack = new Stack<String>();
		for (String s : arrayList)
		{
			//使用正则表达式简化程序
			if (s.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$")) //表明他是一个数字
			{
				tempStack.push(s);
			}
			else //那就是运算符
			{
				//特别注意这里的逻辑！！！，num2是最后一个出栈的，后面也用 num2 运算符 num1
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
					tempStack.push("" + (num2 / num1)); //把其他类型转换为字符串还可以这样写！
					break;
				default:
					throw new RuntimeException("后缀表达式错误，计算失败!");
				}
			}
		}
		//把计算结果返回
		return Double.parseDouble(tempStack.get(0));
	}
	
}
