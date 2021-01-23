package hmj.stack;

public class Calc 
{

	public static void main(String[] args) 
	{
		//根据实现思路，编写代码
		String expression = "7+2*6-4"; 
		//创建数栈和符号栈
		CalcStack numStack = new CalcStack(10);
		CalcStack operStack = new CalcStack(10);
		//保存每一次扫描的结果
		char ch = 0; 
		
		//开始扫描expression
		for (int i = 0; i < expression.length(); i++)
		{
			ch = expression.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') //如果是符号
			{
				if (operStack.isEmpty()) //如果符号栈为空那就直接push
				{
					operStack.push(ch);
				}
				else //符号栈不为空！
				{
					if ( operStack.prioritySym(ch) <= operStack.prioritySym((char)operStack.peekChar()) ) //当前操作符优先级《=符号栈中操作符
					{
						int num1 = numStack.pop();
						int num2 = numStack.pop();
						int ret = (int)operStack.cal(num1, num2, (char)operStack.pop());
						numStack.push(ret);
						operStack.push(ch);
					}
					else //直接入栈
					{
						operStack.push(ch);
					}
				}
			}
			else //如果是数字(这里还需要做个文章，因为有可能他是多位整数)
			{
				numStack.push(ch - '0'); //需要小转换一下
			}
		}
		
		//当表达式扫描完毕，测试一下
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

//定制用于calc的stack(在ArrayStack基础上增加)
class CalcStack extends ArrayStack
{
	public CalcStack(int num)
	{
		super(num);
	}

	//返回符号优先级，数字越大优先级越高(这里默认只有加减乘除)
	public int prioritySym(char oper)
	{
		return (oper == '+' || oper == '-') ? 0 : 1;
	}
	
	//判断是否是一个运算符(这里只有运算符和数字，所以true表示运算符 false表示数字)
	public boolean isOperator(char oper)
	{
		return (oper == '+' || oper == '-' || oper == '*' || oper == '/');
	}
	
	//计算方法(这里特别注意是 2运算符1 也就是后弹出的在运算符左边)
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
	
	//返回符号栈的top，但是不弹栈,调用此方法的时候明确栈不为空
	public int peekChar()
	{
		return this.stack[this.top];
	}
	
	
}

