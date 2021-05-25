package StringClass;

import java.util.Scanner;

public class If {
	public void meth()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a value");
		String z=sc.nextLine();
		int space=1;
		
		for(int i=0;i<z.length();i++)
		{
			char xx=z.charAt(i);
			if(xx==' ')
			{
				space++;
			}
			
		}
		System.out.println("spaces"+space);
		
	}
	
	public void meth2()
	{
		
		String x="jkawhdkjh^*&(*& 765&^%&^%HJBVJHvbvjh@!@$";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the char value");
		String cc=sc.nextLine();
		char com=cc.charAt(0);
		int a=0;
		
		for(int i=0;i<x.length();i++)
		{
			char s=x.charAt(i);
			if(com==s)
			{
				a++;
				System.out.println("index is at"+i);
				switch(i)
				{
				case 0: System.out.println("found at "+(i+1)+"st place");
				break;
				case 1: System.out.println("found at "+(i+1)+"nd place");
				break;
				case 2: System.out.println("found at "+(i+1)+"rd place");
				break;
				case 4: System.out.println("found at "+(i+1)+"th place");
				break;
				}
			}
			
			System.out.println("no of times "+com+" available in the given string is "+a);
			
		}
		
		
	}

}
