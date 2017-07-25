import java.util.Scanner;
public class EB_Bill {
	public static void main (String [] args) 
		{
			int a;
			double d=0;
			double Total;
			double disc=0;
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the consumed Units:");
			while(!input.hasNextInt())
			{
				System.out.print("Please enter Units in number!!\n");
				input.next();
			}
			a=input.nextInt();	
			System.out.print("Entered units: "+a);
			if (a<=50)
			{
				System.out.println("\nCost is 1.20 Per Unit");
				d=a*1.20;
				
			}
			else if(a<=100)
			{
				System.out.println("\nCost is 2.40 Per Unit");
				d=a*2.40;
			}
			else if(a<=150)
			{
				System.out.println("\nCost is 3.60 Per Unit");
				d=a*3.60;
			}
			else if(a<=200)
			{
				System.out.println("\nCost is 4.80 Per Unit");
				d=a*4.80;
			}
			else if(a>200)
			{
				d=a*4.80;
				disc=d*0.05;
				if(disc>200)
				{
					disc=200;
					System.out.println("\nMore than 200 Units were consumed, So you get a discount of Rupees 200 on your bill..");
					
				}
				else
				{System.out.println("\nMore than 200 Units were consumed, So you get a discount of 5% on your bill..");}
				}
			double Fine;
			Fine=d*0.01;
			Total=(d+Fine)-disc;
			System.out.println("Total amount:" +Total);
					
			input.close();
		
		}
}

