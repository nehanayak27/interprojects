package StringClass;

import java.util.Scanner;

public class Palindrom {
	
	public void meth()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the value");
		String x=sc.nextLine();
		String y="";
		
		for(int i=x.length()-1;i>=0;i--)
		{
			char c=x.charAt(i);
			y=y+c;
	
		}
		System.out.println("reversed of palindrom "+y);
		
		if(x.equals(y))
		{
			System.out.println("its a palindrom");
		}
		else
		{
			System.out.println("its not a palindrom");
		}
		
		
	}

}
