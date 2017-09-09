package Methods;

import java.util.Stack;

public class test {
	
	public static void main(String[] args)
	{
	
		Stack stk = new Stack();
		Stack stk1 = new Stack();
		int[] in = {1, 1, 3};
		
		int a = (in.length)-1;
		System.out.println(a);
		for(int i=0; i<=a;i++)
		{
		
			if(stk.isEmpty()||(int)stk.peek()<in[i])
			{
				stk.push(in[i]);
				//System.out.println(stk.peek());
				
			}
				
			else
			{
				while(!stk.isEmpty()&&(int)stk.peek()>in[i])
				{
					 stk1.push(stk.pop());
					
				}
				stk.push(in[i]);
			}
			while(!stk1.isEmpty())
			{
				stk.push(stk1.pop());
			}
			
			//System.out.println(stk.peek());
		}
		
		
		
			System.out.println(stk);
		
		
	}
}

			
			
			
	/*		
			//int pk = (int)stk.peek();
				 if((!stk.isEmpty())&&(a==true))
				 {
					 while(!stk.isEmpty())
					{
						if ((int)stk.peek()>in[i])
					 {
					 stk1.push(stk.pop());
					// System.out.println(stk1.peek());
					 
					 }
						else{
						break;}
					}
				 
				  stk.push(in[i]);
				  while(!stk1.isEmpty())
				  {
				  stk.push(stk1.pop());
				  }
			
				 }
				 System.out.println(stk.peek());
		}
		System.out.println(stk.peek());
	
}
}*/
