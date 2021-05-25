package StringClass;

import java.util.Scanner;

public class CharAtCountOfDigitsUpperLowerSpecialUsingASCIIEquivalents {
	
	public void meth()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the value");
		String x=sc.nextLine();
		
		int upper=0;
		int lower =0;
		int spcl=0;
		int digits=0;
		
		for(int i=0;i<=x.length()-1;i++)
		{
			Character mn=x.charAt(i);
			if(mn>=65 && mn<=95)
			{
				upper++;
			}
			else if(mn>=97 && mn<=122)
			{
				lower++;
			}
			else if(mn>=48 && mn<=57)
			{
				digits++;
			}
			else if(mn!=' ')
			{
				spcl++;
			}
		}
		System.out.println("No of digits in the given String are: "+digits);
		System.out.println("No of upper case alphabet in the given String are: "+upper);
		System.out.println("No of lower case alphabet in the given String are: "+lower);
		System.out.println("No of special charaters in the given String are: "+spcl);	
		
		
		
	}

}
