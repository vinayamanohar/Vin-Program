//Evaluate the value of postfix expression

package Methods;
import java.util.Scanner;
import java.util.Stack;

public class Postfix_eval {
	
	static boolean verifyPostfix(String exp){
		int opd=0;
		int opr =1;
		for (int j=0;j<exp.length();j++)
		{
			char c1 = exp.charAt(j);
			if(Character.isDigit(c1))
				opd++;
			else{
				opr++;
			}
						
		}
		if(opd==opr)
		{
			return true;}
			else{
				return false;
		}
	}
	
	static int evaluatePostfix(String exp)
	{
		
		Stack<Integer> stk = new Stack<>();
		for (int i=0; i< exp.length();i++)
		{
			char c= exp.charAt(i);
			//int a = Character.getNumericValue(c);
			//System.out.println(a);
			if(Character.isDigit(c))
			{
				
				//stk.push(c- '0');
				//Get the numeric value of a char and push it in
				stk.push(Character.getNumericValue(c));
				//System.out.println(stk.peek());
			}
			
			else{
				int opr1 = stk.pop();
				int opr2 = stk.pop();
				switch(c)
				{
				case '+':
					stk.push(opr2+opr1);
					break;
					
				case '-':
					stk.push(opr2-opr1);
					break;
				case '/':
					stk.push(opr2/opr1);
					break;
				case '*':
					stk.push(opr2*opr1);
					break;
									
				}
				
			}
			
		
		}
		
		return stk.pop();
			
		
	}
	
	
	public static void main(String[] args)
	{
		//String exp = "231*+9-";
		String exp;
		Scanner scan = new Scanner(System.in);
		exp = scan.next();
		if(verifyPostfix(exp))
		{
			System.out.println(evaluatePostfix(exp));	
		}
		else{
			System.out.println("Bad expression");
		}
		
		
	}
	
	
}