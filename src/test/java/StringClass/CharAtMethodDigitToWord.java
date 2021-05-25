package StringClass;

import java.util.Scanner;

public class CharAtMethodDigitToWord {
	
	public void meth()
	{
		Scanner x1=new Scanner(System.in);
		System.out.println("enter the digits");
		String v=x1.nextLine();
		
		for(int i=0;i<v.length();i++)
		{
			char z=v.charAt(i);
			
			switch(z)
			
			{
			case '0': System.out.print("Zero "); 
						break;
			case '1': System.out.print("One "); 
			break;
			
			case '2': System.out.print("two "); 
			break;
			
			case '3': System.out.print("Three"); 
			break;
			
			case '4': System.out.print("Four "); 
			break;
			
			case '5': System.out.print("Five "); 
			break;
			
			case '6': System.out.print("Six "); 
			break;
			
			case '7': System.out.print("Seven "); 
			break;
			
			case '8': System.out.print("Eight "); 
			break;
			
			case '9': System.out.print("Nine "); 
			break;
			
			default: 
				System.out.print("wrong value");
			break;
			
				
				
			}
			
				
			
			
		}
		
		
		
		
		
	}

}
